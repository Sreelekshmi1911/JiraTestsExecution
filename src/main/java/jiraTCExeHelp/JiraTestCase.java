package jiraTCExeHelp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JiraTestCase {
	 private static final String N = null;


	WebDriver driver = null;
	 
	 
	 By searchbox = By.xpath("//*[@id=\"quickSearchInput\"]");
	 By Filterbox = By.xpath("//*[@id=\"raven-test-table-filters-button\"]");
	 By FilterClear = By.xpath("//*[@original-title=\"Clear\"]");
	 By Testcaseenterbox = By.xpath("//*[@id=\"searcher-text\"]");
	 By FilterApply = By.xpath("//*[@original-title=\"Apply\"]");
	 By Show = By.xpath("//*[@id=\"exec-entries-table_length\"]");
	 By Assignee = By.xpath("//*[@class=\"tinylink\"]");
	 By SelectAssignee = By.xpath("(//*[@title=\"Assign\"])[1]");
	 By Assigneename = By.xpath("//*[@id=\"raven-user-picker-field\"]");
	 By AssigneeSubmit = By.xpath("//*[@id=\"raven-confirm-dialog-form-submit\"]");
	 By checkbox = By.xpath("//*[@type=\"checkbox\"]");
	 By Threedots = By.xpath("//*[@id=\"bulkEditActionPopUp\"]");
	 By Noofitems = By.xpath("//*[@name=\"exec-entries-table_length\"]");
	 By Pass = By.xpath("//*[@id=\"raven-bulk-testexec-execute-inline-0\"]");
	 By Fail = By.xpath("//*[@title=\"The test run/iteration has failed\"]");
	 By Dropdownbutton = By.xpath("//*[@id=\"raven-user-picker-single-select\"]/span");
	 By Execute = By.xpath("//*[@title=\"Execute\"]");
	 By ExeDetails = By.xpath("//*[@title=\"Execution Details\"]");
	 By AddAttachmentIcon = By.xpath("//*[@id=\"add-attachments-link\"]");
	 By ChooseFiles = By.xpath("//*[@name=\"tempFilename\"]");
	 By AttachButton = By.xpath("//*[@name=\"Attach\"]");
	 By Status = By.xpath("(//*[@title=\"The test run/iteration has passed\"])[2]");	 
	 
	
	 public JiraTestCase(WebDriver driver) {
			this.driver = driver;
		}
	
	
	public void findTestExe() throws AWTException {
		
		JiraExcel jiex = new JiraExcel();
		driver.findElement(searchbox).sendKeys(JiraExcel.TestExecutionKey());
		
		Robot rb1 = new Robot(); 
        rb1.keyPress(KeyEvent.VK_ENTER);
        rb1.keyRelease(KeyEvent.VK_ENTER);
       
        
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("return document.readyState").equals("complete");
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	public void findTestCase() throws AWTException {
		
		int TotalnoofTC = JiraExcel.getRowNumbers2();	
		int Details = JiraExcel.getRowNumbers();
		
		
		for (int t=1;t<TotalnoofTC+1;t++) {
		
			String NotApplicable = new String("N");
			String PassTestcase = new String("P");
			String FailTestcase = new String("F");
			String Flag = JiraExcel.sheet2.getRow(t).getCell(2).getStringCellValue();
			//String Flag1 = new String(Flag);
			//System.out.println("Test case Flag is "+Flag);
			if (Flag.equals(NotApplicable)) {
				System.out.println("No need to execute");
			}
			
			else if (Flag.equals(PassTestcase)) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			JavascriptExecutor gh= (JavascriptExecutor)driver;
			WebElement filter = driver.findElement(Show);
			gh.executeScript("arguments[0].scrollIntoView(true);", filter);
			driver.findElement(Filterbox).click();		
			driver.findElement(FilterClear).click();
			String testCaseKey = JiraExcel.sheet2.getRow(t).getCell(0).getStringCellValue();
			String testCaseName = JiraExcel.sheet2.getRow(t).getCell(1).getStringCellValue();
			driver.findElement(Testcaseenterbox).sendKeys(testCaseKey);
			System.out.println("Test case name is :" + testCaseName);
			driver.findElement(FilterApply).click();	
			WebDriverWait pw = new WebDriverWait(driver, Duration.ofSeconds(20));
			pw.until(ExpectedConditions.visibilityOfElementLocated(checkbox));			
			String AssigneeName =driver.findElement(Assignee).getText(); 
			String TobeAssignee = JiraExcel.sheet1.getRow(3).getCell(1).getStringCellValue();	
//			if(AssigneeName.equals(TobeAssignee)) {
//				System.out.println("Assignee is you");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//				driver.findElement(Noofitems).click();
//				driver.findElement(Noofitems).click();	
//				driver.findElement(checkbox).click();
//				driver.findElement(Threedots).click();
//				driver.findElement(Pass).click();
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				//pw.until(ExpectedConditions.visibilityOfElementLocated(Status));
//				//System.out.println(testCaseName + "  Is Passed");
//			}
			//else {
				
				driver.findElement(Noofitems).click();
				driver.findElement(Noofitems).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					
				driver.findElement(checkbox).click();
				driver.findElement(Threedots).click();
				driver.findElement(SelectAssignee).click();
				
				driver.findElement(Dropdownbutton).click();
				driver.findElement(Assigneename).sendKeys(TobeAssignee);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Assignee assigned");
				
				Robot rb2 = new Robot(); 
		        rb2.keyPress(KeyEvent.VK_ENTER);
		        rb2.keyRelease(KeyEvent.VK_ENTER);
		        
		        
				driver.findElement(AssigneeSubmit).click();
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String NewAssignee = driver.findElement(Assignee).getText(); 
				 
				driver.findElement(Threedots).click();
				driver.findElement(Pass).click();
				
				//pw.until(ExpectedConditions.visibilityOfElementLocated(Status));
				//System.out.println(testCaseName + "  Is Passed");
			//}
		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		driver.findElement(Execute).click();
		driver.findElement(ExeDetails).click();
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(20));
		ww.until(ExpectedConditions.visibilityOfElementLocated(AddAttachmentIcon));
		driver.findElement(AddAttachmentIcon).click();
		String AttachmentLocation = JiraExcel.sheet1.getRow(4).getCell(1).getStringCellValue();
		String DocumentName = JiraExcel.sheet2.getRow(t).getCell(3).getStringCellValue();
		String Attachment = AttachmentLocation+DocumentName;
		driver.findElement(ChooseFiles).sendKeys(Attachment);
		System.out.println("Attachment done");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(AttachButton).click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
		gh.executeScript("return document.readyState").equals("complete");

		}
			else {
				JavascriptExecutor gh= (JavascriptExecutor)driver;
				WebElement filter = driver.findElement(Show);
				
				gh.executeScript("arguments[0].scrollIntoView(true);", filter);
			
				driver.findElement(Filterbox).click();		
				driver.findElement(FilterClear).click();
				
			    String testCaseKey = JiraExcel.sheet2.getRow(t).getCell(0).getStringCellValue();
			    String testCaseName = JiraExcel.sheet2.getRow(t).getCell(1).getStringCellValue();
				driver.findElement(Testcaseenterbox).sendKeys(testCaseKey);
				System.out.println("Test case name is :" + testCaseName);
				driver.findElement(FilterApply).click();	
				WebDriverWait fw = new WebDriverWait(driver, Duration.ofSeconds(20));
				fw.until(ExpectedConditions.visibilityOfElementLocated(checkbox));
			
				
				String AssigneeName =driver.findElement(Assignee).getText(); 
				String TobeAssignee = JiraExcel.sheet1.getRow(3).getCell(1).getStringCellValue();
				
				if(AssigneeName.equals(TobeAssignee)) {
					
					System.out.println("Assignee is you");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					driver.findElement(Noofitems).click();
					driver.findElement(Noofitems).click();
					driver.findElement(checkbox).click();
					driver.findElement(Threedots).click();
					driver.findElement(Fail).click();
					fw.until(ExpectedConditions.visibilityOfElementLocated(Status));
					System.out.println(testCaseName + " is Failed");
			}
				else {
					
					driver.findElement(Noofitems).click();
					driver.findElement(Noofitems).click();
						
					driver.findElement(checkbox).click();
					driver.findElement(Threedots).click();
					driver.findElement(SelectAssignee).click();
					
					driver.findElement(Dropdownbutton).click();
					driver.findElement(Assigneename).sendKeys(TobeAssignee);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Assignee assigned");
					
					Robot rb2 = new Robot(); 
			        rb2.keyPress(KeyEvent.VK_ENTER);
			        rb2.keyRelease(KeyEvent.VK_ENTER);
			        
			        
					driver.findElement(AssigneeSubmit).click();
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String NewAssignee = driver.findElement(Assignee).getText(); 
					 
					driver.findElement(Threedots).click();
					driver.findElement(Fail).click();
					fw.until(ExpectedConditions.visibilityOfElementLocated(Status));
					
					System.out.println(testCaseName + " is Failed");
					}
					
					driver.findElement(Noofitems).click();
					driver.findElement(Noofitems).click();
					driver.findElement(Threedots).click();
					driver.findElement(Fail).click();
					fw.until(ExpectedConditions.visibilityOfElementLocated(Status));
					System.out.println(testCaseName + " is Failed");
				}	
		}	
	}	
	}


	
//	public static void attach()
// {
//		int TotalnoofTC = JiraExcel.getRowNumbers2();	
//		int Details = JiraExcel.getRowNumbers();
//		for (int t=1;t<TotalnoofTC+1;t++) {
//			String NotApplicable = new String("N");
//			String PassTestcase = new String("P");
//			String FailTestcase = new String("F");
//			String Flag = JiraExcel.sheet2.getRow(t).getCell(2).getStringCellValue();
//			//String Flag1 = new String(Flag);
//			System.out.println("Test case Flag is "+Flag);
//			if (Flag.equals(NotApplicable)) {
//				System.out.println("No need to execute");
//			}
//			else {
//				System.out.println("Execute");
//			}			
//	}
//	}
//	



