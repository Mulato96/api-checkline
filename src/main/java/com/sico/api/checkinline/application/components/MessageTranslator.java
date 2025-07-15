package com.sico.api.checkinline.application.components;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageTranslator {

  private final MessageSource messageSource;

  /**
   * @param msg message code that should be translated
   * @param args message arguments
   * @return translated message
   */
  public String getMessage(String msg, Object[] args) {
    return messageSource.getMessage(msg, args, LocaleContextHolder.getLocale());
  }

  /**
   * @param msg message code that should be translated
   * @return translated message
   */
  public String getMessage(String msg) {
    return messageSource.getMessage(msg, null, LocaleContextHolder.getLocale());
  }

}
