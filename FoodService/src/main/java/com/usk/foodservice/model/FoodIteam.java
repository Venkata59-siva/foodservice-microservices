package com.usk.foodservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "items")
public class FoodIteam {
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ITEAM_GENERATOR")
    @SequenceGenerator(name = "ITEAM_GENERATOR", sequenceName = "ITEAM_SEQUENCE",  allocationSize = 101)

	private Long itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_price")
	private Long price ;
	@Transient
	private Long quntity;
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
}
