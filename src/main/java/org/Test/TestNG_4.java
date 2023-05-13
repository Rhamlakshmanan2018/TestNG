package org.Test;

import java.util.Date;

import org.base.Baseclass;
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_4 extends Baseclass {
	@Test(priority = 1)
	private void tc1() {
		System.out.println("test case:1");
		launchurl("https://accounts.google.com/v3/signin/identifier?dsh=S302253897%3A1682489251179993&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7RPlrHCEoNbVzGZ4vJa67Yh7oQ44qyqkT4Ha4USGpQFp4jI1S4LPU5G1GCyqRkwWpJbDplI&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		windowmaximize();

	}
	@Test(priority = -1)
	private void tc2() {
		System.out.println("test case:2");
		launchurl("https://inmakes.com/");

	}
	@Test(priority = 3)
	private void tc3() {
		System.out.println("test case:3");
		launchurl("https://www.redbus.in/");
		String CurrentUrl=CurrentUrl();
		System.out.println(CurrentUrl);

	}
	@Test(priority = -4)
	private void tc4() {
		System.out.println("test case:4");
		launchurl("https://www.flipkart.com/");
		windowmaximize();

	}
	@Test(priority = -3)
	private void tc7() {
		System.out.println("test case 5");

		launchurl("https://www.amazon.in/");
		windowmaximize();
	}
	
	@Test(priority = 6)
	private void tc6() {
		System.out.println("test case:6");
		launchurl("https://www.youtube.com/");
		windowmaximize();
	}
	@Test(priority = -2)
	private void tc5() {
		System.out.println("test case:5");
		launchurl("https://www.facebook.com/");
		windowmaximize();
	}

@BeforeMethod
private void startDate() {
	Date d = new Date();
	System.out.println(d);
}

@AfterMethod
private void endDate() {
	Date d = new Date();
	System.out.println(d);
}

@BeforeClass
private void browser() {
	System.out.println("Launch The Browser....");
	launchBrowser();
}

@AfterClass
private void close() {
	System.out.println("Close The Browser....");
	
}

@BeforeTest

private void bt() {
	System.out.println("_______Before Test______");
}

@AfterTest
private void at() {
	System.out.println("_______After Test______");

}

@BeforeSuite
private void beforeSuit() {
	System.out.println(":::::Before Suite:::::");
}

@AfterSuite
private void afterSuit() {
	System.out.println(":::::After Suite:::::");

}

}
