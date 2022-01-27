package com.trainningapps.forex.reportms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainningapps.forex.reportms.dao.IReportRepository;
import com.trainningapps.forex.reportms.dto.CreateReportRequest;
import com.trainningapps.forex.reportms.dto.ReportDetails;
import com.trainningapps.forex.reportms.dto.TransactionDetails;
import com.trainningapps.forex.reportms.entity.Report;
import com.trainningapps.forex.reportms.exceptions.InvalidDateException;
import com.trainningapps.forex.reportms.exceptions.ReportNotFoundException;
import com.trainningapps.forex.reportms.report_type.ReportType;
import com.trainningapps.forex.reportms.util.DateConverter;
import com.trainningapps.forex.reportms.util.Util;

/**
 * Service Class for Report Module
 * 
 * @author harii
 *
 */

@Service
public class ReportService implements IReportService {

	@Autowired
	private IReportRepository reportRepo;

	@Autowired
	private DateConverter dateUtil;

	@Autowired
	private Util reportUtil;

	/**
	 * Generating report for the given period
	 * 
	 * @param request
	 * @return
	 */
	public ReportDetails generateReportInPeriod(CreateReportRequest request) {
		Report report = newReport();
		validateDates(request.getStartDate(), request.getEndDate());
		LocalDate startDate = dateUtil.toDate(request.getStartDate());
		LocalDate endDate = dateUtil.toDate(request.getEndDate());
		report.setReportType(getReportType(startDate, endDate));
		report.setCreatedDate(currentDate());
		report.setStartDate(startDate);
		report.setEndDate(endDate);
		List<Long> transactionIds = reportUtil.transactionIdsInPeriod(request.getStartDate(), request.getEndDate());
		// List<TransactionDetails>transList =
		// reportUtil.transactionDetailsInPeriod(transactionIds);
		report.setTransaction(transactionIds);
		report = reportRepo.save(report);
		return reportUtil.toDetails(report);
	}

	/**
	 * Getting the ReportType for the given period
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ReportType getReportType(LocalDate startDate, LocalDate endDate) {
		int months = dateUtil.months(startDate, endDate);
		if (months == 1) {
			return ReportType.MONTHLY;
		}
		if (months > 1 && months <= 4) {
			return ReportType.QUATERLY;
		}
		if (months > 4 && months <= 6) {
			return ReportType.HALFYEARLY;
		}
		return ReportType.YEARLY;
	}

	/**
	 * Finding the report based on the reportId
	 * 
	 * @param reportId
	 * @return
	 */
	public ReportDetails findReportDetailsById(Long reportId) {
		Optional<Report> report = reportRepo.findById(reportId);
		if (report.isEmpty()) {
			throw new ReportNotFoundException("Report not found for id " + reportId);
		}
		return reportUtil.toDetails(report.get());
	}

	public Set<TransactionDetails> findReportDetails() {
		// return reportRepo.findAll();
		List<Long> transList = reportUtil.transactionIdsInPeriod("23-03-2000", "09-01-2022");
		return reportUtil.transactionDetailsInPeriod(transList);
	}

	/**
	 * Returning the currentDate when the method is called
	 * 
	 * @return
	 */
	public LocalDate currentDate() {
		return LocalDate.now();
	}

	public void validateDates(String startDateText, String endDateText) {

		

		LocalDate startDate = dateUtil.toDate(startDateText);
		LocalDate endDate = dateUtil.toDate(endDateText);

		if (endDate.isBefore(startDate)) {
			throw new InvalidDateException("EndDate should not be the earliest date than startDate");
		}
		if (endDate.equals(startDate)) {
			throw new InvalidDateException("Both dates should not be same ");
		}
	}
	
	public Report newReport() {
		return new Report();
	}

	

	
	@Override
	public List<ReportDetails> findAllReports() {
		List<Report> allReportList = reportRepo.findAll();
		return reportUtil.toReportDetailsList(allReportList);
	}

}
