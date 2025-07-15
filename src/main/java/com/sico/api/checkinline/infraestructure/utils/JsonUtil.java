package com.sico.api.checkinline.infraestructure.utils;

import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.DATE_FORMAT;
import static com.sico.api.checkinline.infraestructure.utils.constants.VerificationLaftConstant.DEFAULT_ZONE_ID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonUtil {

  public static <T> T parseFromJson(TypeReference<T> typeClass, String json)
      throws JsonProcessingException {
    T object;
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    TimeZone timeZone = TimeZone.getTimeZone(DEFAULT_ZONE_ID);
    dateFormat.setTimeZone(timeZone);

    ObjectMapper objectMapper = new ObjectMapper().configure(
        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setDateFormat(dateFormat);
    objectMapper.setTimeZone(timeZone);

    object = objectMapper.readValue(json, typeClass);

    return object;
  }
}
