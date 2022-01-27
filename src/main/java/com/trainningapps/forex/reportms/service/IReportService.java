package com.trainningapps.forex.reportms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.trainningapps.forex.reportms.dto.CreateReportRequest;
import com.trainningapps.forex.reportms.dto.ReportDetails;
import com.trainningapps.forex.reportms.dto.TransactionDetails;
import com.trainningapps.forex.reportms.report_type.ReportType;

@Validated
public interface IReportService {

	ReportDetails generateReportInPeriod(@NotNull @Valid CreateReportRequest request);
	ReportType getReportType(@NotNull @Valid LocalDate startDate, @NotNull @Valid LocalDate endDate);
	ReportDetails findReportDetailsById(@NotNull @Min(1) Long id);
	Set<TransactionDetails> findReportDetails();
	List<ReportDetails> findAllReports();
}
