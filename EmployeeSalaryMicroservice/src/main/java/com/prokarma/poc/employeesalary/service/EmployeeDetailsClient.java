package com.prokarma.poc.employeesalary.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prokarma.poc.employeesalary.dto.EmployeeDetailsResponse;

@FeignClient(name = "EMPLOYEE-DETAILS", url = "http://localhost:4353/employeedetails")
public interface EmployeeDetailsClient {

	@GetMapping("/getEmployeById/{empId}")
	EmployeeDetailsResponse getEmployeeById(@PathVariable("empId") Integer empId);
}
