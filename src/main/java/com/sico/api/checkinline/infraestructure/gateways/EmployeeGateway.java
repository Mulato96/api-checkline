package com.sico.api.checkinline.infraestructure.gateways;

import com.sico.api.checkinline.domain.models.general.report.Employee;

import java.util.List;

public interface EmployeeGateway {

  List<Employee> checkOutEmployees(String companyId, Boolean isBogota, Integer years);
}
