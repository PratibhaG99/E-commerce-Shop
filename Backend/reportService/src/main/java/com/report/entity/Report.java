package com.report.entity;

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
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rid;
	private String buyername;
	private String buyeremail;
	private String buyerphone;
	private String buyeraddress;
	private int totalcost;
	private String pname;
	private Long pid;
	private String count;
	
}
