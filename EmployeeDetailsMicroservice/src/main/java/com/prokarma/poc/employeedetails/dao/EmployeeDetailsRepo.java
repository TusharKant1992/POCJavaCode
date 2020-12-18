package com.prokarma.poc.employeedetails.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prokarma.poc.employeedetails.model.EmployeeModel;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeModel, Integer> {
	
	EmployeeModel findByEmpId(Integer empId);
	
	public List<EmployeeModel> findByName(String name);

	public List<EmployeeModel> findByNameStartingWith(String name);

	public List<EmployeeModel> findByNameAndAge(String name, int age);

}
