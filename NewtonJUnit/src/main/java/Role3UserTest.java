package main.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class Role3UserTest {

	//test when me has Role 3 id
	@Test
	public void test() {
		//create me
		UserPO me = new UserPO();
		me.setId(1);
		me.setRoleId("3");
		
		//create her
		UserPO her = new UserPO();
		her.setId(2);
		her.setRoleId("2");
		
		UserUtil test = new UserUtil();
		int output = test.canISeeHer(me,her);
		assertEquals(-1,output);
		
		//change her role
		her.setRoleId("3");
		
		output = test.canISeeHer(me,her);
		assertEquals(1,output);
		
		
	}

}