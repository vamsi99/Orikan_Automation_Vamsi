package com.orikan.objectRepo;

import org.openqa.selenium.By;

public class OrikanLocators {
	
	public static By userEmail_txt = By.xpath("//*[@id='emailAddress']");
	public static By password_txt = By.id("password");
	public static By confirmPass_txt = By.id("confirmPassword");
	public static By next_btn = By.xpath("//button[text() = 'Next']");	
	public static By errorMsg_lbl = By.className("toast-message error active");	
	public static By firstName_txt = By.id("firstName");
	public static By middleName_txt = By.id("middleName");
	public static By lastName_txt = By.id("lastName");
	public static By preferredFullName_txt = By.id("preferredFullName");	
	public static By addressLine1_txt = By.id("addressLine1");	
	public static By addressLine2_txt = By.id("addressLine2");	
	public static By postCode_txt = By.id("postcode");	
	public static By city_txt = By.id("city");
	public static By state_dd = By.id("state");	
	public static By cardHolderName_txt = By.id("cardHolderName");	
	public static By cardTypeVisa_rbtn = By.xpath("//*[@id='cardTypeVISA']") ;
	public static By cardNum_txt = By.id("cardNumber");
	public static By cvv_txt = By.id("cardCVV");	
	public static By expiryMonth_dd = By.id("cardExpiryMonth");
	public static By expiryYear_txt = By.id("cardExpiryYear");	
	public static By termNcondi_rbt = By.xpath("//*[@id='agreedToTerms']");	
	public static By submit_btn = By.xpath("//button[text() = 'Submit']");
	
	
}


