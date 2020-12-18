package com.prokarma.poc.employeesalary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokarma.poc.employeesalary.dao.EmployeeSalaryRepo;
import com.prokarma.poc.employeesalary.dto.EmployeeSalaryDTO;
import com.prokarma.poc.employeesalary.model.EmployeeSalaryModel;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

	@Autowired
	private EmployeeSalaryRepo employeeSalaryRepo;

	@Override
	public Integer saveEmployeeSalary(EmployeeSalaryModel employeeSalaryModel) {
		Integer id = null;
		try {
			id = employeeSalaryRepo.save(employeeSalaryModel).getEmpId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public EmployeeSalaryDTO getByEmpId(Integer empId) {
		EmployeeSalaryModel employeeSalaryModel = employeeSalaryRepo.findByEmpId(empId);
		EmployeeSalaryDTO employeeSalaryDTO = new EmployeeSalaryDTO();
		employeeSalaryDTO.setSalary(employeeSalaryModel.getSalary());
		return employeeSalaryDTO;
	}

	@Override
	public List<EmployeeSalaryModel> getEmployeebySal(String val, Double sal) {
		List<EmployeeSalaryModel> listEmployeeSlary = new ArrayList<EmployeeSalaryModel>();
		System.out.println(val.equals("gt"));
		if (val.equals("gt")) {
			listEmployeeSlary = employeeSalaryRepo.findBySalaryGreaterThan(sal);
		} else {
			listEmployeeSlary = employeeSalaryRepo.findBySalaryLessThan(sal);
		}
		return listEmployeeSlary;
	}

}
