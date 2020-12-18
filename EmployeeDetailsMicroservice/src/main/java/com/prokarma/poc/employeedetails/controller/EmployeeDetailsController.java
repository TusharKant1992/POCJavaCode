package com.prokarma.poc.employeedetails.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.poc.employeedetails.dto.EmployeeResponseDTO;
import com.prokarma.poc.employeedetails.dto.EmployeeSalaryResponse;
import com.prokarma.poc.employeedetails.model.EmployeeModel;
import com.prokarma.poc.employeedetails.service.EmployeeDetailsService;
import com.prokarma.poc.employeedetails.service.EmployeeSalaryClient;

@RestController
@RefreshScope
@RequestMapping("/employeedetails")
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@Autowired
	private EmployeeSalaryClient employeeSalaryClient;

	// Save Employee
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeModel employeeModel) {
		Integer id = employeeDetailsService.saveEmployee(employeeModel);
		return new ResponseEntity<String>("Employee " + id + " Saved ", HttpStatus.OK);
	}

	@GetMapping("/getEmployeById/{empId}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Integer empId) {
		EmployeeModel employeeModel = employeeDetailsService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
	}

	// Expose Service using Name
	@GetMapping("/getEmployeByName/{empName}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeByName(@PathVariable String empName) {
		System.out.println(empName);
		List<EmployeeModel> listEmployee = employeeDetailsService.getEmployeeByName(empName);
		System.out.println(listEmployee);
		List<EmployeeResponseDTO> listEmployeeResponseDTO = new ArrayList<EmployeeResponseDTO>();
		for (int i = 0; i < listEmployee.size(); i++) {
			EmployeeSalaryResponse employeeSalaryResponse = employeeSalaryClient
					.getEmployeeSalary(listEmployee.get(i).getEmpId());
			EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
			employeeResponseDTO.setEmpId(listEmployee.get(i).getEmpId());
			employeeResponseDTO.setName(listEmployee.get(i).getName());
			employeeResponseDTO.setAge(listEmployee.get(i).getAge());
			employeeResponseDTO.setDateOfBirth(listEmployee.get(i).getDateOfBirth());
			employeeResponseDTO.setDateOfJoining(listEmployee.get(i).getDateOfJoining());
			employeeResponseDTO.setEmpSal(employeeSalaryResponse.getSalary());
			listEmployeeResponseDTO.add(employeeResponseDTO);
		}
		return new ResponseEntity<List<EmployeeResponseDTO>>(listEmployeeResponseDTO, HttpStatus.OK);
	}

	// Expose Service Name Starts with Name
	@GetMapping("/getEmployeeNameStartsWith/{name}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeNameStartsWith(@PathVariable String name) {
		List<EmployeeModel> listData = employeeDetailsService.getEmployeeByNameStartsWith(name);
		List<EmployeeResponseDTO> listEmployeeResponseDTO = new ArrayList<EmployeeResponseDTO>();
		for (int i = 0; i < listData.size(); i++) {
			EmployeeSalaryResponse employeeSalaryResponse = employeeSalaryClient
					.getEmployeeSalary(listData.get(i).getEmpId());
			EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
			employeeResponseDTO.setEmpId(listData.get(i).getEmpId());
			employeeResponseDTO.setName(listData.get(i).getName());
			employeeResponseDTO.setAge(listData.get(i).getAge());
			employeeResponseDTO.setDateOfBirth(listData.get(i).getDateOfBirth());
			employeeResponseDTO.setDateOfJoining(listData.get(i).getDateOfJoining());
			employeeResponseDTO.setEmpSal(employeeSalaryResponse.getSalary());
			listEmployeeResponseDTO.add(employeeResponseDTO);
		}
		return new ResponseEntity<List<EmployeeResponseDTO>>(listEmployeeResponseDTO, HttpStatus.OK);
	}

	// Expose Service using name and age
	@GetMapping("/getEmpNameAndAge/{name}/{age}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeByNameAndAge(@PathVariable Integer age,
			@PathVariable String name) {
		List<EmployeeModel> empList = employeeDetailsService.getEmployeeByNameAndAge(name, age);
		List<EmployeeResponseDTO> listEmployeeResponseDTO = new ArrayList<EmployeeResponseDTO>();
		for (int i = 0; i < empList.size(); i++) {
			EmployeeSalaryResponse employeeSalaryResponse = employeeSalaryClient
					.getEmployeeSalary(empList.get(i).getEmpId());
			EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
			employeeResponseDTO.setEmpId(empList.get(i).getEmpId());
			employeeResponseDTO.setName(empList.get(i).getName());
			employeeResponseDTO.setAge(empList.get(i).getAge());
			employeeResponseDTO.setDateOfBirth(empList.get(i).getDateOfBirth());
			employeeResponseDTO.setDateOfJoining(empList.get(i).getDateOfJoining());
			employeeResponseDTO.setEmpSal(employeeSalaryResponse.getSalary());
			listEmployeeResponseDTO.add(employeeResponseDTO);
		}
		return new ResponseEntity<List<EmployeeResponseDTO>>(listEmployeeResponseDTO, HttpStatus.OK);
	}

}
