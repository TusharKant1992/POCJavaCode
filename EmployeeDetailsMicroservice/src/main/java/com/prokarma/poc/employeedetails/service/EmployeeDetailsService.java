package com.prokarma.poc.employeedetails.service;

import java.util.List;

import com.prokarma.poc.employeedetails.model.EmployeeModel;

public interface EmployeeDetailsService {

	public Integer saveEmployee(EmployeeModel employeeModel);

	public EmployeeModel getEmployeeById(Integer empId);

	public List<EmployeeModel> getEmployeeByName(String empName);

	public List<EmployeeModel> getEmployeeByNameStartsWith(String empName);

	public List<EmployeeModel> getEmployeeByNameAndAge(String name, Integer age);
}
