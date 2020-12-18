package com.prokarma.poc.employeedetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.poc.employeedetails.dao.EmployeeDetailsRepo;
import com.prokarma.poc.employeedetails.model.EmployeeModel;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepo employeeDetailsRepo;

	@Override
	public Integer saveEmployee(EmployeeModel employeeModel) {
		Integer id = null;
		try {
			id = employeeDetailsRepo.save(employeeModel).getEmpId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<EmployeeModel> getEmployeeByName(String empName) {
		List<EmployeeModel> employeeModel = null;
		try {
			employeeModel = employeeDetailsRepo.findByName(empName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeModel;
	}

	@Override
	public List<EmployeeModel> getEmployeeByNameStartsWith(String empName) {
		return employeeDetailsRepo.findByNameStartingWith(empName);
	}

	@Override
	public List<EmployeeModel> getEmployeeByNameAndAge(String name, Integer age) {
		List<EmployeeModel> listEmployee = employeeDetailsRepo.findByNameAndAge(name, age);
		return listEmployee;
	}

	@Override
	public EmployeeModel getEmployeeById(Integer empId) {
		return employeeDetailsRepo.findByEmpId(empId);
	}

}
