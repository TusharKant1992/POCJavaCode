package com.prokarma.poc.employeesalary.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.poc.employeesalary.dto.EmployeeDetailsResponse;
import com.prokarma.poc.employeesalary.dto.EmployeeResponseDTO;
import com.prokarma.poc.employeesalary.dto.EmployeeSalaryDTO;
import com.prokarma.poc.employeesalary.model.EmployeeSalaryModel;
import com.prokarma.poc.employeesalary.service.EmployeeDetailsClient;
import com.prokarma.poc.employeesalary.service.EmployeeSalaryService;

@RestController
@RequestMapping("/employeesalary")
public class EmployeeSalaryController {

	@Autowired
	private EmployeeSalaryService employeeSalaryService;

	@Autowired
	private EmployeeDetailsClient employeeDetailsClient;

	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployeeSalary(@RequestBody EmployeeSalaryModel employeeSalaryModel) {
		Integer empId = employeeSalaryService.saveEmployeeSalary(employeeSalaryModel);
		return new ResponseEntity<String>("salary of " + empId + " saved", HttpStatus.OK);
	}

	@GetMapping("/getEmpSalary/{empId}")
	public ResponseEntity<EmployeeSalaryDTO> getEmployeeSalary(@PathVariable Integer empId) {
		System.out.println(empId);
		EmployeeSalaryDTO employeeSalaryDTO = employeeSalaryService.getByEmpId(empId);

		return new ResponseEntity<EmployeeSalaryDTO>(employeeSalaryDTO, HttpStatus.OK);
	}

	@GetMapping("/getEmpBySal/{val}/{salary}")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeBySalary(@PathVariable String val,
			@PathVariable Double salary) {
		List<EmployeeResponseDTO> listemployeeResponseDto = new ArrayList<EmployeeResponseDTO>();
		List<EmployeeSalaryModel> listEmployee = employeeSalaryService.getEmployeebySal(val, salary);
		for (int i = 0; i < listEmployee.size(); i++) {
			EmployeeDetailsResponse employeeDetailsResponse = employeeDetailsClient
					.getEmployeeById(listEmployee.get(i).getEmpId());
			EmployeeResponseDTO emplResponseDTO = new EmployeeResponseDTO();
			emplResponseDTO.setEmpId(employeeDetailsResponse.getEmpId());
			emplResponseDTO.setDateOfBirth(employeeDetailsResponse.getDateOfBirth());
			emplResponseDTO.setName(employeeDetailsResponse.getName());
			emplResponseDTO.setAge(employeeDetailsResponse.getAge());
			emplResponseDTO.setDateOfJoining(employeeDetailsResponse.getDateOfJoining());
			emplResponseDTO.setEmpSal(listEmployee.get(i).getSalary());
			listemployeeResponseDto.add(emplResponseDTO);
		}
		return new ResponseEntity<List<EmployeeResponseDTO>>(listemployeeResponseDto, HttpStatus.OK);
	}

}
