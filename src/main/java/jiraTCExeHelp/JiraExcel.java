package jiraTCExeHelp;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JiraExcel {
	
	File jira = new File("C:\\Users\\sreelekshmi.r\\eclipse-workspace\\JiraTestCaseExecution\\JiraExeDocuments\\JiraTestcaseRecord\\TestJira.xlsx");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet1 ;
	static XSSFSheet sheet2;
	
	public static int getRowNumbers() {
		int Count = 0;
		try {
			workbook = new XSSFWorkbook("C:\\Users\\sreelekshmi.r\\eclipse-workspace\\JiraTestCaseExecution\\JiraExeDocuments\\JiraTestcaseRecord\\TestJira.xlsx");
			sheet1 = workbook.getSheetAt(0);
			int rowCount = sheet1.getLastRowNum();
			Count = rowCount;
		}
			catch(Exception exp) {
				System.out.println(exp.getMessage());;
				System.out.println(exp.getCause());;
				exp.printStackTrace();
			}
			return Count;	
		}
	public static int getRowNumbers2() {
		int Count2 = 0;
		try {
			workbook = new XSSFWorkbook("C:\\Users\\sreelekshmi.r\\eclipse-workspace\\JiraTestCaseExecution\\JiraExeDocuments\\JiraTestcaseRecord\\TestJira.xlsx");
			sheet2 = workbook.getSheetAt(1);
			int rowCount2 = sheet2.getLastRowNum();
			Count2 = rowCount2;
		}
			catch(Exception exp) {
				System.out.println(exp.getMessage());;
				System.out.println(exp.getCause());;
				exp.printStackTrace();
			}
			return Count2;	
		}
	
	public static XSSFSheet getSheet1() {
		return sheet1;
	}
	
	public static XSSFSheet getSheet2() {
		return sheet2;
	}
	
	public static String UsernameMS() {
		String MSUsername = sheet1.getRow(0).getCell(1).getStringCellValue();
		return MSUsername;
	}
	public static String PasswordMS() {
		String MSPassword = sheet1.getRow(1).getCell(1).getStringCellValue();
		return MSPassword;
	}
	
	public static String TestExecutionKey() {
		String testexeKey = sheet1.getRow(2).getCell(1).getStringCellValue();
		return testexeKey;
	}
	public static String TestExecutioName() {
		String testexeName = sheet1.getRow(2).getCell(2).getStringCellValue();
		return testexeName;
	}
}


