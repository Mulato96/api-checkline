package com.sico.api.checkinline.infraestructure.mappers;

import com.sico.api.checkinline.domain.models.general.report.Employee;
import com.sico.api.checkinline.domain.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeEntity> {
}
