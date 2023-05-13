package org.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.base.Baseclass;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_5  extends Baseclass{
	@Test
	private void tc1() {
		System.out.println("Test case:1");
	}
	
	private void tc2() {
		System.out.println("Test case:2");
	}
	@DataProvider(name="amazon entry")
	private Object data() {
		return new Object[][] {
			{"foot ball"},
			{"iphone"},
			{"shoes"},
		};
	}
@Test(dataProvider = "amazon entry")
private void tc3(String e) throws AWTException {
	launchurl("https://www.amazon.in/");
	windowmaximize();
	WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	Passtext(e, search);
	Robot  r= new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}
@DataProvider(name = "facebooh lgn")
private Object[][] datas() {
	return new Object[][] {
		{"rhamlakshmananna@gmail.com","12345678"},{"ravi@gmail.com","123asdf"},{"mani123@@gmail.com","abderrdjjs"}
	};
}
@Test(dataProvider = "facebooh lgn")
private void tc4(String login,String password) {
launchurl("https://en-gb.facebook.com/");
windowmaximize();
WebElement email = driver.findElement(By.name("email"));
Passtext(login, email);
WebElement pass = driver.findElement(By.id("pass"));
Passtext(password, pass);
}
@BeforeMethod
private void startDate() {
	Date d =new Date();
	System.out.println(d);
}
@AfterMethod
private void endDate() {
	Date d =new Date();
	System.out.println(d);
}
@BeforeClass
private void browser() {
	System.out.println("launch the Browser.....");
	launchBrowser();
}
@AfterClass
private void Close() {
	System.out.println("Close the Browser....");
	launchBrowser();
}
@AfterTest
private void at() {
	System.out.println("_______After case_______");
}
@BeforeTest
private void bt() {
	System.out.println("_______Before case_______");
}
}

