package main.java;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateSameDayTest {

	//Test the date format when the the dates are on the same day
	@Test
	public void test() {
		try{
		//Variables
		String beginDate = "January 21, 2012 15:00";
		String endDate = "January 21, 2012 16:18";
		
		//converting to date format
		Date covBeginDate = new SimpleDateFormat ("MMMM d, yyy HH:mm").parse(beginDate);
		Date covEndDate = new SimpleDateFormat ("MMMM d, yyy HH:mm").parse(endDate);
		
		//begin test
		DateUtil test = new DateUtil();
		int output = test.countDays(covBeginDate, covEndDate);
		assertEquals(0, output);
		//System.out.println(output);
		}catch (ParseException e) {
			e.printStackTrace();
		}
	}

}