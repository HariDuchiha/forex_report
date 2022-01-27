package com.trainningapps.forex.reportms.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainningapps.forex.reportms.dao.IReportRepository;
import com.trainningapps.forex.reportms.dto.ReportDetails;
import com.trainningapps.forex.reportms.dto.TransactionDetails;
import com.trainningapps.forex.reportms.entity.Report;

@Component
public class Util {
	
	@Autowired
	private DateConverter dateUtil;
	@Autowired
	private IReportRepository reportRepo;
	
	public ReportDetails toDetails(Report request) {
		ReportDetails report = new ReportDetails();
		report.setReportId(request.getReportId());
		LocalDate createdDate = LocalDate.now();
		report.setCreatedDate(dateUtil.toText(createdDate));
		report.setStartDate(dateUtil.toText(request.getStartDate()));
		report.setEndDate(dateUtil.toText(request.getEndDate()));
		report.setReportType(request.getReportType());
		List<Long> transactionIds = transactionIdsInPeriod(dateUtil.toText(request.getStartDate()),dateUtil.toText(request.getStartDate()));
		report.setTransaction(transactionDetailsInPeriod(transactionIds));
		//report.setTransaction(request.getTransaction());
		return report;	
	}
	
	
	/*
	 * Dummy Transaction Ids
	 */
	public List<Long> transactionIdsInPeriod(String startDate, String endDate){
		
		List<Long> transactionIds = new ArrayList<Long>();
		transactionIds.add(1L);
		transactionIds.add(47L);
		transactionIds.add(7L);
		transactionIds.add(39L);
		return transactionIds;
	}
	
	/*
	 * Dummy transaction values
	 */
	public Set<TransactionDetails> transactionDetailsInPeriod(List<Long> transactionIds) {
		
		TransactionDetails transactionDetails = new TransactionDetails();
		Set<TransactionDetails> transList = new HashSet<TransactionDetails>();
		
		transactionDetails.setTransactionId(4L);
		transactionDetails.setSenderName("Eiichiro Oda");
		transactionDetails.setReceipientName("Masashi Kishimoto");
		transactionDetails.setExchangeFrom("India");
		transactionDetails.setExchangeTo("Japan");
		transactionDetails.setReceipientAcc(1234567890);
		transactionDetails.setAmount(400000);
		transactionDetails.setTransactionFee(123);
		
		transList.add(transactionDetails);
		
		TransactionDetails transactionDetails1 = new TransactionDetails();
		
		transactionDetails1.setTransactionId(1L);
		transactionDetails1.setSenderName("Kalki");
		transactionDetails1.setReceipientName("Naga");
		transactionDetails1.setExchangeFrom("Europe");
		transactionDetails1.setExchangeTo("America");
		transactionDetails1.setReceipientAcc(98765432);
		transactionDetails1.setAmount(800000);
		transactionDetails1.setTransactionFee(2322);
		
		transList.add(transactionDetails1);
		
		TransactionDetails transactionDetails2 = new TransactionDetails();
		
		transactionDetails2.setTransactionId(2L);
		transactionDetails2.setSenderName("Sandiliyan");
		transactionDetails2.setReceipientName("Arulmozhivaruman");
		transactionDetails2.setExchangeFrom("China");
		transactionDetails2.setExchangeTo("Aus");
		transactionDetails2.setReceipientAcc(7649338);
		transactionDetails2.setAmount(4006500);
		transactionDetails2.setTransactionFee(444);
		
		transList.add(transactionDetails2);
		
		TransactionDetails transactionDetails3 = new TransactionDetails();
		
		transactionDetails3.setTransactionId(3L);
		transactionDetails3.setSenderName("Sujatha");
		transactionDetails3.setReceipientName("Indrajith");
		transactionDetails3.setExchangeFrom("Brazil");
		transactionDetails3.setExchangeTo("Aus");
		transactionDetails3.setReceipientAcc(67890432);
		transactionDetails3.setAmount(60942);
		transactionDetails3.setTransactionFee(600);
		
		transList.add(transactionDetails3);
		
		//System.out.println(transList);
		
		return transList;
	}
	
	/*
	 *To send all the reports to List<ReportDetails>
	 */
	public List<ReportDetails> toReportDetailsList(Collection<Report> reports)
	{
		return reports.stream().map(report -> toDetails(report)).collect(Collectors.toList());
	}

}
