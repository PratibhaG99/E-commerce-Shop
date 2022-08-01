package com.report.service;

import java.util.List;

import com.report.entity.Report;

public interface ReportService{
	
	public Report addOrderDetails(Report report);
	public List<Report> getReport();
}
