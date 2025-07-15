package com.sico.api.checkinline.infraestructure.persistences;

import com.sico.api.checkinline.infraestructure.gateways.EmployeeGateway;
import com.sico.api.checkinline.domain.models.general.report.Employee;
import com.sico.api.checkinline.infraestructure.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeGatewayImpl implements EmployeeGateway {

  private final JpaEmployeeRepository repository;
  private final EmployeeMapper mapper;

  @Override
  public List<Employee> checkOutEmployees(String companyId, Boolean isBogota, Integer years) {
    return mapper.toDto(repository.checkOutEmployees(companyId, isBogota, years));
  }
}
