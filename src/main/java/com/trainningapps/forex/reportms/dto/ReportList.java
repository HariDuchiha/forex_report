package com.trainningapps.forex.reportms.dto;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Class to send data to frontend as a List to iterate
 * @author harii
 *
 */
@Component
public class ReportList {
	
	private List<ReportDetails> ReportDetailsList;

	public List<ReportDetails> getReportDetailsList() {
		return ReportDetailsList;
	}

	public void setReportDetailsList(List<ReportDetails> reportDetailsList) {
		ReportDetailsList = reportDetailsList;
	}
	
	

}
