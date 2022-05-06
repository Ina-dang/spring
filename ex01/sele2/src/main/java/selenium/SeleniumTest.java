package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
	private WebDriver driver;
	
	public static final String WEB_DRIIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIIVER_PATH = "D:/devtools/chromedriver_win32/chromedriver.exe";
	
	private String base_url; 
	
	public SeleniumTest(){
		System.setProperty(WEB_DRIIVER_ID, WEB_DRIIVER_PATH);
		
		driver = new ChromeDriver();
		base_url = "https://www.yogiyo.co.kr/mobile/#/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C/150041/%EC%B9%98%ED%82%A8/";
	}
	
	public void crawl() throws InterruptedException{
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(base_url);
		
		driver.findElement(By.name("address_input")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("현재 위치로 설정합니다.")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,10240)", "");
		Thread.sleep(2000);
		
		executor.executeScript("window.scrollBy(0,10240)", "");
		Thread.sleep(2000);
		
		WebElement clsContent = driver.findElement(By.id("content")).findElements(By.cssSelector(".content > div")).get(3);
		List<WebElement> infos = clsContent.findElements(By.cssSelector(".restaurant-list > div table .restaurants-info"));
		for(WebElement el : infos){
			System.out.println(el.getText());
		}
		System.out.println(infos.size());
		
//		System.out.println(driver.getPageSource());
		
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new SeleniumTest().crawl();
	}
}
