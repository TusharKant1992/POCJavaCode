package com.prokarma.poc.employeedetails.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Employee")
public class EmployeeModel {

	@Id
	@GeneratedValue
	private Integer empId;
	private String name;
	private Integer age;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfJoining;

}
