package com.prokarma.poc.employeesalary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class EmployeeSalaryModel {

	@Id
	@GeneratedValue
	private Integer Id;
	private Integer empId;
	private Double salary;
}
