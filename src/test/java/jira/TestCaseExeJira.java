package jira;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jiraTCExeHelp.JiraExcel;
import jiraTCExeHelp.JiraTestCase;


public class TestCaseExeJira {
	static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeTest
	public void jiraInitialSetup() throws AWTException, InterruptedException  {
		extent = new ExtentReports("C:\\Users\\sreelekshmi.r\\eclipse-workspace\\JiraTestCaseExecution\\JiraExeDocuments\\ResultRecords");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreelekshmi.r\\eclipse-workspace\\Resources\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sreelekshmi.r\\eclipse-workspace\\Resources\\edgedriver_win64\\msedgedriver.exe");
		//driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//Navigate to Jira URL
		driver.get("https://jira.uk.ngridtools.com/secure/RapidBoard.jspa?rapidView=21920&selectedIssue=ITCTEAM-3374");
		 
		
		//Get the number of test cases to be executed
		JiraExcel jel = new JiraExcel();
		int values = jel.getRowNumbers();
		int NoofTestcases = jel.getRowNumbers2();
		
		
		//Manage the Microsoft Authentication
		   Robot rb = new Robot();
		   rb.delay(2000);
	        // Enter user name by ctrl-v
	        StringSelection username = new StringSelection(jel.UsernameMS());
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
	        rb.keyPress(KeyEvent.VK_CONTROL);
	        rb.keyPress(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_CONTROL);
	        rb.delay(2000);
	        
	        
	        rb.keyPress(KeyEvent.VK_ENTER);
	        rb.keyRelease(KeyEvent.VK_ENTER);
	        
	        
	        // tab to password entry field
	        rb.keyPress(KeyEvent.VK_TAB);
	        rb.keyRelease(KeyEvent.VK_TAB);
	        Thread.sleep(2000);
	        
	        // Enter password by ctrl-v
	        StringSelection pwd = new StringSelection(jel.PasswordMS());
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
	        rb.keyPress(KeyEvent.VK_CONTROL);
	        rb.keyPress(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_V);
	        rb.keyRelease(KeyEvent.VK_CONTROL);

	       // press enter
	        rb.keyPress(KeyEvent.VK_ENTER);
	        rb.keyRelease(KeyEvent.VK_ENTER); 
	        
		WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(60));
		webdwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title=\"Kanban board\"]")));
		
}
	
	@Test
	public void jiraTCExecution() throws AWTException {
		JiraExcel jie = new JiraExcel();
		int NoofTestcases = jie.getRowNumbers2();
		System.out.println("Number of Test cases to be Passed in Jira : "+ NoofTestcases );
		
		JiraTestCase TCE = new JiraTestCase(driver);
		
		//Find the Test Execution
		TCE.findTestExe();
		
		//Find the Test Case
		TCE.findTestCase();
		
	}
	
	@AfterTest
    public void teardown() {
		driver.quit();
		
}
}

