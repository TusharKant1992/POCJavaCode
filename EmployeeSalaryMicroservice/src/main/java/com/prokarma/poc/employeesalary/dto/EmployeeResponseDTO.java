package com.prokarma.poc.employeesalary.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeResponseDTO {

	private Integer empId;
	private String name;
	private Integer age;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private Double empSal;
}
