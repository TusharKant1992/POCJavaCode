package com.prokarma.poc.employeedetails.dto;

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
public class EmployeeSalaryResponse {
   private Integer Id;
   private Double salary;
   private Integer empId;
}
