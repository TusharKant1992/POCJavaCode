package com.prokarma.poc.employeedetails.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prokarma.poc.employeedetails.dto.EmployeeSalaryResponse;

@FeignClient(name = "EmployeeServer-Client", url = "http://localhost:4354/employeesalary")
public interface EmployeeSalaryClient {

	@GetMapping("/getEmpSalary/{empId}")
	public EmployeeSalaryResponse getEmployeeSalary(@PathVariable("empId") Integer empId);

}
