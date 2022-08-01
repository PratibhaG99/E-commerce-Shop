package com.report.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.entity.Report;
import com.report.repository.ReportRepository;
import com.report.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	ReportRepository reportRepository;

	@Override
	public Report addOrderDetails(Report report) {
		reportRepository.save(report);
		reportRepository.flush();
		return report;
	}

	@Override
	public List<Report> getReport() {
		return reportRepository.findAll();
	}

}
