package com.tyss.springmappingrest.dto;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmployeeAddressPK {
	private int empid;
	private String address_type;
	
}
