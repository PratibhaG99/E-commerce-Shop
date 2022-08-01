package com.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.entity.Report;
import com.report.serviceImpl.ReportServiceImpl;

@RestController
@RequestMapping("/order")
//@CrossOrigin("*")
public class ReportController {
	
	@Autowired
	ReportServiceImpl reportService;
	
	@PostMapping("/")
	public Report addOrderDetails(@RequestBody Report report) {
		return reportService.addOrderDetails(report);
	}

	@GetMapping("/")
	public List<Report> getReport(){
		return reportService.getReport();
	}
	
}
