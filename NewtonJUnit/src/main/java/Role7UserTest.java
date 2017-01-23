package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class Role7UserTest {

	//test when me has Role 7 id
	@Test
	public void test() {
		//create me
		UserPO me = new UserPO();
		me.setId(1);
		me.setRoleId("7");
		
		//create her
		UserPO her = new UserPO();
		her.setId(2);
		her.setRoleId("1");
		
		UserUtil test = new UserUtil();
		int output = test.canISeeHer(me,her);
		assertEquals(-1,output);
		
		//change her role
		her.setRoleId("4");
		
		output = test.canISeeHer(me,her);
		assertEquals(0,output);
		
		
	}

}