package com.sico.api.checkinline.application.components;

import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_CONTENT_INVALID;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_HEADER_ERROR;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_HEADERS_INCOMPLETE;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_HEADER_REQUIRED;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.HEADERS_VERIFICATION_LAFT_EXCEL;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_FORMAT_INVALID;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_SIZE_INVALID;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.INDEX_ZERO;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.MIME_TYPE_EXCEL_VALID;

import com.sico.api.checkinline.application.exceptions.VerificationLaftException;
import com.sico.api.checkinline.application.properties.VerificationLaftProperties;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class VerificationLaftExcelValidatorComponent {

  private final VerificationLaftProperties verificationLaftProperties;
  private final MessageTranslator messageTranslator;

  public void validate(MultipartFile file) {
    validateFormat(file);
    validateSize(file);
    validateHeaders(file);
  }

  private void validateFormat(MultipartFile file) {
    if (file.isEmpty()) {
      throw new VerificationLaftException(EXCEPTION_TEMPLATE_FORMAT_INVALID);
    }
    if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(MIME_TYPE_EXCEL_VALID)) {
      throw new VerificationLaftException(EXCEPTION_TEMPLATE_FORMAT_INVALID);
    }
  }

  private void validateSize(MultipartFile file) {
    final long maxFileSize = verificationLaftProperties.getSizeBulkUpload() * 1024 * 1024;
    if (file.getSize() > maxFileSize) {
      throw new VerificationLaftException(EXCEPTION_TEMPLATE_SIZE_INVALID);
    }
  }

  private void validateHeaders(MultipartFile file) {
    List<String> headers = new ArrayList<>();
    try (InputStream inputStream = file.getInputStream()) {
      Workbook workbook = WorkbookFactory.create(inputStream);
      Row row = workbook.getSheetAt(INDEX_ZERO).getRow(INDEX_ZERO);
      DataFormatter dataFormatter = new DataFormatter();
      row.forEach(value -> headers.add(dataFormatter.formatCellValue(value)));
      if (headers.isEmpty()) {
        throw new VerificationLaftException(EXCEPTION_TEMPLATE_CONTENT_INVALID);
      } else {
        if (headers.size() > HEADERS_VERIFICATION_LAFT_EXCEL.size()) {
          throw new VerificationLaftException(EXCEPTION_TEMPLATE_HEADERS_INCOMPLETE);
        }
      }
    } catch (Exception ex) {
      throw new VerificationLaftException(EXCEPTION_TEMPLATE_HEADER_ERROR);
    }
    if (!new HashSet<>(HEADERS_VERIFICATION_LAFT_EXCEL).containsAll(headers)) {
      throw new VerificationLaftException(EXCEPTION_TEMPLATE_HEADER_REQUIRED);
    }
  }
}
