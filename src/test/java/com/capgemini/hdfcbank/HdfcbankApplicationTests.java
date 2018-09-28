package com.capgemini.hdfcbank;

import static org.junit.Assert.assertEquals;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hdfcbank.controller.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HdfcbankApplicationTests {

	@Test
	public void contextLoads() {
		
		CustomerController customerController=new CustomerController();
		String result= customerController.editPasswordPage();
		assertEquals(result, "changePassword");
		
		String res=customerController.editProfilePage();
		assertEquals(res, "editCustomer");
	
	}
	
	

}
