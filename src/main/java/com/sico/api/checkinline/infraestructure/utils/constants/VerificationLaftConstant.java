package com.sico.api.checkinline.infraestructure.utils.constants;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class VerificationLaftConstant {

  public static final String MIME_TYPE_EXCEL_VALID = ".xlsx";
  public static final int INDEX_ZERO = 0;
  public static final int NUMBER_VALID_CHARACTERS = 6;
  public static final List<String> HEADERS_VERIFICATION_LAFT_EXCEL = List.of(
      "Tipo de identificación", "Número de identificación", "Nombre / Razón Social");

  public static final String DEFAULT_ZONE_ID = "America/Bogota";
  public static final String DATE_FORMAT = "yyyy-MM-dd";

  public static final String EXCEPTION_TEMPLATE_SIZE_INVALID = "laft.verification.exception.template.size.invalid";
  public static final String EXCEPTION_TEMPLATE_CONTENT_INVALID = "laft.verification.exception.template.content.invalid";
  public static final String EXCEPTION_TEMPLATE_FORMAT_INVALID = "laft.verification.exception.template.format.invalid";
  public static final String EXCEPTION_TEMPLATE_HEADERS_INCOMPLETE = "laft.verification.exception.template.header.incomplete";
  public static final String EXCEPTION_TEMPLATE_HEADER_ERROR = "laft.verification.exception.template.header.error";
  public static final String EXCEPTION_TEMPLATE_HEADER_REQUIRED = "laft.verification.exception.template.header.required";
  public static final String EXCEPTION_TEMPLATE_OPEN_ERROR = "laft.verification.exception.template.open.error";
  public static final String EXCEPTION_TEMPLATE_CONTENT_LIMITED_SURPASSED = "laft.verification.exception.template.content.surpassed";

  public static final String EXCEPTION_CONTENT_ERROR = "laft.verification.exception.content.error";
  public static final String EXCEPTION_CONTENT_SUCCESS_EMPTY = "laft.verification.exception.content.success.empty";
  public static final String EXCEPTION_CONTENT_ERROR_CONVERT_TO_JSON = "laft.verification.exception.content.error.convert.to.json";

  public static final String PATH_TEMPLATE_LAFT_BULK = "template/Plantilla_Cargue_Masivo_LAFT.xlsx";

}
