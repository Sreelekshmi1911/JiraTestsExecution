package jiraTCExeHelp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JiraBrowserHelper {
	public static WebDriver openBrowser() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreelekshmi.r\\eclipse-workspace\\Resources\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
}
}