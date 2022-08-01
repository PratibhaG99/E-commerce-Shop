package com.discount.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCoupon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long did;
	private String couponname;
	private int percentage;
}
