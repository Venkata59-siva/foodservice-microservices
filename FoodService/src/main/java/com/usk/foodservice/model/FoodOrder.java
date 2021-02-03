package com.usk.foodservice.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ORDERS")
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long orderId;
	@Column(name = "ORDER_AMOUNT")
	private Long orderAmount;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User orderBy;
	
	@javax.persistence.Transient
	List<FoodIteam> foodIteams ;
}
