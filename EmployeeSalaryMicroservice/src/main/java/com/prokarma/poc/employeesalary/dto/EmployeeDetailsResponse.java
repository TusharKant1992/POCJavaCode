package com.prokarma.poc.employeesalary.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsResponse {
	private Integer empId;
	private String name;
	private Integer age;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfJoining;
}
