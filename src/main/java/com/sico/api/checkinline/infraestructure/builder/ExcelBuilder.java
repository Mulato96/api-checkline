package com.sico.api.checkinline.infraestructure.builder;

import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_CONTENT_INVALID;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.EXCEPTION_TEMPLATE_OPEN_ERROR;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.INDEX_ZERO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sico.api.checkinline.application.exceptions.ExcelProcessException;
import com.sico.api.checkinline.application.exceptions.VerificationLaftException;
import com.sico.api.checkinline.infraestructure.utils.JsonUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ExcelBuilder {

  public <T>List<T> extractData(MultipartFile file, TypeReference<List<T>> valueTypeRef) throws IOException {
    Sheet sheet = openFile(file.getInputStream());
    List<String> header = getHeaders(sheet);
    sheet.removeRow(sheet.getRow(INDEX_ZERO));
    JSONArray jsonContent = getDataByRow(sheet, header);
    if (jsonContent.isEmpty()) {
      throw new ExcelProcessException(EXCEPTION_TEMPLATE_CONTENT_INVALID);
    }
    return JsonUtil.parseFromJson(valueTypeRef, jsonContent.toString());
  }

  private JSONArray getDataByRow(Sheet sheet, List<String> header) {
    DataFormatter dataFormatter = new DataFormatter();
    JSONArray jsonArray = new JSONArray();
    sheet.forEach(row -> {
      if (!isRowEmpty(row)) {
        JSONObject jsonObject = new JSONObject();
        row.forEach(cell ->
        {
          if (cell.getColumnIndex() < header.size()) {
            String value = dataFormatter.formatCellValue(cell);
            String headerSelected = header.get(cell.getColumnIndex());
            jsonObject.put(headerSelected, value);
          }
        });
        jsonArray.put(jsonObject);
      }
    });
    return jsonArray;
  }

  private Sheet openFile(InputStream file) {
    try {
      return WorkbookFactory.create(file).getSheetAt(INDEX_ZERO);
    } catch (IOException e) {
      throw new VerificationLaftException(EXCEPTION_TEMPLATE_OPEN_ERROR);
    }
  }

  private static List<String> getHeaders(Sheet sheet) {
    Row row = sheet.getRow(INDEX_ZERO);
    DataFormatter dataFormatter = new DataFormatter();
    List<String> headers = new ArrayList<>();
    row.forEach(value -> headers.add(dataFormatter.formatCellValue(value)));
    return headers;
  }

  private static boolean isRowEmpty(Row row) {
    boolean isEmpty = true;
    DataFormatter dataFormatter = new DataFormatter();
    if (row != null) {
      for (Cell cell : row) {
        if (!dataFormatter.formatCellValue(cell).trim().isEmpty()) {
          isEmpty = false;
          break;
        }
      }
    }
    return isEmpty;
  }

}
