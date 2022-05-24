package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest(){
	private final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private final String WEB_DRIVER_PATH = "D:\\devtools\\chromedriver\\chromedriver.exe";
	private String url = "http://localhost:9090/index";
	private WebDriver driver;
	
	
	public SeleniumTest_lnh(){
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		driver = new ChromeDriver();
	}
	
	public void crawl(){
		driver.get(url);
		System.out.println(driver.getPageSource());
	}
	
	public static void main(String[] args) {
		new SeleniumTest().crawl();
	}
}
