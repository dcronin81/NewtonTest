package main.java;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateCrossYearTest {

	//Test when the the dates cross over a year but are less than an years length.
	@Test
	public void test() {
		try{
		//Variables
		String beginDate = "October 31, 2016 15:33";
		String endDate = "January 22, 2017 16:18";
		
		//converting to date format
		Date covBeginDate = new SimpleDateFormat ("MMMM d, yyy HH:mm").parse(beginDate);
		Date covEndDate = new SimpleDateFormat ("MMMM d, yyy HH:mm").parse(endDate);
		
		//begin test
		DateUtil test = new DateUtil();
		int output = test.countDays(covBeginDate, covEndDate);
		assertEquals(83, output);
		//System.out.println(output);
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
