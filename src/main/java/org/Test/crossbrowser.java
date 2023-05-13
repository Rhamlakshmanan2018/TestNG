package org.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class crossbrowser {
	@Parameters("browser")
	@Test
	private void tc1(String browsername) {
		WebDriver driver;
		if(browsername.equalsIgnoreCase("Chromebrowser")) {
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
	}
		else if(browsername.equalsIgnoreCase("Firefoxbrowser")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
	}
		else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	}
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		}
			
	
	}

