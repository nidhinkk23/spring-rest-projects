package com.tyss.springmappingrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springmappingrest.dao.EmployeeDAO;
import com.tyss.springmappingrest.dto.EmployeeAddressInfo;
import com.tyss.springmappingrest.dto.EmployeePrimaryInfo;
import com.tyss.springmappingrest.dto.EmployeeSecondaryInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;
	
	@Override
	public boolean addEmployee(EmployeeSecondaryInfo employeeSecondaryInfo) {
		
		return dao.addEmployee(employeeSecondaryInfo);
	}

	@Override
	public boolean addEmployeP(EmployeePrimaryInfo employeePrimaryInfo) {
		
		return dao.addEmployeP(employeePrimaryInfo);
	}

	@Override
	public boolean addEmployeeDetailsOneToMany(EmployeeAddressInfo addressInfo) {
		
		return dao.addEmployeeDetailsOneToMany(addressInfo);
	}

	@Override
	public List<EmployeePrimaryInfo> searchEmployee(int empid) {
		
		return dao.searchEmployee(empid);
	}

	@Override
	public boolean editDetails(EmployeePrimaryInfo employeePrimaryInfo) {
		
		return dao.editDetails(employeePrimaryInfo);
	}

}
