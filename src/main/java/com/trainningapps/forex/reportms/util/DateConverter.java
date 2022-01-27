package com.trainningapps.forex.reportms.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

/**
 * Class for converting the date(String to LocalDate & LocalDate to String)
 * @author harii
 *
 */
@Component
public class DateConverter {

	private static final String PATTERN = "yyyy-MM-dd";
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
	
	public String toText(LocalDate date) {
		return formatter.format(date);
	}
	
	public LocalDate toDate(String text) {
		return LocalDate.parse(text, formatter);
	}
	
	public int days(LocalDate startDate, LocalDate endDate) {
		long days = ChronoUnit.DAYS.between(startDate, endDate);
		return (int) days;
	}
	
	public int months(LocalDate startDate, LocalDate endDate) {
		long months = ChronoUnit.MONTHS.between(startDate, endDate);
		return (int) months;
	}
}
