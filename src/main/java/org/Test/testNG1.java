package org.Test;
import java.util.Date;

import org.base.Baseclass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class testNG1 extends Baseclass {
	@Test(invocationCount = 3)
	private void tc1() {
		launchurl("https://www.facebook.com/");
		fblogin f = new fblogin();
		Passtext("rhamlakshmananmail.com",f.getEmail());
		Passtext("lakshman",f.getPassword());
	
	}
	@Test(enabled = false)
	private void tc2() {
		launchurl("https://www.flipkart.com/");
	}
	@Test
	private void tc3() {
		launchurl("https://www.amazon.com/");

	}
	@BeforeMethod
	private void tc11() {
		Date d = new Date();
		System.out.println("d");
	}
	@AfterMethod
	private void tc22() {
	Date d = new Date();
	System.out.println(d);
	}
	@BeforeClass
	private void lanunchtheBrowser() {
		lanunchtheBrowser();
		windowmaximize();
	}
	@AfterClass
   private void closetheBrowser() {
	System.out.println("EndBroeser");

}
	
}
