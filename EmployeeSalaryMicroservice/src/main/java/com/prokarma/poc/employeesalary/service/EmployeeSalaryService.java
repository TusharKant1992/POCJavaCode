package com.prokarma.poc.employeesalary.service;

import java.util.List;

import com.prokarma.poc.employeesalary.dto.EmployeeSalaryDTO;
import com.prokarma.poc.employeesalary.model.EmployeeSalaryModel;

public interface EmployeeSalaryService {

	public Integer saveEmployeeSalary(EmployeeSalaryModel employeeSalaryModel);

	public EmployeeSalaryDTO getByEmpId(Integer empId);

	public List<EmployeeSalaryModel> getEmployeebySal(String val, Double sal);
}
