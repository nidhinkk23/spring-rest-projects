package com.tyss.springmappingrest.dto;

import java.util.List;

import lombok.Data;


@Data
public class EmployeeResponse {
	private int statusCode;
	private String message;
	private String description;
	
}
