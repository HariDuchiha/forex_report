package com.trainningapps.forex.reportms.dto;

import java.util.Date;

import com.trainningapps.forex.reportms.report_type.ReportType;

/**
 * Class for getting request from user
 * @author harii
 *
 */

public class CreateReportRequest {

	private String startDate;
	private String endDate;

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
