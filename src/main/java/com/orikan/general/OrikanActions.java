package com.orikan.general;

import java.time.Duration;

import com.orikan.common.CommonMethods;
import com.orikan.objectRepo.OrikanLocators;
import com.orikan.utils.ReadProperties;

public class OrikanActions extends CommonMethods {

	protected ReadProperties prop;

	public OrikanActions() throws Throwable {
		prop = new ReadProperties();
	}

	public static void lauchApp(String Url) {

		try {
			driver.get(Url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void registrationPage(String uName, String pass) {
		try {
			lauchApp(prop.getProperty("orikanUrl"));
			type(OrikanLocators.userEmail_txt, uName, "User Email");
			type(OrikanLocators.password_txt, pass, "Password");
			type(OrikanLocators.confirmPass_txt, pass, "Confirm Password");
			click(OrikanLocators.next_btn, "Next Button");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	
	

}
