package com.tyss.springmappingrest.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table(name="Employee_Address_info")
public class EmployeeAddressInfo {
	@Id
	@Column
	@GeneratedValue
	private int addressId;
	
	@Column
	private String address_type;
	@Column
	private int house_no;
	@Column
	private String address1;
	
	
	
}
