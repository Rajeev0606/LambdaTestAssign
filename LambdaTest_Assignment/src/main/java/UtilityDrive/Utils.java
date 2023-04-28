package UtilityDrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	
	public static WebDriver driver;
	public Properties prop;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static String dateandtime;

	public WebDriver initializeDriver() throws Exception {
		prop = new Properties();
		String propPath = System.getProperty("user.dir") + "\\src\\main\\java\\configureFile\\config.properties";
		FileInputStream file = new FileInputStream(propPath);
		prop.load(file);
		String browser = prop.getProperty("browser");
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("disable-notifications");
			driver = new FirefoxDriver(options);
		}else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		

	}

	public String takeScreenshot(String testName, WebDriver driver) throws IOException {

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
		FileUtils.copyFile(srcScreenshot, new File(screenshotFilePath));
		return screenshotFilePath;
	}
	
	public static boolean waitforme(WebElement element, String id) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			test.log(Status.PASS, id+"is available");
			flag = true;
		}catch(Exception e) {
			System.out.println("Error occured while waiting for the element: " + id + "with exception" + e.getMessage());
			test.log(Status.FAIL, id+ "is not available");
		}
		return flag;
	}
	
	public void clickElement(WebElement element, String id) {
		try {
			if(waitforme(element,id)) {
				element.click();
				test.log(Status.PASS, id+ "is clicked");
			}
		}catch(Exception e) {
			System.out.println("Error in clicking the webelement: " +id+ e.getMessage());
			test.log(Status.FAIL, "Failed to click the element: " +id);
		}
	}
	public void typeText(WebElement element, String text, String id) {
		try {
			if(waitforme(element,id)) {
				element.sendKeys(text);
				test.log(Status.PASS, "typed "+text+" in the text box " +id);
			}
		}catch(Exception e) {
			System.out.println("Error in clicking the webelement: "+id+e.getMessage());
			test.log(Status.FAIL, "Failes to type text the element: " +id);
		}
		
	}
	public static void extentReportFinisher() {
		try {
			extent.flush();
		}catch(Exception e) {
			System.out.println("Error in ExtentReportFinisher: "+e.getMessage());
		}
	}
	
	public static boolean Switchclass() {
		boolean flag = false;
		
		try {
		String parentwindow = driver.getWindowHandle();

		Set<String> windowhandles = driver.getWindowHandles();

		for (String childwindow : windowhandles) {
			if (!childwindow.contentEquals(parentwindow)) {

				driver.switchTo().window(childwindow);
				break;
			}
		}
		test.log(Status.PASS, "Switched the tab Successfully");
		flag = true;
		}
		catch(Exception e) {
			System.out.println("Error in switching the tab "+ e.getMessage());
			test.log(Status.FAIL, "Error in switching the tab");
		}
		return flag;
	}
	public static String GetDateandTime() {
		DateFormat dateFormat = null;
		Date date = null;
		try {
			dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			date = new Date();
			
		}catch(Exception e) {
			System.out.println("Error  in Getdateandtime: "+e.getMessage());
		}
		
		return dateFormat.format(date);
		
	}
	


}
