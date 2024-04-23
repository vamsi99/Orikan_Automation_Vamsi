package com.orikan.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.orikan.general.OrikanActions;
import com.orikan.objectRepo.OrikanLocators;
import com.orikan.utils.ReadProperties;



public class OrikanTestCases extends OrikanActions{
	
	ReadProperties prop;
	public OrikanTestCases() throws Throwable {
		super();
		prop = new ReadProperties();
	}

	

	@Test
	public void verifyExistingUserErrorMsg() {
		String username= "adam@orikan.com";
	    String password= "Test@123";
		lauchApp(prop.getProperty("orikanUrl"));
		type(OrikanLocators.userEmail_txt, username, "User Email");
		type(OrikanLocators.password_txt, password, "Password");
		type(OrikanLocators.confirmPass_txt, password, "Confirm Password");
		click(OrikanLocators.next_btn, "Next Button");
		//isTextPresentOnElement(OrikanLocators.errorMsg_lbl, "Email address is already registered");
		assertTrue(getText(OrikanLocators.errorMsg_lbl, "error msg").equals("Email address is already registered"));
	}
	
	@Test
	public void verifyRegistration() {
		String username= "vamsitulabandula@gamil.com";
	    String password= "Test@1234";
		registrationPage(username, password);
		
		fluentWait(OrikanLocators.firstName_txt);	
		
		type(OrikanLocators.firstName_txt, "Vamsi", "First Name");
		type(OrikanLocators.middleName_txt, "Krishna", "Middle Name");
		type(OrikanLocators.lastName_txt, "Tulabandula", "Last Name");
		type(OrikanLocators.preferredFullName_txt, "Vamsi Krishna", "Preferred Full Name");		
		type(OrikanLocators.addressLine1_txt, "Post Office Line", "Address Line 1");		
		type(OrikanLocators.addressLine2_txt, "East Line", "Address Line 2");		
		type(OrikanLocators.postCode_txt, "523169", "Post Code");		
		type(OrikanLocators.city_txt, "Parchur", "City");		
		selectByValueDD(OrikanLocators.state_dd, "Queensland");		
		click(OrikanLocators.next_btn, "Next Button");
		
		fluentWait(OrikanLocators.cardHolderName_txt);
		
		type(OrikanLocators.cardHolderName_txt, "Vamsi", "Card holder name");		
		click(OrikanLocators.cardTypeVisa_rbtn, "Visa Radio Button");		
		type(OrikanLocators.cardNum_txt, "123456789201", "Card Number");		
		type(OrikanLocators.cvv_txt, "764", "Card Number");		
		selectByValueDD(OrikanLocators.expiryMonth_dd, "May");		
		type(OrikanLocators.expiryYear_txt, "764", "Card Number");		
		click(OrikanLocators.next_btn, "Next Button");	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollTop = arguments[1];",OrikanLocators.termNcondi_rbt,1000);	
	    js.executeScript("window.scrollBy(0,1000)");	    
	    click(OrikanLocators.termNcondi_rbt, "Terms and Conditions");	    
	    click(OrikanLocators.next_btn, "Next Button");	
		
	}
	
	
	
}
