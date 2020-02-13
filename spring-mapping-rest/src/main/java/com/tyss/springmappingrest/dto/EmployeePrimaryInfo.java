package com.tyss.springmappingrest.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name = "employee_primary_info")
public class EmployeePrimaryInfo {
	@Id
	@GeneratedValue
	@Column
	private int empid;
	@Column
	private String name;
	@Column
	private double salary;
	@Column
	private int experiance;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "primary")
	private EmployeeSecondaryInfo secondaryInfo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "empid")
	private List<EmployeeAddressInfo> addressInfos;
	
	
}
