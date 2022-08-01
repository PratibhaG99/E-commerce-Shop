package com.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.report.service.ReportService;

@SpringBootApplication
public class ReportServiceApplication implements CommandLineRunner{
	
	@Autowired
	ReportService reportService;

	public static void main(String[] args) {
		SpringApplication.run(ReportServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting....");
		
	}

}
