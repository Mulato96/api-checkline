package com.sico.api.checkinline.infraestructure.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UtilDate {
    
    public static LocalDateTime getCurrentDate() {
        return LocalDateTime.now();
    }

}
