package com.unified.infinity.uitest.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.unified.reporting.ExtentManager;
import com.qa.unified.reporting.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.unified.infinity.libraries.UnifiedLibrary;
import com.unified.infinity.utils.DriverManager;
import com.unified.infinity.utils.ExcelUtil;

public class UAMSanity extends DriverManager {
		protected static String className;
		protected static HashMap<Integer, HashMap<String, String>> testData;
		protected UnifiedLibrary UnifiedLibrary;
		private ThreadLocal<String> testName = new ThreadLocal<>();
		static ExtentTest test;
		static ExtentReports report;

		
		@BeforeMethod
		public void methodsetup() throws Exception{
		UnifiedLibrary = new UnifiedLibrary();
		}
		@DataProvider(name = "getData", parallel = false)
		public Iterator<Object[]> getTestData() throws IOException {
			className = this.getClass().getSimpleName();
			testData = ExcelUtil.getTestData(className);	
			ArrayList <Object[]> dataProvider = new ArrayList<Object[]>();
			for (Integer currentKey : testData.keySet()) {
				dataProvider.add(new Object[] { testData.get(currentKey)});		
			}
			return dataProvider.iterator();}
		
		@Test(priority = 0, dataProvider = "getData")
		public void UnifiedForgotPass(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("Forgot Password functionality", "");
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.UnifiedForgotPassword(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}

			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}				
			}
		//Login with password and Logout functionality
		@Test(priority=1,dataProvider = "getData")
		public void SignInWithPassword(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
		{			
			String sResult = null;
			ExtentTestManager.startTest("Signin with password and Logout functionality","");		
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		}
		
		
		@Test(priority=3,dataProvider = "getData")
		public void ChangePassword(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
		{			
			String sResult = null;
			ExtentTestManager.startTest("Change Password functionality","");		
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.ChangePassword(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		}
		
		@Test(priority=4,dataProvider = "getData")
		public void ChangePasswordWithOTP(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
		{			
			String sResult = null;
			ExtentTestManager.startTest("Change Password with OTP","");		
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.ChangePasswordwithOTP(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		}
		
		@Test(priority=5,dataProvider = "getData")
		public void Profile(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
		{			
			String sResult = null;
			ExtentTestManager.startTest("All Available Grades, Streams and Boards Verification","");		
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.VerifyGrades(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.VerifyStream(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		
			sResult = UnifiedLibrary.VerifyBoard(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }	
			
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
		}
		

		@Test(priority=6,dataProvider = "getData")
		public void PersonalProfileUpdate(HashMap<String, String> testdata) throws Exception			//@Test(enabled=false)
		{			
			String sResult = null;
			ExtentTestManager.startTest("Update User Profile","");		
			UnifiedLibrary.WebBrowser(testdata);
			
			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.ProfileUpdate(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }
			
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown(); }	
		}
	
		@Test( priority=7,dataProvider = "getData")
		public void VerifyPhone(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("Verify phone number New/Existing user", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignUp2(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}				
		  }
		@Test( priority=8,dataProvider = "getData")
		public void UnifiedOtp(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("SignIn with OTP", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedLoginWithOtp(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}
				
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}			
			}
	
		@Test( priority=9,dataProvider = "getData", enabled=false)
		public void SignUP(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
		{
			String sResult = null;
			ExtentTestManager.startTest("SignUp Verification", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignUp(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}
				
			sResult = UnifiedLibrary.UnifiedLogOut(testdata);
			if (sResult.equalsIgnoreCase("False")) {TearDown();}			
			}
				
		private void TearDown() throws Exception {
			throw new Exception("Test can't continue,  fail here!");
		}
		@AfterMethod
		public static void EndMethod() {
			ExtentManager.getReporter().flush();
			ExtentTestManager.endTest();
		}
		@AfterSuite
		public static void endSuite() {
			ExtentManager.getReporter().flush();
			ExtentTestManager.endTest();}
}
