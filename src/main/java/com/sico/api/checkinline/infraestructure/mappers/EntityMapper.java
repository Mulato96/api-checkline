package com.sico.api.checkinline.infraestructure.mappers;

import java.util.List;

public interface EntityMapper <D, E> {

  D toDto(E entity);

  List<D> toDto(List<E> entityList);

}
