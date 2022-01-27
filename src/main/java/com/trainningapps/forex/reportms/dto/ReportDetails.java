package com.trainningapps.forex.reportms.dto;

import java.util.List;
import java.util.Set;

import com.trainningapps.forex.reportms.report_type.ReportType;

/**
 * Class for Report Details
 * 
 * @author harii
 *
 */

public class ReportDetails {

	private long reportId;
	private Set<TransactionDetails> transaction;
	private ReportType reportType;
	private String createdDate;
	private String startDate;
	private String endDate;

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public Set<TransactionDetails> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<TransactionDetails> transaction) {
		this.transaction = transaction;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
