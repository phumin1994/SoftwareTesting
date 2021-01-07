package successcases;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(OrderAnnotation.class)
public class TestCasesSuccess {

	static WebDriver driver;
	
	@BeforeAll
	public static void initDriver(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8443/StudentRegistration/");
	}
	
	@Test
	@Order(1)
	public void verifySuccessfulRegistration(){
		 String expectedResposnse = "STUDENT REGISTERED SUCCESSFULLY";
		 driver.findElement(By.id("firstname")).sendKeys("Messi");
		 driver.findElement(By.id("lastname")).sendKeys("Football");
		 driver.findElement(By.id("personalcode")).sendKeys("38703181745");
		 driver.findElement(By.id("male")).click();
		 driver.findElement(By.id("address")).sendKeys("My Comp Address");
		 driver.findElement(By.id("phonenumber")).sendKeys("+37069795721");
		 new Select(driver.findElement(By.id("studyprogram"))).selectByIndex(1);
		 driver.findElement(By.id("online")).click();
		 driver.findElement(By.id("submit")).submit();
		 String actualValue =driver.findElement(By.id("response")).getText();
		 assertEquals(expectedResposnse,actualValue);
	}
	
	@AfterAll
	public static void endDriver(){
		driver.quit();
	}
	
}
