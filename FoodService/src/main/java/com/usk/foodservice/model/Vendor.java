package com.usk.foodservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")

public class Vendor {
	@Id
	@Column(name = "vendor_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "vendor_generator")
    @SequenceGenerator(name = "vendor_generator", sequenceName = "VENDOR_SEQUENCE",  allocationSize = 101)
	private Long vendorId;

	@Column(name = "vendor_name")
	private String vendorName;

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

}
