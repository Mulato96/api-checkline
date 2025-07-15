package com.sico.api.checkinline.domain.models;

public record Error(Object code, String message, Object description, String path) {
}
