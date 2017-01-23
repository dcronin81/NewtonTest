package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class IAmHerTest {

	//test where me and her are the same person
	@Test
	public void test() {
		//create me
		UserPO me = new UserPO();
		me.setId(1);
		
		//create her
		UserPO her = new UserPO();
		her.setId(1);
		
		UserUtil test = new UserUtil();
		int output = test.canISeeHer(me,her);
		assertEquals(1,output);
	}

}
