package com.usk.foodservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ORDERD_ITEAM")
public class OrderIteam {
	@Id
	@Column(name = "ORDER_ITEAM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDERD_ITEAM_GENERATOR")
    @SequenceGenerator(name = "ORDERD_ITEAM_GENERATOR", sequenceName = "ORDERD_ITEAM_SEQUENCE",  allocationSize = 101)

	private Long orderIteamId;
	
	@Column(name ="QUANTITY" )
	private Long quantity;
	
	@Column(name ="PRICE" )
	private Long price;
	
	@Column(name="item_id")
	private Long itemId;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private FoodOrder foodOrder;
	
	
}
