package com.prokarma.poc.employeesalary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prokarma.poc.employeesalary.model.EmployeeSalaryModel;

@Repository
public interface EmployeeSalaryRepo extends JpaRepository<EmployeeSalaryModel, Integer> {
	@Query("select emp from EmployeeSalaryModel emp where emp.empId=?1")
	public EmployeeSalaryModel findByEmpId(Integer empId);

	List<EmployeeSalaryModel> findBySalaryGreaterThan(Double salary);

	List<EmployeeSalaryModel> findBySalaryLessThan(Double salary);
}
