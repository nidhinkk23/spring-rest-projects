package com.tyss.springmappingrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springmappingrest.dto.EmployeeAddressInfo;
import com.tyss.springmappingrest.dto.EmployeePrimaryInfo;
import com.tyss.springmappingrest.dto.EmployeeResponse;
import com.tyss.springmappingrest.dto.EmployeeSecondaryInfo;
import com.tyss.springmappingrest.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	
	@PostMapping(path = "/add-employee",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse addEmployee(@RequestBody EmployeeSecondaryInfo employeeSecondaryInfo) {
		EmployeeResponse response =new EmployeeResponse();
		if(service.addEmployee(employeeSecondaryInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Registered");

		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee Not Registered");

		}
		
		
		return response;
	}
	
	
	
	@PostMapping(path = "/add-employeep",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse addEmployeeP(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeeResponse response =new EmployeeResponse();
		if(service.addEmployeP(employeePrimaryInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Registered");

		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee Not Registered");

		}
		
		
		return response;
	}
	
	@PostMapping(path = "/add-employee-details",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse addEmployeeDetails(@RequestBody EmployeeAddressInfo addressInfo) {
		EmployeeResponse response =new EmployeeResponse();
		if(service.addEmployeeDetailsOneToMany(addressInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Registered and details added");

		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Employee Not Registered");

		}
		
		return response;
	}
	
}
