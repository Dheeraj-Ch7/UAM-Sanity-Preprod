package com.unified.infinity.libraries;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.unified.infinity.pageobjects.UnifiedObjects;
import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.LoggerUtil;
import com.unified.infinity.utils.WebInteractUtil;

public class UnifiedLibrary {
	public WebDriver driver = DriverManager.WEB_DRIVER_THREAD.get();
	public UnifiedObjects UnifiedPage;
	private static String downloadPath = "D:\\Users\\hp\\Downloads";

	Actions actions = new Actions(driver);

	public UnifiedLibrary()
	{
		UnifiedPage = new UnifiedObjects();	
	}
	public String WebBrowser(Map<String, String> testdata) throws Exception {
		
		//WebInteractUtil.launchWebApp(APP_URL);
		WebInteractUtil.launchWebApp(testdata.get("APP_URL"));

		return testdata.get("APP_URL");
		}
	public String UnifiedSignIn(Map<String, String> testdata) throws Exception{				
		String Status = null;				
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb, testdata.get("Password"));
		WebInteractUtil.Click(UnifiedPage.LoginBtn);
		WebInteractUtil.Waittilljquesryupdated();	
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
			LoggerUtil.printExtentLog("Pass", "Application SignIn with password is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull with password, Please check");
			Status ="False";}	
		return Status;		
	}
	
	public String UnifiedSignInwithInValidUn(Map<String, String> testdata) throws Exception{				
		String Status = null;
	
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.Waittilljquesryupdated();
		//WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, "7659959594");
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, "9000900090");
		WebInteractUtil.Waittilljquesryupdated();	
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.InvalidUn, 60)){
			LoggerUtil.printExtentLog("Pass", "Invalid PhoneNumber  functionality is working as expected" );
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Invalid PhoneNumber functionality is working as expected, Please check");
			Status ="False";}	
		
		return Status;		
	}
	
	public String UnifiedSignInwithInValidUnandPwd(Map<String, String> testdata) throws Exception{				
		String Status = null;
	
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.Waittilljquesryupdated();
		//WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, "7659959594");
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, "9000900090");
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb,"Test9090");
		WebInteractUtil.Click(UnifiedPage.LoginBtn);
		WebInteractUtil.Waittilljquesryupdated();	
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Invalidunandpwd, 60)){
			LoggerUtil.printExtentLog("Pass", "Invalid Username and Password functionality is working as expected" );
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Invalid Username and Password functionality is working as expected, Please check");
			Status ="False";}	
		
		return Status;		
	}
	
	public String UnifiedLoginWithOtp(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.isPresent(UnifiedPage.GetOTPBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.GetOTPBtn1);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		
		WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp2, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp3, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp4, "1");
		
		
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
			LoggerUtil.printExtentLog("Pass", "Application SignIn with OTP is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application SignIn with OTP is not successfull, Please check");
			Status ="False";}	
		return Status;	
			
	}
	
	public String UnifiedLoginWithOtp2(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.isPresent(UnifiedPage.GetOTPBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.GetOTPBtn1);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		
		WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp2, "2");
		WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp3, "3");
		WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp4, "4");
		
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.IncorrectOTP, 60)){
			LoggerUtil.printExtentLog("Pass", "OTP is incorrect,please try again");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Incorrect OTP is not working as expected, Please check");
			Status ="False";}	
		return Status;	
				
	}
	
	public String UnifiedLoginWithOtp3(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.isPresent(UnifiedPage.GetOTPBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.GetOTPBtn1);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		
		WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp2, "2");
		WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp3, "3");
		WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp4, "4");
		
		WebInteractUtil.isPresent(UnifiedPage.OTPEditbtn, 60);
		WebInteractUtil.Click(UnifiedPage.OTPEditbtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PhoneNumberTxb, 60)){
			LoggerUtil.printExtentLog("Pass", "OTP Edit button is working as expected");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "OTP Edit button is not working as expected, Please check");
			Status ="False";}	
		return Status;	
				
	}
	
	public String UnifiedForgotPassword(Map<String, String> testdata) throws Exception{				
		String Status = null;
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.ForgotPassBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ForgotPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.SendOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.SendOtpBtn);
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		
		WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp2, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp3, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp4, "1");
		
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
		WebInteractUtil.isPresent(UnifiedPage.NewPassTxb, 120);

	//	WebInteractUtil.isPresent(UnifiedPage.NewPassTxb, 120);
		WebInteractUtil.SendKeys(UnifiedPage.NewPassTxb, testdata.get("Password"));
		WebInteractUtil.SendKeys(UnifiedPage.ConfirmNewPassTxb, testdata.get("Password"));
		WebInteractUtil.isPresent(UnifiedPage.ResetPassBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ResetPassBtn);
		WebInteractUtil.Waittilljquesryupdated();
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPassReset, 60)){
			LoggerUtil.printExtentLog("Pass", "Password has been reset successfully");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Password reset not successfull, Please check");
			Status ="False";}
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb, testdata.get("Password"));
		WebInteractUtil.Click(UnifiedPage.LoginBtn);
		WebInteractUtil.Waittilljquesryupdated();	
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
			LoggerUtil.printExtentLog("Pass", "Application SignIn is successfull with new password");
			LoggerUtil.printExtentLog("Pass", "Forgot password functionality is working as expected");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull with new password");
			LoggerUtil.printExtentLog("Fail", "Forgot password functionality is not working as expected, Please check");
			Status ="False";}	
		return Status;	
	}
	
	public String UnifiedForgotPassword2(Map<String, String> testdata) throws Exception{				
		String Status = null;
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.ForgotPassBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ForgotPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.SendOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.SendOtpBtn);
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		
		WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp2, "2");
		WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp3, "3");
		WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp4, "4");
		
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
		
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.IncorrectOTP, 60)){
			LoggerUtil.printExtentLog("Pass", "OTP is incorrect,please try again");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Incorrect OTP is not working as expected, Please check");
			Status ="False";}	
		
		return Status;	
	}
	
	public String UnifiedForgotPassword3(Map<String, String> testdata) throws Exception{				
		String Status = null;
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
		WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
		Thread.sleep(1000);
		WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.ForgotPassBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ForgotPassBtn);
		WebInteractUtil.isPresent(UnifiedPage.SendOtpBtn, 60);
		WebInteractUtil.Click(UnifiedPage.SendOtpBtn);
		
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);
		
		WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
		WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp2, "2");
		WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp3, "3");
		WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
		WebInteractUtil.SendKeys(UnifiedPage.otp4, "4");
		
		WebInteractUtil.isPresent(UnifiedPage.OTPEditbtn, 60);
		WebInteractUtil.Click(UnifiedPage.OTPEditbtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PhoneNumberTxb, 60)){
			LoggerUtil.printExtentLog("Pass", "OTP Edit button is working as expected");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "OTP Edit button is not working as expected, Please check");
			Status ="False";}	
		
		return Status;	
	}

		public String UnifiedLogOut(Map<String, String> testdata) throws Exception{				
		String Status = null;
		WebInteractUtil.isPresent(UnifiedPage.InfinityLogo, 60);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.Click(UnifiedPage.InfinityLogo);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.ProfileIcon, 60);
		WebInteractUtil.Click(UnifiedPage.ProfileIcon);
		WebInteractUtil.isPresent(UnifiedPage.LogoutBtn, 60);
		WebInteractUtil.Click(UnifiedPage.LogoutBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHomePage, 60)){
			LoggerUtil.printExtentLog("Pass", "Application Logout is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Application Logout is not successfull, Please check");
			Status ="False";}
		return Status;	
		}
		//PYP Tests
		public String PYPTests(Map<String, String> testdata) throws Exception{				
			String Status = null;
		WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
		WebInteractUtil.Click(UnifiedPage.TestsBtn);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PYPBtn, 60);
		WebInteractUtil.Click(UnifiedPage.PYPBtn);
		WebInteractUtil.Waittilljquesryupdated();
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPYPpage, 60)) {
			LoggerUtil.printExtentLog("Pass", "Navigation to PYP's Listing Page is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Navigation to PYP's Listing Page is not successfull, Please check");
			Status ="False";}
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.AttemptNowBtn, 60);
		WebInteractUtil.Click(UnifiedPage.AttemptNowBtn);
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.VerifyGInsPage, 60);
//		Actions actions = new Actions(driver);
		Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
		scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
		WebInteractUtil.Waittilljquesryupdated();
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTest, 60)) {
			LoggerUtil.printExtentLog("Pass", "Test started successfully");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to start Test, Please check");
			Status ="False";}
		WebInteractUtil.isPresent(UnifiedPage.RadioBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.RadioBtn1);
		WebInteractUtil.isPresent(UnifiedPage.SaveNextBtn, 60);
		WebInteractUtil.Click(UnifiedPage.SaveNextBtn);
		WebInteractUtil.isPresent(UnifiedPage.RadioBtn1, 60);
		WebInteractUtil.Click(UnifiedPage.RadioBtn1);
		WebInteractUtil.Click(UnifiedPage.ReviewLaterBtn);
		WebInteractUtil.isPresent(UnifiedPage.ReviewLaterBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ReviewLaterBtn);
		WebInteractUtil.Click(UnifiedPage.RadioBtn1);
		WebInteractUtil.Click(UnifiedPage.ClearRespnBtn);
		WebInteractUtil.isPresent(UnifiedPage.VerifyTest, 60);
		WebInteractUtil.Click(UnifiedPage.VerifyTest);
		WebInteractUtil.Click(UnifiedPage.GenrlInstBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGnrlPage, 60)) {
			LoggerUtil.printExtentLog("Pass", "Navigation to general instruction's page is successfull");
			WebInteractUtil.Click(UnifiedPage.BackBtn);
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to navigate to General instructions page, Please check");
			Status ="False";}
		WebInteractUtil.Click(UnifiedPage.QstnBtn);
		WebInteractUtil.Click(UnifiedPage.QstnLstBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.GotoQstn, 60)) {
			LoggerUtil.printExtentLog("Pass", "Navigation to Questions List page is successfull");
			WebInteractUtil.Click(UnifiedPage.GotoQstn);
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to navigate to Questions List page, Please check");
			Status ="False";}	
		WebInteractUtil.isPresent(UnifiedPage.ErrorFlagBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ErrorFlagBtn);
		WebInteractUtil.isPresent(UnifiedPage.ReportErrorPP, 60);
		WebInteractUtil.Click(UnifiedPage.IncrtAnsoptn);
		WebInteractUtil.Click(UnifiedPage.IncrtQstn);
		WebInteractUtil.Click(UnifiedPage.QstnNtClr);
		WebInteractUtil.SendKeys(UnifiedPage.AdtnlFeedBck, "Test Report an error");
		WebInteractUtil.Click(UnifiedPage.SubmitFeedBck);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60)) {
			LoggerUtil.printExtentLog("Pass", "Able to Report an error");
		Status = "True";
	}	else {	
		LoggerUtil.printExtentLog("Fail", "Unable to Report an error, Please check");
		Status ="False";}
		WebInteractUtil.Click(UnifiedPage.SubmitBtn);
		WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
		WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
		WebInteractUtil.Click(UnifiedPage.CloseBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
			LoggerUtil.printExtentLog("Pass", "PYP test successfully submitted");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to submit PYP test, Please check");
			Status ="False";}
		WebInteractUtil.Waittilljquesryupdated();
		WebInteractUtil.isPresent(UnifiedPage.ViewSolnBtn, 60);
		WebInteractUtil.Click(UnifiedPage.ViewSolnBtn);
		if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifySolnPage, 60)) {
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			LoggerUtil.printExtentLog("Pass", "Navigation to View Solution Page is successfull");
			Status = "True";
		}	else {	
			LoggerUtil.printExtentLog("Fail", "Navigation to View Solution Page is not successfull, Please check");
			Status ="False";}
		return Status;	
}
		
		public String UnifiedSignUp(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.SignUpPageBtn, 60);	
			WebInteractUtil.Click(UnifiedPage.SignUpPageBtn);
			WebInteractUtil.isPresent(UnifiedPage.FirstNameTxb, 60);	
			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, testdata.get("NewPhoneNumber"));
//			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, "8309156008");
			Thread.sleep(1000);
			WebInteractUtil.SendKeys(UnifiedPage.FirstNameTxb, testdata.get("FirstName"));
			WebInteractUtil.SendKeys(UnifiedPage.LastNameTxb, testdata.get("LastName"));
			WebInteractUtil.Click(UnifiedPage.Grade11);
			//WebInteractUtil.Click(UnifiedPage.DisableWhatsApp);
			WebInteractUtil.Click(UnifiedPage.GetOtpBtn);
			WebInteractUtil.Waittilljquesryupdated();
//			WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);	
//			Thread.sleep(10000);													//Enter OTP Manually
//			WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);	
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.Click(UnifiedPage.StartLearnBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
				LoggerUtil.printExtentLog("Pass", "Application SignUp is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application SignUp is not successfull, Please check");
				Status ="False";}		
			return Status;
}
		
		public String UnifiedSignUp2(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.SignUpPageBtn, 60);	
			WebInteractUtil.Click(UnifiedPage.SignUpPageBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.FirstNameTxb, 60);	
//			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, testdata.get("PhoneNumber"));
			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, "7659959594");
			Thread.sleep(1000);	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Signuptxtbtn, 60)){
				LoggerUtil.printExtentLog("Pass", "Verify phone number existing or new number is working as expected");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Verify phone number existing or new number is not working as expected, Please check");
				Status ="False";}		
			return Status;
}
		public String UnifiedSignUp3(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.SignUpPageBtn, 60);	
			WebInteractUtil.Click(UnifiedPage.SignUpPageBtn);
			WebInteractUtil.isPresent(UnifiedPage.FirstNameTxb, 60);	
//			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, testdata.get("PhoneNumber"));
			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, "8688858150");
			Thread.sleep(1000);
			WebInteractUtil.SendKeys(UnifiedPage.FirstNameTxb, testdata.get("FirstName"));
			WebInteractUtil.SendKeys(UnifiedPage.LastNameTxb, testdata.get("LastName"));
			WebInteractUtil.Click(UnifiedPage.Grade11);
			//WebInteractUtil.Click(UnifiedPage.DisableWhatsApp);
			WebInteractUtil.Click(UnifiedPage.GetOtpBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);					
			
			WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp1, "3");
			WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp2, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp3, "3");
			WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp4, "7");
			WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.IncorrectOTP, 60)){
				LoggerUtil.printExtentLog("Pass", "Signup with Incorrect OTP  is working as expected");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Signup with Incorrect OTP is not working as expected, Please check");
				Status ="False";}		
			return Status;
}
		
		
		public String UnifiedSignUp4(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.SignUpPageBtn, 60);	
			WebInteractUtil.Click(UnifiedPage.SignUpPageBtn);
			WebInteractUtil.isPresent(UnifiedPage.FirstNameTxb, 60);	
//			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, testdata.get("PhoneNumber"));
			WebInteractUtil.SendKeys(UnifiedPage.SignupPhoneNumberTxb, "8688858150");
			Thread.sleep(1000);
			WebInteractUtil.SendKeys(UnifiedPage.FirstNameTxb, testdata.get("FirstName"));
			WebInteractUtil.SendKeys(UnifiedPage.LastNameTxb, testdata.get("LastName"));
			WebInteractUtil.Click(UnifiedPage.Grade11);
			//WebInteractUtil.Click(UnifiedPage.DisableWhatsApp);
			WebInteractUtil.Click(UnifiedPage.GetOtpBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyOtpPage, 60);					
			
			WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp1, "3");
			WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp2, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp3, "3");
			WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp4, "7");
			Thread.sleep(1000);
			WebInteractUtil.Click(UnifiedPage.OTPEditbtn);
			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage. SignupPhoneNumberTxb, 60)){
				LoggerUtil.printExtentLog("Pass", "Signup  Edit working as expected");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Signup Edit is not working as expected, Please check");
				Status ="False";}		
			return Status;
}
		
		public String ChangePassword(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
			WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("Password"));
			WebInteractUtil.SendKeys(UnifiedPage.NewPasswordTxb, testdata.get("NewPassword"));
			WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, testdata.get("NewPassword"));
			WebInteractUtil.Click(UnifiedPage.ResetPassBtn);
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			
			WebInteractUtil.isPresent(UnifiedPage.InfinityLogo, 60);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.ProfileIcon, 60);
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.isPresent(UnifiedPage.LogoutBtn, 60);
			WebInteractUtil.Click(UnifiedPage.LogoutBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHomePage, 60)){
				LoggerUtil.printExtentLog("Pass", "Application Logout is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application Logout is not successfull while checking update password functionality, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.Signintxtbtn, 60);
			WebInteractUtil.Click(UnifiedPage.Signintxtbtn);
			WebInteractUtil.Waittilljquesryupdated();
			Thread.sleep(1000);
			WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
			WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
			Thread.sleep(1000);
			WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
			WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
			WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb, testdata.get("NewPassword"));
			WebInteractUtil.Click(UnifiedPage.LoginBtn);
			WebInteractUtil.Waittilljquesryupdated();	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
				LoggerUtil.printExtentLog("Pass", "Application SignIn with new password is successfull, Update password functionality is working as expected");
				WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
				WebInteractUtil.Click(UnifiedPage.ProfileIcon);
				WebInteractUtil.Click(UnifiedPage.ProfileBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
				WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("NewPassword"));
				WebInteractUtil.SendKeys(UnifiedPage.NewPasswordTxb, testdata.get("Password"));
				WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, testdata.get("Password"));
				WebInteractUtil.Click(UnifiedPage.ResetPassBtn);
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull with new password, Please check update passowrd functionality");
				Status ="False";}
				return Status;}
		
		public String ChangeProfilepicture(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.editprofilepicbtn, 60);     
			WebInteractUtil.Click(UnifiedPage.editprofilepicbtn);           //First deleting profile picture
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.removephotobtn, 30)) {
//			WebInteractUtil.isPresent(UnifiedPage.removephotobtn, 60);
			WebInteractUtil.Click(UnifiedPage.removephotobtn);
			WebInteractUtil.isPresent(UnifiedPage.removephotoclosebtn, 60);
			WebInteractUtil.Click(UnifiedPage.removephotoclosebtn);
			WebInteractUtil.Waittilljquesryupdated();
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Profilepic, 60)){
				LoggerUtil.printExtentLogWithScreenshot("Fail", "Unable to reomve Profile Picture, Please check");
				Status ="False";}
				else {	
			LoggerUtil.printExtentLog("Pass", "Profile Picture removed successfully");
			WebInteractUtil.Click(UnifiedPage.editprofilepicbtn);
			Status = "True";
		}}
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.slt2ndphoto, 60);        //here updating new profile picture
			WebInteractUtil.Click(UnifiedPage.slt2ndphoto);
			WebInteractUtil.isPresent(UnifiedPage.Photosltbtn, 60);
			WebInteractUtil.Click(UnifiedPage.Photosltbtn);
			WebInteractUtil.isPresent(UnifiedPage.removephotoclosebtn, 60);
			WebInteractUtil.Click(UnifiedPage.removephotoclosebtn);		                    
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ChangePassBtn, 60)){
				LoggerUtil.printExtentLog("Pass", "Profile Picture updated successfully");
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLogWithScreenshot("Fail", "Unable to update Profile Picture, Please check");
				Status ="False";}			
			return Status;}
		
		
		public String ChangePasswordwithOTP2(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
			WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("Password"));
			WebInteractUtil.isPresent(UnifiedPage.ChangepwdviaOTP, 60);	
			WebInteractUtil.Click(UnifiedPage.ChangepwdviaOTP);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.SendKeys(UnifiedPage.Enternewpwd, testdata.get("Password"));
			WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, testdata.get("Password"));		
			WebInteractUtil.Click(UnifiedPage.Sendotptomobile);  //Send otp to mobile number
			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyOtpPage, 60)){
				LoggerUtil.printExtentLog("Pass", "Successfully navigated to Verify OTP Page");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to Verify OTP Page, Please check");
				Status ="False";}
			
			WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp2, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp3, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp4, "3");
			
			WebInteractUtil.isPresent(UnifiedPage.VerifyOtpBtn, 60);
			WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);

			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PhoneNumberTxb, 60)){
				LoggerUtil.printExtentLog("Pass", "Change password with incorrect OTP is working as expected");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Change password with incorrect OTP is working as expected, Please check");
				Status ="False";}
			
				return Status;}
		
		public String ChangePassword2(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
			WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("Password"));
			WebInteractUtil.SendKeys(UnifiedPage.NewPasswordTxb, testdata.get("Password"));
			WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, "Pass321");
			WebInteractUtil.Click(UnifiedPage.pwdenablebtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.pwddoesntmatchbtn, 60)){
				LoggerUtil.printExtentLog("Pass", "Confirm Password functionality is working as expected");
				
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Confirm Password functionality is working as expected, Please check");
				Status ="False";}
				return Status;}
		
		public String ChangePasswordwithOTP(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
			WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("Password"));
			WebInteractUtil.isPresent(UnifiedPage.ChangepwdviaOTP, 60);	
			WebInteractUtil.Click(UnifiedPage.ChangepwdviaOTP);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.SendKeys(UnifiedPage.Enternewpwd, testdata.get("NewPassword"));
			WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, testdata.get("NewPassword"));
			
			WebInteractUtil.Click(UnifiedPage.Sendotptomobile);  //Send otp to mobile number
			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyOtpPage, 60)){
				LoggerUtil.printExtentLog("Pass", "Successfully navigated to Verify OTP Page");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to Verify OTP Page, Please check");
				Status ="False";}
			
			WebInteractUtil.isPresent(UnifiedPage.otp1, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp1, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp2, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp2, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp3, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp3, "1");
			WebInteractUtil.isPresent(UnifiedPage.otp4, 60);
			WebInteractUtil.SendKeys(UnifiedPage.otp4, "1");			
			WebInteractUtil.isPresent(UnifiedPage.VerifyOtpBtn, 60);
			WebInteractUtil.Click(UnifiedPage.VerifyOtpBtn);
			WebInteractUtil.isPresent(UnifiedPage.Passwordclose, 60);
			WebInteractUtil.Click(UnifiedPage.Passwordclose);
	//-----	
			WebInteractUtil.isPresent(UnifiedPage.InfinityLogo, 60);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.ProfileIcon, 60);
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.isPresent(UnifiedPage.LogoutBtn, 60);
			WebInteractUtil.Click(UnifiedPage.LogoutBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHomePage, 60)){
				LoggerUtil.printExtentLog("Pass", "Application Logout is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application Logout is not successfull while checking update password functionality with OTP, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.Signintxtbtn, 60);
			WebInteractUtil.Click(UnifiedPage.Signintxtbtn);
			WebInteractUtil.Waittilljquesryupdated();
			Thread.sleep(1000);
			WebInteractUtil.isPresent(UnifiedPage.PhoneNumberTxb, 60);
			WebInteractUtil.SendKeys(UnifiedPage.PhoneNumberTxb, testdata.get("PhoneNumber"));
			Thread.sleep(1000);
			WebInteractUtil.Click(UnifiedPage.LoginWPassBtn);
			WebInteractUtil.isPresent(UnifiedPage.PassWordTxb, 60);
			WebInteractUtil.SendKeys(UnifiedPage.PassWordTxb, testdata.get("NewPassword"));
			WebInteractUtil.Click(UnifiedPage.LoginBtn);
			WebInteractUtil.Waittilljquesryupdated();	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHome, 60)){
				LoggerUtil.printExtentLog("Pass", "Application SignIn with new password via OTP is successfull, Update password via OTP functionality is working as expected");
				WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
				WebInteractUtil.Click(UnifiedPage.ProfileIcon);
				WebInteractUtil.Click(UnifiedPage.ProfileBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.Click(UnifiedPage.ChangePassBtn);
				WebInteractUtil.SendKeys(UnifiedPage.CurrentPassTxb, testdata.get("NewPassword"));
				WebInteractUtil.SendKeys(UnifiedPage.NewPasswordTxb, testdata.get("Password"));
				WebInteractUtil.SendKeys(UnifiedPage.ConfirmPassTxb, testdata.get("Password"));
				WebInteractUtil.Click(UnifiedPage.ResetPassBtn);
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull with new password via OTP, Please check update passowrd functionality");
				Status ="False";}
				return Status;}
		
			
			
			
/*			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ChangePassBtn, 60)){
				LoggerUtil.printExtentLog("Pass", "Change password with OTP is  successful");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Change password with OTP is not successful, Please check");
				Status ="False";}
			
				return Status;}*/
		
		
//		GRADES		
		public String VerifyGrades(Map<String, String> testdata) throws Exception{				
			String Status = null;		
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.Grade1, 60);	
			WebInteractUtil.isPresent(UnifiedPage.Grade2, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade3, 60);	
			WebInteractUtil.isPresent(UnifiedPage.Grade4, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade5, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade6, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade7, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade8, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade9, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade10, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade11th, 60);
			WebInteractUtil.isPresent(UnifiedPage.Grade12, 60);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Grade13, 60)) {
				LoggerUtil.printExtentLog("Pass", "All grades are available to select");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Grades are not avialble to select, Please check");
				Status ="False";}	
			
			WebInteractUtil.Click(UnifiedPage.Grade1);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "1st Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 1st Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			
			
			WebInteractUtil.Click(UnifiedPage.Grade2);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "2nd Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 2nd Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			
			WebInteractUtil.Click(UnifiedPage.Grade3);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "3rd Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 3rd Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade4);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "4th Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 4th Grade and Aptitude Target Exam, Please check");
				Status ="False";}
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade5);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectApt, 60);
			WebInteractUtil.Click(UnifiedPage.SelectApt);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "5th Grade and Aptitude Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 5th Grade and Aptitude Target Exam, Please check");
				Status ="False";}
						
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade6);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.isPresent(UnifiedPage.SelectFound, 60);
			WebInteractUtil.Click(UnifiedPage.SelectFound);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "6th Grade and Foundation Test Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 6th Grade and Foundation Test Target Exam, Please check");
				Status ="False";}
			
			
			
			
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade7);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.isPresent(UnifiedPage.SelectFound, 60);
			WebInteractUtil.Click(UnifiedPage.SelectFound);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "7th Grade and Foundation Test Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 7th Grade and Foundation Test Target Exam, Please check");
				Status ="False";}
			
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade8);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectFound, 60);
			WebInteractUtil.Click(UnifiedPage.SelectFound);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "8th Grade and Foundation Test Target Exam updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 8th Grade and Foundation Test Target Exam, Please check");
				Status ="False";}
			
						WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade9);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "9th Grade and Neet, Jee Main and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 9th Grade and Neet, Jee Main and CBSE Target Exams, Please check");
				Status ="False";}
			
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade10);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "10th Grade and Neet, Jee Main and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 10th Grade and Neet, Jee Main and CBSE Target Exams, Please check");
				Status ="False";}
			
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade11th);
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectJeeAdv, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "11th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 11th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams, Please check");
				Status ="False";}
			
				
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade12);
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectJeeAdv, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.isPresent(UnifiedPage.SelectCbse, 60);
			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "12th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 10th Grade and Neet, Jee Main, Jee Advanced and CBSE Target Exams, Please check");
				Status ="False";}
			
				
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.Click(UnifiedPage.Grade13);
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);	
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExams, 60);
			WebInteractUtil.isPresent(UnifiedPage.SelectJee, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.isPresent(UnifiedPage.SelectJeeAdv, 60);
			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
			WebInteractUtil.isPresent(UnifiedPage.SelectNeet, 60);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				LoggerUtil.printExtentLog("Pass", "13th Grade and Neet, Jee Main and Jee Advanced Target Exams updated successfully");
				Status = "True";
				}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to update 10th Grade and Neet, Jee Main and Jee Advanced Target Exams, Please check");
				Status ="False";}
			return Status;}
			
//			STREAMS
			public String VerifyStream(Map<String, String> testdata) throws Exception{				
			String Status = null;
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.SelectPCM, 60);	
			WebInteractUtil.isPresent(UnifiedPage.SelectPCB, 60);	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SelectPCMB, 60)) {
				LoggerUtil.printExtentLog("Pass", "All Streams are available to select");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Streams are not avialble to select, Please check");
				Status ="False";}
			return Status;}
//			BOARDS			
			public String VerifyBoard(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.BoardCBSE, 60);
			WebInteractUtil.Click(UnifiedPage.BoardCBSE);
			WebInteractUtil.isPresent(UnifiedPage.BoardICSE, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardKarnataka, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardAndhra, 60);
	//		Actions action = new Actions(driver);
	//		action.moveToElement(UnifiedPage.BoardRajasthan);
			WebInteractUtil.isPresent(UnifiedPage.BoardRajasthan, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardMadhya, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardWestBengal, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardGoa, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardJammu, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardBihar, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardChhattisgarh, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardGujarat, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardHaryana, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardJharkhand, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardKerala, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardOrissa, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardPunjab, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardTamil, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardTelangana, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardUttarakhand, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardUttar, 60);
			WebInteractUtil.isPresent(UnifiedPage.BoardOrissa, 60);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.BoardUttar, 60)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UnifiedPage.BoardUttar);
				LoggerUtil.printExtentLog("Pass", "All Boards are available to select");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Boards are not avialble to select, Please check");
				Status ="False";}
			WebInteractUtil.Click(UnifiedPage.saveafterboards);
			WebInteractUtil.Click(UnifiedPage.clkBack);
			
			return Status;}
			
			public String ProfileUpdate(Map<String, String> testdata) throws Exception{				
				String Status = null;
				
				WebInteractUtil.isPresent(UnifiedPage.ProfileIcon,60);
				WebInteractUtil.Click(UnifiedPage.ProfileIcon);
				WebInteractUtil.Click(UnifiedPage.ProfileBtn);
				

			WebInteractUtil.isPresent(UnifiedPage.persnldtlsbtn, 60);
			WebInteractUtil.Click(UnifiedPage.persnalEdit);			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.basicdetilsbtn, 60)) {
				LoggerUtil.printExtentLog("Pass", "Successfully Navigated to Edit Profile Page");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to Edit Profile Page, Please check");
				Status ="False";}			
			Thread.sleep(1000);
			driver.findElement( By.xpath("//input[@placeholder='Email ID']")).clear();
			Thread.sleep(1000);
			WebInteractUtil.SendKeys(UnifiedPage.emailID, testdata.get("EmailID"));			
			WebInteractUtil.isPresent(UnifiedPage.Addressbtn, 60);
			driver.findElement(By.xpath("//input[@formcontrolname='addressLine1']")).clear();
			WebInteractUtil.SendKeys(UnifiedPage.enteraddress, testdata.get("Address"));			
			WebInteractUtil.isPresent(UnifiedPage.clkcity,60);
			driver.findElement(By.xpath("//input[@formcontrolname='city']")).clear();
			WebInteractUtil.SendKeys(UnifiedPage.clkcity, testdata.get("City"));			
			WebInteractUtil.isPresent(UnifiedPage.clkpincode,60);
			driver.findElement(By.xpath("//input[@name='pincode']")).clear();
			WebInteractUtil.SendKeys(UnifiedPage.clkpincode, testdata.get("Pincode"));		
			WebInteractUtil.isPresent(UnifiedPage.clkparentName,60);
			driver.findElement(By.xpath("//input[@formcontrolname='guardiansName']")).clear();
			WebInteractUtil.SendKeys(UnifiedPage.clkparentName, testdata.get("ParentName"));			
			WebInteractUtil.isPresent(UnifiedPage.clkparentNumber,60);
			driver.findElement(By.xpath("//input[@formcontrolname='guardianPhone']")).clear();
			WebInteractUtil.SendKeys(UnifiedPage.clkparentNumber, testdata.get("ParentNumber"));
			WebInteractUtil.isPresent(UnifiedPage.saveebtn, 60);			
			WebInteractUtil.Click(UnifiedPage.saveebtn);
			WebInteractUtil.Click(UnifiedPage.clkclose);
			LoggerUtil.printExtentLog("Pass", "Personal Details Updated Successfully");
			//System.out.println("Personal Details uploaded successfully");		
			Status="True";
						return Status;}		
			//MCT Tests
			public String MCTTests(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
			WebInteractUtil.Click(UnifiedPage.TestsBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MctBtn, 60);
			WebInteractUtil.Click(UnifiedPage.MctBtn);
			WebInteractUtil.Waittilljquesryupdated();
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyMCTpage, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigation to MCT's Listing Page is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Navigation to MCT's Listing Page is not successfull, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.AttemptNowBtn, 60);
			WebInteractUtil.Click(UnifiedPage.AttemptNowBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGInsPage, 30)) {
//			Actions actions = new Actions(driver);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.SubmitBtn, 30);
			//WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60);
			WebInteractUtil.Click(UnifiedPage.SubmitBtn);
			WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
			WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
				LoggerUtil.printExtentLog("Pass", "MCT test successfully submitted");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to submit MCT test, Please check");
				Status ="False";}
			} 
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubscribeExpire, 30)){
				LoggerUtil.printExtentLog("INFO", "Your subscription package expired, Please take a trial and try again");
				actions.sendKeys(Keys.ESCAPE).build().perform();
				Status = "True";}
			return Status;	
	}	
			
			//MCT Tests--Integertypeqstn
			public String MCTTestsAttemptingIntegerQuestion(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
			WebInteractUtil.Click(UnifiedPage.TestsBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MctBtn, 60);
			WebInteractUtil.Click(UnifiedPage.MctBtn);
			WebInteractUtil.Waittilljquesryupdated();
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyMCTpage, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigation to MCT's Listing Page is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Navigation to MCT's Listing Page is not successfull, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.AttemptNowBtn, 60);
			WebInteractUtil.Click(UnifiedPage.AttemptNowBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGInsPage, 30)) {
//			Actions actions = new Actions(driver);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
			WebInteractUtil.Waittilljquesryupdated();
			
			WebInteractUtil.isPresent(UnifiedPage.number3, 30);
			WebInteractUtil.Click(UnifiedPage.number3);
			WebInteractUtil.isPresent(UnifiedPage.clearbrn, 30);
			WebInteractUtil.Click(UnifiedPage.clearbrn);
			WebInteractUtil.isPresent(UnifiedPage.SaveNextBtn, 30);
			WebInteractUtil.Click(UnifiedPage.SaveNextBtn);
			WebInteractUtil.isPresent(UnifiedPage.number3, 30);
			WebInteractUtil.Click(UnifiedPage.number3);
			
			WebInteractUtil.isPresent(UnifiedPage.SubmitBtn, 30);
			//WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60);
			WebInteractUtil.Click(UnifiedPage.SubmitBtn);
			WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
			WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
				LoggerUtil.printExtentLog("Pass", "MCT test successfully submitted");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Unable to submit MCT test, Please check");
				Status ="False";}
			} 
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubscribeExpire, 30)){
				LoggerUtil.printExtentLog("INFO", "Your subscription package expired, Please take a trial and try again");
				actions.sendKeys(Keys.ESCAPE).build().perform();
				Status = "True";}
			return Status;	
	}	
			//SCORE Tests
			public String ScoreTest(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
			WebInteractUtil.Click(UnifiedPage.TestsBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ScoreBtn, 60);
			WebInteractUtil.Click(UnifiedPage.ScoreBtn);
			WebInteractUtil.Waittilljquesryupdated();
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyScorePage, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigation to Score page is successful");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Navigation to Score Page is not successfull, Please check");
				Status ="False";}
			
			WebInteractUtil.isPresent(UnifiedPage.ReAttemptbtn, 60);
			WebInteractUtil.Click(UnifiedPage.ReAttemptbtn);
			WebInteractUtil.isPresent(UnifiedPage.RegisterBtn, 60);
			WebInteractUtil.Click(UnifiedPage.RegisterBtn);
			Thread.sleep(1000);
			WebInteractUtil.isPresent(UnifiedPage.PrcdTochkout, 60);      //page is moving to subscriptions page
			WebInteractUtil.Click(UnifiedPage.PrcdTochkout);	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.NofItems, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigated to My Cart Page");
				WebInteractUtil.isPresent(UnifiedPage.ScoreNxtBtn, 60); 
				WebInteractUtil.Click(UnifiedPage.ScoreNxtBtn);	
				Status = "True";
				}else{	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to Mycart page, Please check");
				Status ="False";}
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyBilling, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigated to Billing Information Page");
				
				Status = "True";
				}else{	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to Billing Information page, Please check");
				Status ="False";}
			
			WebInteractUtil.isPresent(UnifiedPage.BillingPageNxtBtn, 60);
			WebInteractUtil.Click(UnifiedPage.BillingPageNxtBtn);	
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPymtPage, 60)) {
				LoggerUtil.printExtentLog("Pass", "Navigated to Payment Page");
				Status = "True";
				}else{	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to Payment page, Please check");
				Status ="False";}
			
            
			
			
			//NETBANKING
			//WebInteractUtil.isPresent(UnifiedPage.netbanking,60);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.netbanking, 60)) {
				WebInteractUtil.Click(UnifiedPage.netbanking);
				LoggerUtil.printExtentLog("Pass", "successfully Navigated to NetBanking Payment Page");
				Status = "True";
				}else{	
				LoggerUtil.printExtentLog("Fail", "Unable to navigate to NetBanking Payment page, Please check");
				Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.ICICIBank,60);
			WebInteractUtil.isPresent(UnifiedPage.IDBiBank,60);
			WebInteractUtil.isPresent(UnifiedPage.BOBbank,60);
			WebInteractUtil.Click(UnifiedPage.ICICIBank);
			WebInteractUtil.isPresent(UnifiedPage.payusingNetbanking,60);
			LoggerUtil.printExtentLog("Pass", "Pay using NetBanking button is visible ");
			WebInteractUtil.Click(UnifiedPage.payusingNetbanking);
			
		//	WebInteractUtil.isPresent(UnifiedPage.Successmsg,60);
		//	WebInteractUtil.Click(UnifiedPage.Successmsg);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.subscriptiondetails, 60)) {				
				LoggerUtil.printExtentLog("Pass", "successfully Navigated to Subscription details Page");
				Status = "True";
				}else{	
				LoggerUtil.printExtentLog("Fail", "Unable to Subscription details page, Please check");
				Status ="False";}
			
			WebInteractUtil.isPresent(UnifiedPage.GetStartedbtn,60);
			WebInteractUtil.Click(UnifiedPage.GetStartedbtn);
			WebInteractUtil.isPresent(UnifiedPage.ScoreAttemptnow,60);
			WebInteractUtil.Click(UnifiedPage.ScoreAttemptnow);
			
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGInsPage, 30)) {
//				Actions actions = new Actions(driver);
				Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
				scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
				WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.SubmitBtn, 30);
				//WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60);
				WebInteractUtil.Click(UnifiedPage.SubmitBtn);
				WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
				WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
				WebInteractUtil.Click(UnifiedPage.CloseBtn);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
					LoggerUtil.printExtentLog("Pass", "Score test successfully submitted");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Unable to submit Score test, Please check");
					Status ="False";}
				} 
							
			return Status;	
	}	
			
			public String Select11Grade(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.Grade11th, 60);
			WebInteractUtil.Click(UnifiedPage.Grade11th);
			WebInteractUtil.isPresent(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardAndhra, 60);
			WebInteractUtil.Click(UnifiedPage.BoardAndhra);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BoardAndhra);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.isPresent(UnifiedPage.SaveGrade, 60);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExam, 60);
//			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
//			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
//			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			LoggerUtil.printExtentLog("Pass", "11th Grade and NEET Target Exam updated successfully");
			WebInteractUtil.isPresent(UnifiedPage.InfinityLogo, 60);
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			Status = "True";
			}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to update 11th Grade and NEET Target Exam, Please check");
			Status ="False";}
			return Status;	
			}
		public String PYPReports(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
				WebInteractUtil.Click(UnifiedPage.TestsBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PYPBtn, 60);
				WebInteractUtil.Click(UnifiedPage.PYPBtn);
				WebInteractUtil.Waittilljquesryupdated();
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPYPpage, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigation to PYP's Listing Page is successfull");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Navigation to PYP's Listing Page is not successfull, Please check");
					Status ="False";}
				WebInteractUtil.isPresent(UnifiedPage.CompletedLst, 60);
				WebInteractUtil.Click(UnifiedPage.CompletedLst);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.TstRptBtn, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigation to Test Report's under completed is successfull,Tests Reports are available");
					WebInteractUtil.Click(UnifiedPage.TstRptBtn);
					WebInteractUtil.Waittilljquesryupdated();
					WebInteractUtil.isPresent(UnifiedPage.ViewSolnBtn, 60);
					WebInteractUtil.Click(UnifiedPage.ViewSolnBtn);
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifySolnPage, 60)) {
						WebInteractUtil.Click(UnifiedPage.InfinityLogo);
						LoggerUtil.printExtentLog("Pass", "Navigation to View Solution Page is successfull");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Navigation to View Solution Page is not successfull, Please check");
						Status ="False";}	
				}	else {	
					LoggerUtil.printExtentLog("INFO", "Test Reports are not available under completed, Please submit a PYP test and try again");
					WebInteractUtil.Click(UnifiedPage.InfinityLogo);
					Status ="True";}
				return Status;	
			}
			public String SelectGrade(Map<String, String> testdata) throws Exception{				
				String Status = null;
			WebInteractUtil.isPresent(UnifiedPage.VerifyHome, 60);	
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.Click(UnifiedPage.ProfileBtn);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.AcademicEdit, 60);	
			WebInteractUtil.Click(UnifiedPage.AcademicEdit);
			WebInteractUtil.isPresent(UnifiedPage.Grade11, 60);
			WebInteractUtil.Click(UnifiedPage.Grade11);
			WebInteractUtil.isPresent(UnifiedPage.SelectPCMB, 60);
			WebInteractUtil.Click(UnifiedPage.SelectPCMB);
			WebInteractUtil.isPresent(UnifiedPage.BoardAndhra, 60);
			WebInteractUtil.Click(UnifiedPage.BoardAndhra);
			Actions scrollDown = actions.moveToElement(UnifiedPage.BoardAndhra);
			scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebInteractUtil.isPresent(UnifiedPage.SaveGrade, 60);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.VerifyTargetExam, 60);
//			WebInteractUtil.Click(UnifiedPage.SelectJee);
			WebInteractUtil.Click(UnifiedPage.SelectNeet);
//			WebInteractUtil.Click(UnifiedPage.SelectJeeAdv);
//			WebInteractUtil.Click(UnifiedPage.SelectCbse);
			WebInteractUtil.Click(UnifiedPage.SaveGrade);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTargetUpdated, 60)) {
			WebInteractUtil.Click(UnifiedPage.CloseBtn);
			LoggerUtil.printExtentLog("Pass", "11th Grade and NEET Target Exam updated successfully");
			WebInteractUtil.Click(UnifiedPage.InfinityLogo);
			Status = "True";
			}	else {	
			LoggerUtil.printExtentLog("Fail", "Unable to update 11th Grade and NEET Target Exam, Please check");
			Status ="False";}
			return Status;	
			}
		
			
//		Live classes
			public String FreeMasterClass(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.isPresent(UnifiedPage.LiveClassBtn, 60);
				WebInteractUtil.Click(UnifiedPage.LiveClassBtn);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.VerifyFreeMstrClass, 60);	
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.NoFreeMasterClass,60)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UnifiedPage.VerifyFreeMstrClass);
					LoggerUtil.printExtentLogWithScreenshot1("INFO", "Free MasterClasses are not available, Please check");
					String FreeMasterClass1=WebInteractUtil.getWebElementText(UnifiedPage.FreeMstrClass1);
					String FreeMasterClass2=WebInteractUtil.getWebElementText(UnifiedPage.FreeMstrClass2);
					Status = "True";
					}else if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.FreeMstrClass1, 60)){	
					LoggerUtil.printExtentLog("Pass", "Free MasterClasses are Available");
					Status ="True";}				
				Status = "true";			
				return Status;	
			}
			
			public String Subscriptions(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.Subscriptions, 60);
				WebInteractUtil.Click(UnifiedPage.Subscriptions);
				WebInteractUtil.Waittilljquesryupdated();		
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.CartBtn, 30)){
					//String CartCount=WebInteractUtil.getWebElementText(UnifiedPage.PackageNoinCart);
					WebInteractUtil.Click(UnifiedPage.CartBtn);
					LoggerUtil.printExtentLog("Pass", "Navigated to My Cart page");
//					WebInteractUtil.isPresent(UnifiedPage.NofItems, 60);
//					int CartCount11=Integer.parseInt(CartCount);  
//					for (int CartCount1=1; CartCount1<=CartCount11; CartCount1++) {
//					WebInteractUtil.isPresent(UnifiedPage.DeleteCart1, 60);
//					WebInteractUtil.Click(UnifiedPage.DeleteCart1);}
//					WebInteractUtil.isPresent(UnifiedPage.DeleteCart2, 60);
//					WebInteractUtil.Click(UnifiedPage.DeleteCart2);
					WebInteractUtil.isPresent(UnifiedPage.BuySubscptn, 60);
					WebInteractUtil.Click(UnifiedPage.BuySubscptn);
					WebInteractUtil.Waittilljquesryupdated();			
				}
/*				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ExploreOtherPack, 30)){
				WebInteractUtil.Click(UnifiedPage.ExploreOtherPack);
				Thread.sleep(3000);				
			    String oldTab = DriverManager.WEB_DRIVER_THREAD.get().getWindowHandle();
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				DriverManager.WEB_DRIVER_THREAD.get().switchTo().window(tabs.get(1));
				WebInteractUtil.Waittilljquesryupdated();		}
	*/			
				WebInteractUtil.isPresent(UnifiedPage.PackagePrice, 60);
				String PackagePrice=WebInteractUtil.getWebElementText(UnifiedPage.PackagePrice);
				System.out.println(PackagePrice);
				
				
				switch(PackagePrice) {
				case "39999":
					System.out.println("39999-Case 1");
					WebInteractUtil.isPresent(UnifiedPage.Add39999ToCart, 60);
					WebInteractUtil.Click(UnifiedPage.Add39999ToCart);
					WebInteractUtil.Waittilljquesryupdated();
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifySlctCourse, 60)) {
						LoggerUtil.printExtentLog("Pass", "Navigated to Select Course Page");
						WebInteractUtil.isPresent(UnifiedPage.UATLivecourse, 60);
						WebInteractUtil.Click(UnifiedPage.UATLivecourse);
						WebInteractUtil.isPresent(UnifiedPage.Batchslt, 60);
						WebInteractUtil.Click(UnifiedPage.Batchslt);
						WebInteractUtil.isPresent(UnifiedPage.NxtBtn, 60);
						WebInteractUtil.Click(UnifiedPage.NxtBtn);	
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to Navigate to select Course Page, Please check");
						Status ="False";}		
					WebInteractUtil.Waittilljquesryupdated();	
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Itemsadded, 60)) {
						LoggerUtil.printExtentLog("Pass", "Items has been added to your cart!");
						//WebInteractUtil.Click(UnifiedPage.NxtBtn);	
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to add items to your cart!, Please check");
						Status ="False";}
					WebInteractUtil.isPresent(UnifiedPage.PrcdTochkout, 60);
					WebInteractUtil.Click(UnifiedPage.PrcdTochkout);	
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.NofItems, 60)) {
						LoggerUtil.printExtentLog("Pass", "Navigated to My Cart Page");
						WebInteractUtil.Click(UnifiedPage.MyCartpageNxtBtn);	
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to Mycart page, Please check");
						Status ="False";}
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyBilling, 60)) {
						LoggerUtil.printExtentLog("Pass", "Navigated to Billing Information Page");
						
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to Billing Information page, Please check");
						Status ="False";}
					
					WebInteractUtil.isPresent(UnifiedPage.clksltaddress, 60);
					WebInteractUtil.Click(UnifiedPage.clksltaddress);
					WebInteractUtil.Click(UnifiedPage.BillingPageNxtBtn);	
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyPymtPage, 60)) {
						LoggerUtil.printExtentLog("Pass", "Navigated to Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to Payment page, Please check");
						Status ="False";}
					
                    
					//CARDPAYMENT
					WebInteractUtil.isPresent(UnifiedPage.Cardbtn,60);
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.EnterCardtn, 60)) {
						LoggerUtil.printExtentLog("Pass", "Navigated to Card Payment Page is successful");
						Status = "True";
					}
					WebInteractUtil.isPresent(UnifiedPage.nameoncard,60);
					WebInteractUtil.isPresent(UnifiedPage.Cardnumber,60);
					WebInteractUtil.isPresent(UnifiedPage.Expirydate,60);
					WebInteractUtil.isPresent(UnifiedPage.CVV,60);
//					WebInteractUtil.isPresent(UnifiedPage.paybtn,60);
					LoggerUtil.printExtentLog("Pass", "Pay using Card button is visible ");
					
					//NETBANKING
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.netbanking, 60)) {
						WebInteractUtil.Click(UnifiedPage.netbanking);
						LoggerUtil.printExtentLog("Pass", "successfully Navigated to NetBanking Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to NetBanking Payment page, Please check");
						Status ="False";}
					WebInteractUtil.isPresent(UnifiedPage.ICICIBank,60);
					WebInteractUtil.isPresent(UnifiedPage.IDBiBank,60);
					WebInteractUtil.isPresent(UnifiedPage.BOBbank,60);
					//WebInteractUtil.isPresent(UnifiedPage.payusingNetbanking,60);
					LoggerUtil.printExtentLog("Pass", "Pay using NetBanking button is visible ");
					
					
					//UPI/QR btn
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.UPIQRbtn, 60)) {
						WebInteractUtil.Click(UnifiedPage.UPIQRbtn);
						LoggerUtil.printExtentLog("Pass", "Navigated to UPI/QR Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to UPI/QR Payment page, Please check");
						Status ="False";}
					WebInteractUtil.isPresent(UnifiedPage.enterUPIbtn,60);
					WebInteractUtil.isPresent(UnifiedPage.showQRCodebtn,60);
					//WebInteractUtil.isPresent(UnifiedPage.payusingUPIbtn,60);
					LoggerUtil.printExtentLog("Pass", "Pay using UPI is visible ");
					
					//WALLET btn
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Walletbtn, 60)) {
						WebInteractUtil.Click(UnifiedPage.Walletbtn);
						LoggerUtil.printExtentLog("Pass", "Successfully Navigated to Wallet Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to Wallet Payment page, Please check");
						Status ="False";}
					
					WebInteractUtil.isPresent(UnifiedPage.mobikwikbtn,60);
					WebInteractUtil.isPresent(UnifiedPage.Payzappbtn,60);
					WebInteractUtil.isPresent(UnifiedPage.Olamoneybtn,60);
					//WebInteractUtil.isPresent(UnifiedPage.PayusingWalletbtn,60);
					LoggerUtil.printExtentLog("Pass", "Pay using Wallet is visible ");
					
					//EMI btn
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.EMIbtn, 60)) {
						WebInteractUtil.Click(UnifiedPage.EMIbtn);
						LoggerUtil.printExtentLog("Pass", "Successfully Navigated to EMI Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to Wallet Payment page, Please check");
						Status ="False";}
					

					//Pay in Parts btn
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.payinParts, 60)) {
						WebInteractUtil.Click(UnifiedPage.payinParts);
						LoggerUtil.printExtentLog("Pass", "Successfully Navigated to PayinParts Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to PayinParts Payment page, Please check");
						Status ="False";}
					//WebInteractUtil.isPresent(UnifiedPage.payusingpartsbtn,60);
					
					
					//Pay Later btn
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PayLaterbtn, 60)) {
						WebInteractUtil.Click(UnifiedPage.PayLaterbtn);
						LoggerUtil.printExtentLog("Pass", "Successfully Navigated to PayLater Payment Page");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to navigate to PayLater Payment page, Please check");
						Status ="False";}
					
					WebInteractUtil.isPresent(UnifiedPage.icicibank,60);
					WebInteractUtil.isPresent(UnifiedPage.Simpl,60);
					
					
					
					break;
				case "29999":
					System.out.println("29999-Case 2");
					WebInteractUtil.isPresent(UnifiedPage.Add29999ToCart, 60);
					WebInteractUtil.Click(UnifiedPage.Add29999ToCart);
					break;
				case " 12999 ":
					System.out.println("12999-Case 3");
					WebInteractUtil.isPresent(UnifiedPage.Add12999ToCart, 60);
					WebInteractUtil.Click(UnifiedPage.Add12999ToCart);
					break;
				case " 7199 ":
					System.out.println("1999-Case 4");
					WebInteractUtil.isPresent(UnifiedPage.Add18999ToCart, 60);
					WebInteractUtil.Click(UnifiedPage.Add18999ToCart);
					break;

				case " 125 ":
					System.out.println("125-Case 5");
					WebInteractUtil.isPresent(UnifiedPage.Add125ToCart, 60);
					WebInteractUtil.Click(UnifiedPage.Add125ToCart);
					break;
			}		
				Status = "True";
				return Status;	
			}
			
			public String DeleteSubscriptions(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.Subscriptions, 60);
				WebInteractUtil.Click(UnifiedPage.Subscriptions);
				WebInteractUtil.Waittilljquesryupdated();		
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.CartBtn, 30)){
					String CartCount=WebInteractUtil.getWebElementText(UnifiedPage.PackageNoinCart);
					WebInteractUtil.Click(UnifiedPage.CartBtn);
					LoggerUtil.printExtentLog("Pass", "Navigated to My Cart page");
					WebInteractUtil.isPresent(UnifiedPage.NofItems, 60);
					int CartCount11=Integer.parseInt(CartCount);  
					for (int CartCount1=1; CartCount1<=CartCount11; CartCount1++) {
					WebInteractUtil.isPresent(UnifiedPage.DeleteCart1, 60);
					WebInteractUtil.Click(UnifiedPage.DeleteCart1);}
					WebInteractUtil.isPresent(UnifiedPage.DeleteCart2, 60);
					WebInteractUtil.Click(UnifiedPage.DeleteCart2);
					WebInteractUtil.isPresent(UnifiedPage.BuySubscptn, 60);
					WebInteractUtil.Click(UnifiedPage.BuySubscptn);
					WebInteractUtil.Waittilljquesryupdated();
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Mysubscriptions, 60)) {
						LoggerUtil.printExtentLog("Pass", "Successfully removed Packages from cart");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to remove packages from cart, Please check");
						Status ="False";}
					
				}
				
				return Status;	
			}
			public String SubscriptionsPage(Map<String, String> testdata) throws Exception{				
				String Status = null;
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.Subscriptions, 60);
				WebInteractUtil.Click(UnifiedPage.Subscriptions);
				WebInteractUtil.Waittilljquesryupdated();	
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MySubstnpBtn, 60)) {
						LoggerUtil.printExtentLog("Pass", "Navigated to Subscriptions listing page");
						WebInteractUtil.isPresent(UnifiedPage.MySubstnpBtn, 60);
						LoggerUtil.printExtentLog("Pass", "My Subscriptions button is available");
						WebInteractUtil.isPresent(UnifiedPage.WishListBtn, 60);
						LoggerUtil.printExtentLog("Pass", "Wishlist button is available");
						WebInteractUtil.isPresent(UnifiedPage.CartBtn, 60);
						LoggerUtil.printExtentLog("Pass", "Cart button is available");
						Status = "True";
						}else{	
						LoggerUtil.printExtentLog("Fail", "Unable to Navigate to Subscriptions listing page, Please check");
						Status ="False";}
				WebInteractUtil.Click(UnifiedPage.MySubstnpBtn);
				WebInteractUtil.Waittilljquesryupdated();
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MySubstnpPageVerfy, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigated to My Subscriptions page");
					WebInteractUtil.Click(UnifiedPage.ExplorePackBtn);
					WebInteractUtil.Waittilljquesryupdated();
					 String oldTab = DriverManager.WEB_DRIVER_THREAD.get().getWindowHandle();
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						DriverManager.WEB_DRIVER_THREAD.get().switchTo().window(tabs.get(1));
				}else{	
					LoggerUtil.printExtentLog("Fail", "Unable to Navigate to My Subscriptions page, Please check");
					Status ="False";}
				WebInteractUtil.Click(UnifiedPage.WishListBtn);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MyWishListVerfy, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigated to Wishlist page");
					WebInteractUtil.Click(UnifiedPage.WishLstBackBtn);
					WebInteractUtil.Waittilljquesryupdated();
				}else{	
					LoggerUtil.printExtentLog("Fail", "Unable to Navigate to Wishlist page, Please check");
					Status ="False";}
				WebInteractUtil.Click(UnifiedPage.CartBtn);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.MyCartVerfy, 60)) {
					LoggerUtil.printExtentLog("Pass", "Navigated to My Cart page");
					WebInteractUtil.Click(UnifiedPage.WishLstBackBtn);
					WebInteractUtil.Waittilljquesryupdated();
				}else{	
					LoggerUtil.printExtentLog("Fail", "Unable to Navigate to MyCart page, Please check");
					Status ="False";}
						
				WebInteractUtil.Click(UnifiedPage.InfinityLogo);

				
				return Status;	
			}
			
			public String CYOT(Map<String, String> testdata) throws Exception{				
				String Status = null;
				
				WebInteractUtil.Click(UnifiedPage.TestsBtn);
				WebInteractUtil.isPresent(UnifiedPage.clkcYOT, 60);
				WebInteractUtil.Click(UnifiedPage.clkcYOT);
				WebInteractUtil.Click(UnifiedPage.clkcreatnewtest);
				Thread.sleep(1000);
				WebInteractUtil.Click(UnifiedPage.Chemistry);
				WebInteractUtil.Click(UnifiedPage.Physics);
				WebInteractUtil.Click(UnifiedPage.Botany);
				WebInteractUtil.Click(UnifiedPage.Zoology);
				WebInteractUtil.Waittilljquesryupdated();
				WebInteractUtil.isPresent(UnifiedPage.clkNext, 60);
				WebInteractUtil.Click(UnifiedPage.clkNext);
				
				WebInteractUtil.Click(UnifiedPage.sltChemsistryall);
				WebInteractUtil.Click(UnifiedPage.sltPhysicsall);
				WebInteractUtil.Click(UnifiedPage.sltBotanyall);
				WebInteractUtil.Click(UnifiedPage.sltBotanyall);
				WebInteractUtil.Click(UnifiedPage.clksecondNext);
				
				WebInteractUtil.Click(UnifiedPage.clk30min);
				WebInteractUtil.Click(UnifiedPage.slt20qstn);
				WebInteractUtil.Click(UnifiedPage.clkcreteTest);
				//WebInteractUtil.isPresent(UnifiedPage.attempttestbtn, 60);
				WebInteractUtil.isPresent(UnifiedPage.clkCancelBtn, 60);
				WebInteractUtil.Click(UnifiedPage.clkCancelBtn);		
				
								if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.clkcreatnewtest, 60)){
					LoggerUtil.printExtentLog("Pass", "CYOT created successfully");
					
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Unable to create CYOT, Please check");
					Status ="False";}
								
								
								WebInteractUtil.isPresent(UnifiedPage.clkAttemptNow, 60);
								WebInteractUtil.Click(UnifiedPage.clkAttemptNow);	
								WebInteractUtil.Waittilljquesryupdated();
								WebInteractUtil.isPresent(UnifiedPage.CYOTTestInstructions, 60);
//								Actions actions = new Actions(driver);
								Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
								scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
								WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
								WebInteractUtil.Waittilljquesryupdated();
								if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyTest, 60)) {
									LoggerUtil.printExtentLog("Pass", " Test started successfully");
									Status = "True";
								}	else {	
									LoggerUtil.printExtentLog("Fail", "Unable to start Test, Please check");
									Status ="False";}
				
								WebInteractUtil.Click(UnifiedPage.SubmitBtn);
								WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
								WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
								WebInteractUtil.Click(UnifiedPage.CloseBtn);
								if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
									LoggerUtil.printExtentLog("Pass", "CYOT test successfully submitted");
									Status = "True";
								}	else {	
									LoggerUtil.printExtentLog("Fail", "Unable to submit CYOT test, Please check");
									Status ="False";}
								WebInteractUtil.Waittilljquesryupdated();
								WebInteractUtil.isPresent(UnifiedPage.ViewSolnBtn, 60);
								WebInteractUtil.Click(UnifiedPage.ViewSolnBtn);
								if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifySolnPage, 60)) {
									WebInteractUtil.Click(UnifiedPage.InfinityLogo);
									LoggerUtil.printExtentLog("Pass", "Navigation to View Solution Page is successfull");
									Status = "True";
								}	else {	
									LoggerUtil.printExtentLog("Fail", "Navigation to View Solution Page is not successfull, Please check");
									Status ="False";}
											
								return Status;}
			
			public String Learn(Map<String, String> testdata) throws Exception{				
				String Status = null;
				
				///FOR CHEMISTRY SUBJECT
				
				WebInteractUtil.Click(UnifiedPage.Learn);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Chemistrybtn, 60)) {
					WebInteractUtil.Click(UnifiedPage.Chemistrybtn);
					LoggerUtil.printExtentLog("Pass", "Navigation to Self Learn Page is successfull");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Navigation to Self Learn Page is not successfull, Please check");
					Status ="False";}
				
				//WebInteractUtil.isPresent(UnifiedPage.allTopics, 60);
				WebInteractUtil.isPresent(UnifiedPage.clk1stchapter,60);
				WebInteractUtil.Click(UnifiedPage.clk1stchapter);
				WebInteractUtil.Click(UnifiedPage.playvedio);
				WebInteractUtil.Click(UnifiedPage.leftsidedownplaybtn);
				Thread.sleep(3000);
				WebInteractUtil.isPresent(UnifiedPage.resumevideo,60);
				WebInteractUtil.Click(UnifiedPage.resumevideo);
				WebInteractUtil.Click(UnifiedPage.backkbtnn);
				
				WebInteractUtil.isPresent(UnifiedPage.Flashcardsbtn, 60);
				WebInteractUtil.Click(UnifiedPage.Flashcardsbtn);
				WebInteractUtil.Click(UnifiedPage.clk1stChapter);
				WebInteractUtil.Click(UnifiedPage.clkStartLEarning);
				//WebInteractUtil.Click(UnifiedPage.knwmorebtn);
				WebInteractUtil.Click(UnifiedPage.rightarrow);
				WebInteractUtil.Click(UnifiedPage.rightarrow);
				WebInteractUtil.Click(UnifiedPage.strRevision);
				WebInteractUtil.isPresent(UnifiedPage.sltoption1, 60);
				WebInteractUtil.Click(UnifiedPage.sltoption1);
				WebInteractUtil.Click(UnifiedPage.answersubmtbtn);
				WebInteractUtil.Click(UnifiedPage.answerfinishbtn);
				WebInteractUtil.Click(UnifiedPage.quitbtn);
				WebInteractUtil.Click(UnifiedPage.Stories);
				WebInteractUtil.isPresent(UnifiedPage.clkArticle,60);
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.chapterprogressbtn, 60)) {
					
					LoggerUtil.printExtentLog("Pass", "You have successfully attempted Self Learn Chemistry Test ");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "You have not attempted Self Learn, Please check");
					Status ="False";}
			WebInteractUtil.isPresent(UnifiedPage.homebtn,60);
			WebInteractUtil.Click(UnifiedPage.homebtn);
			
			WebInteractUtil.Waittilljquesryupdated();
			WebInteractUtil.isPresent(UnifiedPage.ProfileIcon, 60);
			WebInteractUtil.Click(UnifiedPage.ProfileIcon);
			WebInteractUtil.isPresent(UnifiedPage.LogoutBtn, 60);
			WebInteractUtil.Click(UnifiedPage.LogoutBtn);
			if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyHomePage, 60)){
				LoggerUtil.printExtentLog("Pass", "Application Logout is successfull");
				Status = "True";
			}	else {	
				LoggerUtil.printExtentLog("Fail", "Application Logout is not successfull, Please check");
				Status ="False";}
				
//			     ///FOR PHYSICS SUBJECT
//				WebInteractUtil.Click(UnifiedPage.Learn);
//				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Physicsbtn, 60)) {
//					WebInteractUtil.Click(UnifiedPage.Physicsbtn);
//					LoggerUtil.printExtentLog("Pass", "Navigation to Self Learn Page is successfull");
//					Status = "True";
//				}	else {	
//					LoggerUtil.printExtentLog("Fail", "Navigation to Self Learn Page is not successfull, Please check");
//					Status ="False";}
//				
//				WebInteractUtil.isPresent(UnifiedPage.clk1stchapter,60);
//				WebInteractUtil.Click(UnifiedPage.clk1stchapter);
//				WebInteractUtil.Click(UnifiedPage.playvedio);
//				WebInteractUtil.Click(UnifiedPage.leftsidedownplaybtn);
//				Thread.sleep(3000);
//				WebInteractUtil.isPresent(UnifiedPage.resumevideo,60);
//				WebInteractUtil.Click(UnifiedPage.resumevideo);
//				WebInteractUtil.Click(UnifiedPage.backkbtnn);
//				
//				WebInteractUtil.isPresent(UnifiedPage.Flashcardsbtn, 60);
//				WebInteractUtil.Click(UnifiedPage.Flashcardsbtn);
//				WebInteractUtil.Click(UnifiedPage.clk1stChapter);
//				WebInteractUtil.Click(UnifiedPage.clkStartLEarning);
//				//WebInteractUtil.Click(UnifiedPage.knwmorebtn);
//				WebInteractUtil.Click(UnifiedPage.rightarrow);
//				WebInteractUtil.Click(UnifiedPage.strRevision);
//				WebInteractUtil.isPresent(UnifiedPage.sltoption1, 60);
//				WebInteractUtil.Click(UnifiedPage.sltoption1);
//				WebInteractUtil.Click(UnifiedPage.answersubmtbtn);
//				WebInteractUtil.Click(UnifiedPage.answerfinishbtn);
//				WebInteractUtil.Click(UnifiedPage.quitbtn);
//				//WebInteractUtil.Click(UnifiedPage.Stories);
//				//WebInteractUtil.Click(UnifiedPage.clkArticle);
//				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.chapterprogressbtn, 60)) {
//					
//					LoggerUtil.printExtentLog("Pass", "You have successfully attempted Self Learn Physics Test ");
//					Status = "True";
//				}	else {	
//					LoggerUtil.printExtentLog("Fail", "You have not attempted Self Learn, Please check");
//					Status ="False";}
//				
//				 ///FOR BOTANY SUBJECT
//				WebInteractUtil.Click(UnifiedPage.Learn);
//				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Botanybtn, 60)) {
//					WebInteractUtil.Click(UnifiedPage.Botanybtn);
//					LoggerUtil.printExtentLog("Pass", "Navigation to Self Learn Page is successfull");
//					Status = "True";
//				}	else {	
//					LoggerUtil.printExtentLog("Fail", "Navigation to Self Learn Page is not successfull, Please check");
//					Status ="False";}
//				
//				WebInteractUtil.isPresent(UnifiedPage.clk1stchapter,60);
//				WebInteractUtil.Click(UnifiedPage.clk1stchapter);
//				WebInteractUtil.Click(UnifiedPage.playvedio);
//				WebInteractUtil.Click(UnifiedPage.leftsidedownplaybtn);
//				Thread.sleep(3000);
//				WebInteractUtil.isPresent(UnifiedPage.resumevideo,60);
//				WebInteractUtil.Click(UnifiedPage.resumevideo);
//				WebInteractUtil.Click(UnifiedPage.backkbtnn);
//				
//				WebInteractUtil.isPresent(UnifiedPage.Flashcardsbtn, 60);
//				WebInteractUtil.Click(UnifiedPage.Flashcardsbtn);
//				WebInteractUtil.Click(UnifiedPage.clk1stChapter);
//				WebInteractUtil.Click(UnifiedPage.clkStartLEarning);
//				//WebInteractUtil.Click(UnifiedPage.knwmorebtn);
//				WebInteractUtil.Click(UnifiedPage.rightarrow);
//				WebInteractUtil.Click(UnifiedPage.strRevision);
//				WebInteractUtil.isPresent(UnifiedPage.sltoption1, 60);
//				WebInteractUtil.Click(UnifiedPage.sltoption1);
//				WebInteractUtil.Click(UnifiedPage.answersubmtbtn);
//				WebInteractUtil.Click(UnifiedPage.answerfinishbtn);
//				WebInteractUtil.Click(UnifiedPage.quitbtn);
//				//WebInteractUtil.Click(UnifiedPage.Stories);
//				//WebInteractUtil.Click(UnifiedPage.clkArticle);
//				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.chapterprogressbtn, 60)) {
//					
//					LoggerUtil.printExtentLog("Pass", "You have successfully attempted Self Learn Botany Test ");
//					Status = "True";
//				}	else {	
//					LoggerUtil.printExtentLog("Fail", "You have not attempted Self Learn, Please check");
//					Status ="False";}
//				
//				
//				 ///FOR ZOOLOGY SUBJECT
//				WebInteractUtil.Click(UnifiedPage.Learn);
//				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Zoologybtn, 60)) {
//					WebInteractUtil.Click(UnifiedPage.Zoologybtn);
//					LoggerUtil.printExtentLog("Pass", "Navigation to Self Learn Page is successfull");
//					Status = "True";
//				}	else {	
//					LoggerUtil.printExtentLog("Fail", "Navigation to Self Learn Page is not successfull, Please check");
//					Status ="False";}
//				
//				WebInteractUtil.isPresent(UnifiedPage.clk1stchapter,60);
//				WebInteractUtil.Click(UnifiedPage.clk1stchapter);
//				WebInteractUtil.Click(UnifiedPage.playvedio);
//				WebInteractUtil.Click(UnifiedPage.leftsidedownplaybtn);
//				Thread.sleep(3000);
//				WebInteractUtil.isPresent(UnifiedPage.resumevideo,60);
//				WebInteractUtil.Click(UnifiedPage.resumevideo);
//				WebInteractUtil.Click(UnifiedPage.backkbtnn);
//				
//				WebInteractUtil.isPresent(UnifiedPage.Flashcardsbtn, 60);
//				WebInteractUtil.Click(UnifiedPage.Flashcardsbtn);
//				WebInteractUtil.Click(UnifiedPage.clk1stChapter);
//				WebInteractUtil.Click(UnifiedPage.clkStartLEarning);
//				//WebInteractUtil.Click(UnifiedPage.knwmorebtn);
//				WebInteractUtil.Click(UnifiedPage.rightarrow);
//				WebInteractUtil.Click(UnifiedPage.strRevision);
//				WebInteractUtil.isPresent(UnifiedPage.sltoption1, 60);
//				WebInteractUtil.Click(UnifiedPage.sltoption1);
//				WebInteractUtil.Click(UnifiedPage.answersubmtbtn);
//				WebInteractUtil.Click(UnifiedPage.answerfinishbtn);
//				WebInteractUtil.Click(UnifiedPage.quitbtn);
//				//WebInteractUtil.Click(UnifiedPage.Stories);
//				//WebInteractUtil.Click(UnifiedPage.clkArticle);
//				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.chapterprogressbtn, 60)) {
//					
//					LoggerUtil.printExtentLog("Pass", "You have successfully attempted Self Learn Zoology Test ");
//					Status = "True";
//				}	else {	
//					LoggerUtil.printExtentLog("Fail", "You have not attempted Self Learn, Please check");
//					Status ="False";}
				
				return Status;}
				
			
			
			
			public String ILTSTest(Map<String, String> testdata) throws Exception{				
				String Status = null;
				
				WebInteractUtil.isPresent(UnifiedPage.TestsBtn, 60);
				WebInteractUtil.Click(UnifiedPage.TestsBtn);
				if(WebInteractUtil.isPresent(UnifiedPage.ILTSTestopen, 60)) {
					
					LoggerUtil.printExtentLog("Pass", "Navigation to Tests Page is successfull");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Currently there is no any ILTS Tests, Please check");
					Status ="False";}
				
				WebInteractUtil.Click(UnifiedPage.ILTSTestopen);
				Thread.sleep(1000);
				
				WebInteractUtil.isPresent(UnifiedPage.attemptttnoww,60);
				WebInteractUtil.Click(UnifiedPage.attemptttnoww);
				WebInteractUtil.isPresent(UnifiedPage.firstqstnopt2,60);
				WebInteractUtil.Click(UnifiedPage.firstqstnopt2);
				WebInteractUtil.isPresent(UnifiedPage.clkkSaveandNext,60);
				WebInteractUtil.Click(UnifiedPage.clkkSaveandNext);
				WebInteractUtil.isPresent(UnifiedPage.markforReviewBtnn,60);
				WebInteractUtil.Click(UnifiedPage.markforReviewBtnn);
				WebInteractUtil.isPresent(UnifiedPage.clksubmitttbtn,60);
				WebInteractUtil.Click(UnifiedPage.clksubmitttbtn);
				WebInteractUtil.isPresent(UnifiedPage.FinishTestt,60);
				WebInteractUtil.Click(UnifiedPage.FinishTestt);
				WebInteractUtil.isPresent(UnifiedPage.sltMedium,60);
				WebInteractUtil.Click(UnifiedPage.sltMedium);
				WebInteractUtil.isPresent(UnifiedPage.clkkksubmitt,60);
				WebInteractUtil.Click(UnifiedPage.clkkksubmitt);
				WebInteractUtil.isPresent(UnifiedPage.clkkclose,60);
				WebInteractUtil.Click(UnifiedPage.clkkclose);
				
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
					LoggerUtil.printExtentLog("Pass", "ILTS test successfully submitted");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Unable to submit ILTS test, Please check");
					Status ="False";}
		
				return Status;}
			
				
			public String RAPDailyTest(Map<String, String> testdata) throws Exception{				
				String Status = null;
			
				WebInteractUtil.Click(UnifiedPage.TestsBtn);
				if(WebInteractUtil.isPresent(UnifiedPage.RAPDT, 60)) {
					
					LoggerUtil.printExtentLog("Pass", "Navigation to Tests Page is successfull");
					Status = "True";
				}	else {	
					LoggerUtil.printExtentLog("Fail", "Currently there are Tests, Please check");
					Status ="False";}
				WebInteractUtil.Click(UnifiedPage.RAPDT);
				WebInteractUtil.isPresent(UnifiedPage.RAPDTAttemptnow, 60);
				WebInteractUtil.Click(UnifiedPage.RAPDTAttemptnow);
				
				if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.VerifyGInsPage, 30)) {
//					Actions actions = new Actions(driver);
					Actions scrollDown = actions.moveToElement(UnifiedPage.BeginTestBtn);
					scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
					WebInteractUtil.Click(UnifiedPage.BeginTestBtn);
					WebInteractUtil.Waittilljquesryupdated();
					WebInteractUtil.isPresent(UnifiedPage.SubmitBtn, 30);
					//WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SubmitBtn, 60);
					WebInteractUtil.Click(UnifiedPage.SubmitBtn);
					WebInteractUtil.Click(UnifiedPage.FinishTstBtn);
					WebInteractUtil.Click(UnifiedPage.FinalSubmitBtn);
					WebInteractUtil.Click(UnifiedPage.CloseBtn);
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
						LoggerUtil.printExtentLog("Pass", "RAPDT test successfully submitted");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Unable to submit RAPDT test, Please check");
						Status ="False";}
				return Status;}
				return Status;}
				
				
				public String RAPTestSeries(Map<String, String> testdata) throws Exception{				
					String Status = null;
					
					WebInteractUtil.Click(UnifiedPage.TestsBtn);
					if(WebInteractUtil.isPresent(UnifiedPage.registernoww, 60)) {
						
						LoggerUtil.printExtentLog("Pass", "Navigation to Tests Page is successfull");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Currently there is no any RAPTestSeries Tests, Please check");
						Status ="False";}
					
					
					WebInteractUtil.Click(UnifiedPage.registernoww);
					Thread.sleep(1000);
					WebInteractUtil.Click(UnifiedPage.attemptttnoww);
					WebInteractUtil.Click(UnifiedPage.firstqstnopt2);
					WebInteractUtil.Click(UnifiedPage.clkkSaveandNext);
					WebInteractUtil.Click(UnifiedPage.markforReviewBtnn);
					WebInteractUtil.Click(UnifiedPage.clksubmitttbtn);
					WebInteractUtil.Click(UnifiedPage.FinishTestt);
					WebInteractUtil.Click(UnifiedPage.sltMedium);
					WebInteractUtil.Click(UnifiedPage.clkkksubmitt);
					WebInteractUtil.Click(UnifiedPage.clkkclose);
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ViewSolutionBtn, 60)) {
						LoggerUtil.printExtentLog("Pass", "RAPTest Series test successfully submitted");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Unable to submit RAPTestSeries test, Please check");
						Status ="False";}
					
					return Status;
				}
					
			public String LiveClassAttemptasStudent(Map<String, String> testdata) throws Exception{				
			 String Status = null;
					
			 WebInteractUtil.Click(UnifiedPage.TestsBtn);
			 WebInteractUtil.Click(UnifiedPage.CloseBtn);
			 WebInteractUtil.Click(UnifiedPage.clsjoinnow);
			 WebInteractUtil.isPresent(UnifiedPage.Leaveclsbtn, 60);
			 LoggerUtil.printExtentLog("Pass", "Live class joined successfully");

			 WebInteractUtil.Click(UnifiedPage.Raisehandbtn);
			 WebInteractUtil.Click(UnifiedPage.Activitiesbtn);
			 WebInteractUtil.Click(UnifiedPage.StartPollbtn);
			 
			 
			 WebInteractUtil.isPresent(UnifiedPage.cricketoptn, 60);
			 WebInteractUtil.Click(UnifiedPage.cricketoptn);
			 WebInteractUtil.Click(UnifiedPage.pollsubmitbtn);
			 
			 return Status;}
			
			 public String DoubtsSignUp(Map<String, String> testdata) throws Exception{				
					String Status = null;
					WebInteractUtil.isPresent(UnifiedPage.DoubtLoginbtn,60);
					WebInteractUtil.isPresent(UnifiedPage.mobilenumber,60);
					WebInteractUtil.SendKeys(UnifiedPage.mobilenumber, "9909092345");
					WebInteractUtil.isPresent(UnifiedPage.Startteaching,60);
					WebInteractUtil.Click(UnifiedPage.Startteaching);
					WebInteractUtil.isPresent(UnifiedPage.firstname, 60);
					WebInteractUtil.SendKeys(UnifiedPage.firstname,testdata.get("FirstName"));
					WebInteractUtil.isPresent(UnifiedPage.lastname,60);
					WebInteractUtil.SendKeys(UnifiedPage.lastname, testdata.get("LastName"));
					WebInteractUtil.isPresent(UnifiedPage.DoubtGetOTP,60);
					WebInteractUtil.Click(UnifiedPage.DoubtGetOTP);
					WebInteractUtil.isPresent(UnifiedPage.SendOTP,60);
					WebInteractUtil.Click(UnifiedPage.SendOTP);
					WebInteractUtil.isPresent(UnifiedPage.VerifyOTP,60);
					WebInteractUtil.Click(UnifiedPage.VerifyOTP);
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.PasswordPage, 60)) {
						LoggerUtil.printExtentLog("Pass", "Successfully navigated to Set Password Page");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Unable to Set Password Page, Please check");
						Status ="False";}
					WebInteractUtil.isPresent(UnifiedPage.SetEmail,60);
					WebInteractUtil.SendKeys(UnifiedPage.SetEmail, testdata.get("Email"));
					WebInteractUtil.isPresent(UnifiedPage.SetPwd,60);
					WebInteractUtil.SendKeys(UnifiedPage.SetPwd, testdata.get("Passwordd"));
					WebInteractUtil.isPresent(UnifiedPage.Confirmpwd,60);
					WebInteractUtil.SendKeys(UnifiedPage.Confirmpwd, testdata.get("ConfrmPasswordd"));
					WebInteractUtil.isPresent(UnifiedPage.Savepwdd,60);
					WebInteractUtil.Click(UnifiedPage.Savepwdd);
					
					WebInteractUtil.isPresent(UnifiedPage.DoubtsltPhysicssub,60);
					WebInteractUtil.Click(UnifiedPage.DoubtsltPhysicssub);
					WebInteractUtil.isPresent(UnifiedPage.doubtNEET,60);
					WebInteractUtil.Click(UnifiedPage.doubtNEET);
					WebInteractUtil.isPresent(UnifiedPage.doubtNextbtn,60);
					WebInteractUtil.Click(UnifiedPage.doubtNextbtn);
					WebInteractUtil.isPresent(UnifiedPage.doubtsignupsltTeacher,60);
					WebInteractUtil.Click(UnifiedPage.doubtsignupsltTeacher);
					WebInteractUtil.isPresent(UnifiedPage.doubtSavebtn,60);
					WebInteractUtil.Click(UnifiedPage.doubtSavebtn);
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.SignupThnxbtn, 60)){
						LoggerUtil.printExtentLog("Pass", "Application SignUp is successfull");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Application SignUp is not successfull, Please check");
						Status ="False";}
					
					return Status;
			 }
			
			 public String DoubtsSignIn(Map<String, String> testdata) throws Exception{				
					String Status = null;
			 
					WebInteractUtil.isPresent(UnifiedPage.DoubtLoginbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.mobilenumber, testdata.get("PhoneNumber"));
					WebInteractUtil.isPresent(UnifiedPage.Startteaching,60);
					WebInteractUtil.Click(UnifiedPage.Startteaching);
					WebInteractUtil.isPresent(UnifiedPage.LoginwithPwd,60);
					WebInteractUtil.Click(UnifiedPage.LoginwithPwd);
					WebInteractUtil.isPresent(UnifiedPage.Passwdbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.Passwdbtn, testdata.get("Password"));
					WebInteractUtil.isPresent(UnifiedPage.DoubtLOgin,60);
					WebInteractUtil.Click(UnifiedPage.DoubtLOgin);
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Unassignedbtn, 60)) {
						LoggerUtil.printExtentLog("Pass", "Successfully Logged into doubts Portal");
						WebInteractUtil.Waittilljquesryupdated();
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Unable to Login to doubts Portal, Please check");
						Status ="False";}
					return Status;
			 }
			 
			 public String DoubtsForgotPassword(Map<String, String> testdata) throws Exception{				
					String Status = null;
					WebInteractUtil.isPresent(UnifiedPage.DoubtLoginbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.mobilenumber, testdata.get("PhoneNumber"));
					WebInteractUtil.isPresent(UnifiedPage.Startteaching,60);
					WebInteractUtil.Click(UnifiedPage.Startteaching);
					WebInteractUtil.isPresent(UnifiedPage.LoginwithPwd,60);
					WebInteractUtil.Click(UnifiedPage.LoginwithPwd);
					WebInteractUtil.isPresent(UnifiedPage.Forgotpwd,60);
					WebInteractUtil.Click(UnifiedPage.Forgotpwd);
					WebInteractUtil.isPresent(UnifiedPage.doubtsSendOTP,60);
					WebInteractUtil.Click(UnifiedPage.doubtsSendOTP);
					WebInteractUtil.isPresent(UnifiedPage.doubtVerifyOtpbtn,60);
					//WebInteractUtil.Click(UnifiedPage.doubtVerifyOtpbtn);
					WebInteractUtil.isPresent(UnifiedPage.NewPasswordbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.NewPasswordbtn, testdata.get("Password"));
					WebInteractUtil.isPresent(UnifiedPage.ConfirmPasswordbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.ConfirmPasswordbtn, testdata.get("Password"));
					
					
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.ResetPasswdbtn, 60)){
						WebInteractUtil.Click(UnifiedPage.ResetPasswdbtn);
						LoggerUtil.printExtentLog("Pass", "Password has been reset successfully");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Password reset not successfull, Please check");
						Status ="False";}
					WebInteractUtil.isPresent(UnifiedPage.Passwdbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.Passwdbtn, testdata.get("Password"));
					WebInteractUtil.isPresent(UnifiedPage.DoubtLOgin,60);
					WebInteractUtil.Click(UnifiedPage.DoubtLOgin);
					
					WebInteractUtil.Waittilljquesryupdated();	
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Unassignedbtn, 60)){
						LoggerUtil.printExtentLog("Pass", "Application SignIn is successfull with new password");
						LoggerUtil.printExtentLog("Pass", "Forgot password functionality is working as expected");
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Application SignIn is not successfull with new password");
						LoggerUtil.printExtentLog("Fail", "Forgot password functionality is not working as expected, Please check");
						Status ="False";}
					
					return Status;}
			 
			 public String DoubtsSigninwithOTP(Map<String, String> testdata) throws Exception{				
					String Status = null;
					WebInteractUtil.isPresent(UnifiedPage.DoubtLoginbtn,60);
					WebInteractUtil.SendKeys(UnifiedPage.mobilenumber, testdata.get("PhoneNumber"));
					WebInteractUtil.isPresent(UnifiedPage.Startteaching,60);
					WebInteractUtil.Click(UnifiedPage.Startteaching);
					WebInteractUtil.isPresent(UnifiedPage.SendOTPbtn,60);
					WebInteractUtil.Click(UnifiedPage.SendOTPbtn);
					WebInteractUtil.isPresent(UnifiedPage.doubtVerifyOtpbtn,60);
					WebInteractUtil.Click(UnifiedPage.doubtVerifyOtpbtn);
					if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.Unassignedbtn, 60)) {
						LoggerUtil.printExtentLog("Pass", "Successfully SignWithOTP into doubts Portal");
						WebInteractUtil.Waittilljquesryupdated();
						Status = "True";
					}	else {	
						LoggerUtil.printExtentLog("Fail", "Unable to SignWithOTP to doubts Portal, Please check");
						Status ="False";}
					
					return Status;
			 }
					 public String DoubtsLogout(Map<String, String> testdata) throws Exception{				
							String Status = null;
							
							WebInteractUtil.isPresent(UnifiedPage.doubtprofile,60);
							WebInteractUtil.Click(UnifiedPage.doubtprofile);
							WebInteractUtil.isPresent(UnifiedPage.Logoutdoubt,60);
							WebInteractUtil.Click(UnifiedPage.Logoutdoubt);
							
							if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.DoubtLoginbtn, 60)) {
								LoggerUtil.printExtentLog("Pass", "Successfully Logged out of application");
								Status = "True";
							}	else {	
								LoggerUtil.printExtentLog("Fail", "Unable to Logout of application, Please check");
								Status ="False";}
							
							return Status;}
					 
					 public String DoubtsTakeup(Map<String, String> testdata) throws Exception{				
							String Status = null;
							WebInteractUtil.Waittilljquesryupdated();						
							WebInteractUtil.isPresent(UnifiedPage.takeup,60);
							WebInteractUtil.Click(UnifiedPage.takeup);
							WebInteractUtil.isPresent(UnifiedPage.DoubtAcceptbtn,60);
							WebInteractUtil.Click(UnifiedPage.DoubtAcceptbtn);
							WebInteractUtil.isPresent(UnifiedPage.minutesbtn30,60);
							WebInteractUtil.Click(UnifiedPage.minutesbtn30);
							WebInteractUtil.isPresent(UnifiedPage.Accept2btn,60);
							WebInteractUtil.Click(UnifiedPage.Accept2btn);

							if(WebInteractUtil.waitForElementToBeVisible(UnifiedPage.doubtChatbtn, 60)) {
								LoggerUtil.printExtentLog("Pass", "Successfully navigated to  solution page");
								Status = "True";
							}	else {	
								LoggerUtil.printExtentLog("Fail", "Unable to navigate to solutions page, Please check");
								Status ="False";}
							
							WebInteractUtil.isPresent(UnifiedPage.doubtSolutionbtn,60);
							WebInteractUtil.isPresent(UnifiedPage.doubtsDraftbtn,60);
							WebInteractUtil.isPresent(UnifiedPage.doubtsendbtn,60);
							
							
							
							return Status;}
		
			 
  }



