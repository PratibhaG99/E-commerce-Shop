package com.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

}
