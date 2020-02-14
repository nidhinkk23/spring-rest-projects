package com.tyss.springmappingrest.dao;

import java.util.List;

import com.tyss.springmappingrest.dto.EmployeeAddressInfo;
import com.tyss.springmappingrest.dto.EmployeePrimaryInfo;
import com.tyss.springmappingrest.dto.EmployeeSecondaryInfo;

public interface EmployeeDAO {

	public boolean addEmployee(EmployeeSecondaryInfo employeeSecondaryInfo);
	public boolean addEmployeP(EmployeePrimaryInfo employeePrimaryInfo);
	public boolean addEmployeeDetailsOneToMany(EmployeeAddressInfo addressInfo);
	public List<EmployeePrimaryInfo> searchEmployee(int empid);
	public boolean editDetails(EmployeePrimaryInfo employeePrimaryInfo);
}
