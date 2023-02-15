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

public class UnifiedTests extends DriverManager {
	protected static String className;
	protected static HashMap<Integer, HashMap<String, String>> testData;
	protected UnifiedLibrary UnifiedLibrary;
	private ThreadLocal<String> testName = new ThreadLocal<>();
	static ExtentTest test;
	static ExtentReports report;

	@BeforeMethod
	public void methodsetup() throws Exception {
		UnifiedLibrary = new UnifiedLibrary();
	}

	@DataProvider(name = "getData", parallel = false)
	public Iterator<Object[]> getTestData() throws IOException {
		className = this.getClass().getSimpleName();
		testData = ExcelUtil.getTestData(className);
		ArrayList<Object[]> dataProvider = new ArrayList<Object[]>();
		for (Integer currentKey : testData.keySet()) {
			dataProvider.add(new Object[] { testData.get(currentKey) });
		}
		return dataProvider.iterator();
	}

//		Test Cases

	@Test( priority=0,dataProvider = "getData",enabled=false)
	public void SignUP(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("SignUp Verification", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignUp(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	}	
	@Test( priority=0,dataProvider = "getData",enabled=false)
	public void SignUP2(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("SignUp with Existing User", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignUp2(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	  }	
	
	@Test( priority=0,dataProvider = "getData",enabled=false)
	public void SignUP3(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("SignUp with Incorrect OTP", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignUp3(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	  }	
	
	@Test( priority=0,dataProvider = "getData",enabled=false)
	public void SignUP4(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("SignUp with Incorrect OTP Edit Button", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignUp4(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	  }	


	@Test(priority = 1, dataProvider = "getData")
	public void UnifiedOtp(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified SignIn with valid OTP", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedLoginWithOtp(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	}
	@Test(priority = 2, dataProvider = "getData")
	public void UnifiedOtp2(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified SignIn with Incorrect OTP", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedLoginWithOtp2(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	   }
	
	@Test(priority = 3, dataProvider = "getData")
	public void UnifiedOtp3(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Edit OTP", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedLoginWithOtp3(testdata);
		if (sResult.equalsIgnoreCase("False")) {TearDown();}
	   }

	@Test(priority = 4, dataProvider = "getData")
	public void UnifiedForgotPass(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Forgot Password", "");
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedForgotPassword(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}

		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
	}

	@Test(priority = 5, dataProvider = "getData")
	public void UnifiedForgotPass2(HashMap<String, String> testdata) throws Exception
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Forgot Password Verify with Incorrect OTP", "");
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedForgotPassword2(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	  }
	
	@Test(priority = 6, dataProvider = "getData")
	public void UnifiedForgotPass3(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Forgot Password Edit ", "");
		UnifiedLibrary.WebBrowser(testdata);
		
		sResult = UnifiedLibrary.UnifiedForgotPassword3(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}

	}
	@Test(priority = 7, dataProvider = "getData")
	public void SignWithPassword(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Login with Valid PhoneNumber and Password", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
	}
	
	@Test(priority = 8, dataProvider = "getData")
	public void SignInwithPassword2(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Login with Invalid Phonenumber", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignInwithInValidUn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
		}
	
	@Test(priority = 9, dataProvider = "getData")
	public void SignInwithPassword3(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Unified Login with Invalid Phonenumber and Password", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignInwithInValidUnandPwd(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	}

	@Test(priority = 10, dataProvider = "getData",enabled=false)
	public void PYPTests(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("PYP Test Verification", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.Select11Grade(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.PYPTests(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		sResult = UnifiedLibrary.PYPReports(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
	}

	@Test(priority = 11, dataProvider = "getData")
	public void MCTTests(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("MCT Test Verification", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		
		sResult = UnifiedLibrary.MCTTests(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
	}

	@Test(priority = 11, dataProvider = "getData",enabled=false)
	public void MCTTestWithIntegerQstn(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("MCT Test with Integer Type Question", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		
		sResult = UnifiedLibrary.MCTTestsAttemptingIntegerQuestion(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
	}
	@Test(enabled = false, dataProvider = "getData")
	public void HomePage(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Home Page Verfication", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

//		sResult = UnifiedLibrary.SetGoal(testdata);
//		if (sResult.equalsIgnoreCase("False")) {
//			TearDown();
//		}
		
	}

	@Test(priority = 12, dataProvider = "getData")
	public void FreeMasterClass(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Free MasterClass Verfication", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		
		sResult = UnifiedLibrary.FreeMasterClass(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
	
	}
       //Praveen changes
	@Test(priority=13, dataProvider = "getData")
	public void CYOT(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("CYOT Test Verification", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}

		sResult = UnifiedLibrary.CYOT(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
	}
	
	
	   
		
	
	@Test(priority=14, dataProvider = "getData")
	public void Learn(HashMap<String, String> testdata) throws Exception // @Test(enabled=false)
	{
		String sResult = null;
		ExtentTestManager.startTest("Self Learn verification", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}

		sResult = UnifiedLibrary.Learn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
	}
	
	@Test(priority=15, dataProvider = "getData",enabled =false)
	public void ILTSTest(HashMap<String, String> testdata) throws Exception 
	{
		String sResult = null;
		ExtentTestManager.startTest("ILTS Test verification", "");
		UnifiedLibrary.WebBrowser(testdata);

		sResult = UnifiedLibrary.UnifiedSignIn(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
		sResult = UnifiedLibrary.Select11Grade(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
		sResult = UnifiedLibrary.ILTSTest(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();}
		
	}	

		@Test(priority=16,enabled=false, dataProvider = "getData")
		public void RAPDailyTest(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("RAPDT Test verification", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();
			}

		sResult = UnifiedLibrary.RAPDailyTest(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}}
		
		@Test(priority=17,enabled=false, dataProvider = "getData")
		public void RAPTestSeries(HashMap<String, String> testdata) throws Exception 
		{
			String sResult = null;
			ExtentTestManager.startTest("RAPDT Test verification", "");
			UnifiedLibrary.WebBrowser(testdata);

			sResult = UnifiedLibrary.UnifiedSignIn(testdata);
			if (sResult.equalsIgnoreCase("False")) {
				TearDown();
			}

		sResult = UnifiedLibrary.RAPTestSeries(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}
		sResult = UnifiedLibrary.UnifiedLogOut(testdata);
		if (sResult.equalsIgnoreCase("False")) {
			TearDown();
		}}
		
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
		ExtentTestManager.endTest();
	}
}
