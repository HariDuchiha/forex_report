package com.trainningapps.forex.reportms.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trainningapps.forex.reportms.entity.Report;

/**
 * 
 * Report Repository Class
 * @author harii
 *
 */
@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {

	@Query("From Report where startPeriod = :startDate and endPeriod = :endDate")
	Report findReportByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate")LocalDate endDate);
	
}
