package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	private WebDriver driver;
	
	public static final String WEB_DRIIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIIVER_PATH = "D:/devtools/chromedriver_win32/chromedriver.exe";
	
	private String base_url; 
	
	public SeleniumTest(){
		System.setProperty(WEB_DRIIVER_ID, WEB_DRIIVER_PATH);
		
		driver = new ChromeDriver();
		base_url = "https://www.naver.com";
	}
	
	public void crawl(){
		driver.get(base_url);
		System.out.println(driver.getPageSource());
	}
	
	public static void main(String[] args) {
		new SeleniumTest().crawl();
	}
}
