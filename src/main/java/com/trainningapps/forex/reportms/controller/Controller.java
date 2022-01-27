package com.trainningapps.forex.reportms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trainningapps.forex.reportms.dao.IReportRepository;
import com.trainningapps.forex.reportms.dto.CreateReportRequest;
import com.trainningapps.forex.reportms.dto.ReportDetails;
import com.trainningapps.forex.reportms.dto.ReportList;
import com.trainningapps.forex.reportms.dto.TransactionDetails;
import com.trainningapps.forex.reportms.service.ReportService;
import com.trainningapps.forex.reportms.util.Util;

/**
 * Class for controller
 * @author harii
 *
 */

@CrossOrigin(origins = "*")
@RequestMapping("/report")
@RestController
public class Controller {

	@Autowired
	private ReportService reportService;
	
	@Autowired
	private IReportRepository reportRepo;
	
	@Autowired
	private Util reportUtil;
	
	@Autowired
	private ReportList reportList;
	
	/**
	 * Gateway for generating the report for the given period
	 * @param request
	 * @return
	 */
	
	@PostMapping("/generate")
	public ReportList generateReport(@RequestBody CreateReportRequest request) { 
		ReportDetails reportDetails = reportService.generateReportInPeriod(request);
		List<ReportDetails> reportDetailsList = new ArrayList<ReportDetails>();
		reportDetailsList.add(reportDetails);
		ReportList reportList = new ReportList();
		reportList.setReportDetailsList(reportDetailsList);
		return reportList;
	}
	
	/**
	 * Endpoints for finding the report by Report Id
	 * @param reportId
	 * @return
	 */
	@GetMapping("/fetchreport/{reportId}")
	public ReportList findById(@PathVariable("reportId") Long reportId) {
		ReportDetails reportDetails = new ReportDetails();
		reportDetails = reportService.findReportDetailsById(reportId);
		List<ReportDetails> reportDetailsList = new ArrayList<ReportDetails>();
		reportDetailsList.add(reportDetails);
		ReportList reportList = new ReportList();
		reportList.setReportDetailsList(reportDetailsList);
		return reportList;
		//List<ReportDetails> reportDetailsList = reportDetailsList.add(reportDetails);
	}
	
	/**
	 * Endpoints for find all reports
	 * @return
	 */
	@GetMapping("/findAll")
	public ReportList findAll() {
		ReportList reportList = new ReportList();
		reportList.setReportDetailsList(reportService.findAllReports());
		return reportList;
	}

}
