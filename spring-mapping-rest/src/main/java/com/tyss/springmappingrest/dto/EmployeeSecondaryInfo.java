package com.tyss.springmappingrest.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "employee_secondary_info")
public class EmployeeSecondaryInfo {
	@Id
	
	private int empid;
	@Column
	private String gender;
	@Column
	private String personal_email;
	@Column
	private String job_location;
	@Exclude
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeePrimaryInfo primary;

}
