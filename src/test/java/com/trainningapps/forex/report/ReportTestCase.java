package com.trainningapps.forex.report;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainningapps.forex.reportms.dao.IReportRepository;
import com.trainningapps.forex.reportms.dto.CreateReportRequest;
import com.trainningapps.forex.reportms.dto.ReportDetails;
import com.trainningapps.forex.reportms.entity.Report;
import com.trainningapps.forex.reportms.report_type.ReportType;
import com.trainningapps.forex.reportms.service.ReportService;
import com.trainningapps.forex.reportms.util.DateConverter;
import com.trainningapps.forex.reportms.util.Util;

@ExtendWith(MockitoExtension.class)
class ReportTestCase {

	@Mock
	private IReportRepository reportRepo;

	@Mock
	private Util reportUtil;

	@Mock
	private DateConverter dateConverter;

	@InjectMocks
	@Spy
	private ReportService service;

	@Test
	public void testGenerateReport() {

		CreateReportRequest request = new CreateReportRequest(); // mock(CreateReportRequest.class)
		DateConverter converter = new DateConverter();
		Report report = mock(Report.class);
		LocalDate startDate = LocalDate.of(2021, 01, 20);
		LocalDate endDate = LocalDate.of(2021, 07, 13);
		LocalDate now = LocalDate.now();
		String start = converter.toText(startDate);
		String end = converter.toText(endDate);
		Set<Long> orderIds = mock(Set.class);
		ReportType reportType = ReportType.MONTHLY;
		request.setStartDate(start);
		request.setEndDate(end);
		doReturn(report).when(service).newReport();
		doReturn(now).when(service).currentDate();
		doNothing().when(service).validateDates(start, end);
		doReturn(reportType).when(service).getReportType(startDate, endDate);
		// when(reportUtil.transactionIdsInPeriod(startDate,
		// endDate)).thenReturn(List<Long> transactionIds);
		when(dateConverter.toDate(start)).thenReturn(startDate);
		when(dateConverter.toDate(end)).thenReturn(endDate);
		when(reportRepo.save(report)).thenReturn(report);
		ReportDetails reportDetails = mock(ReportDetails.class);
		when(reportUtil.toDetails(report)).thenReturn(reportDetails);
		ReportDetails result = service.generateReportInPeriod(request);
		assertEquals(reportDetails, result);
		verify(reportRepo).save(report);
		verify(reportUtil).toDetails(report);

	}
	
	
}
