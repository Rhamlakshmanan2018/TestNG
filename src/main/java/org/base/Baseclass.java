package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.constant.Constable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void windowmaximize() {
		driver.manage().window().maximize();
	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static String Pagetitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String Pageurl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public static String CurrentUrl() {
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	
	}
	public static void Passtext(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowse() {
		driver.quit();
	}

	public static void closebtn(WebElement ele) {
		ele.click();
	}

	public static void Screenshot(String imgNmae) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgName.png");
		FileUtils.copyFile(image, f);
	}

	public static Actions a;

	public static void movethecursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}

	public static void dragdrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement);
		{

			a = new Actions(driver);
			a.dragAndDrop(dragWebElement, dropElement).perform();
		}
	}

	public static JavascriptExecutor js;

	public static void scrolThePage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);
	}

	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview(false)", element);
	}

	public static void existingData(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("Data");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int CellType = c.getCellType();

		String Value = " ";
		if (CellType == 1) {
			String value2 = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {

			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(Value);
			String value = s.format(dd);
		}

		else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}
	}

	public static void CreateNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\Rhamlakshmanan\\eclipse-workspace\\Base\\Excel\\sam.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newsheet = w.createSheet("Datas");
		Row newrow = newsheet.createRow(rowNum);
		Cell newcell = newrow.createCell(cellNum);
		newcell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public static void CreateCell(int getRow, int CreCell, String newdata) throws IOException {
		File f = new File("C:\\Users\\Rhamlakshmanan\\eclipse-workspace\\Base\\Excel\\sam.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(CreCell);
		c.setCellValue(newdata);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\Rhamlakshmanan\\eclipse-workspace\\Base\\Excel\\sam.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updateDataToParticularCell(int gettheRow, int gettheCell, String existingData,
			String WriteNewData) throws IOException {
		File f = new File("C:\\Users\\Rhamlakshmanan\\eclipse-workspace\\Base\\Excel\\sam.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(gettheRow);
		Cell c = r.getCell(gettheCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(WriteNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
}
