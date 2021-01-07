package failcases;



import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@TestMethodOrder(OrderAnnotation.class)
public class TestCasesFail {
	static WebDriver driver;
	static String URL = "http://localhost:8443/StudentRegistration/";
	
	@BeforeAll
	public static void initDriver(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test
	@Order(1)
	//if first name is not given
	public void verifyNotSubmitFormIfFirstNameNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.id("firstname"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(2)
	//if last name is not given
	public void verifyNotSubmitFormIfLastNameNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.id("lastname"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(3)
	//if personal identification code is not given
	public void verifyNotSubmitFormIfPersonalCodeNotGiven(){
		 boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.id("personalcode"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(4)
	//if gender is not provided is not given
	public void verifyNotSubmitFormIfGenderNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.name("gender"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(5)
	//if address is not provided is not given
	public void verifyNotSubmitFormIfAddressNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.id("address"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(6)
	//if phone number is not provided is not given
	public void verifyNotSubmitFormIfPhoneNumberNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.id("phonenumber"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(7)
	//if program is not provided is not given
	public void verifyNotSubmitFormIfStudyProgramNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.id("studyprogram"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(8)
	//if form of study is not provided is not given
	public void verifyNotSubmitFormIfFormOfStudyNotGiven(){
		boolean isRequired = false;
		 WebElement inputElement = driver.findElement(By.name("formofstudy"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(9)
	//if invalid phone number is given is not provided is not given
	public void verifyInvalidPhoneNumberGiven(){
		boolean isRequired = false;
		driver.findElement(By.id("phonenumber")).sendKeys("33134413321");
		 WebElement inputElement = driver.findElement(By.name("formofstudy"));
		 String validationMessage = inputElement.getAttribute("validationMessage");
		 if(validationMessage != null && !validationMessage.isEmpty()){
			 isRequired= true;
		 }
		 assertEquals(true, isRequired);
	}
	
	@Test
	@Order(10)
	//if invalid personal identification code is not provided is not given
	public void verifyInvalidPersonalIdentificationNumberGiven(){
		 String expectedResposnse = "ERROR";
		 driver.findElement(By.id("firstname")).sendKeys("Messi");
		 driver.findElement(By.id("lastname")).sendKeys("Football");
		 driver.findElement(By.id("personalcode")).sendKeys("387031817");
		 driver.findElement(By.id("male")).click();
		 driver.findElement(By.id("address")).sendKeys("My Comp Address");
		 driver.findElement(By.id("phonenumber")).sendKeys("+37069795721");
		 new Select(driver.findElement(By.id("studyprogram"))).selectByIndex(1);
		 driver.findElement(By.id("online")).click();
		 driver.findElement(By.id("submit")).submit();
		 String actualValue =driver.findElement(By.id("response")).getText();
		 assertEquals(expectedResposnse,actualValue);
	}
	
	@Test
	@Order(11)
	//if student is already registered
	public void verifyStudentAreadyRegistration(){
	
		driver.get(URL);
		 String expectedResposnse = "STUDENT REGISTERED ALREADY";
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
		
		 driver.get(URL);
		 driver.findElement(By.id("firstname")).sendKeys("Messi");
		 driver.findElement(By.id("lastname")).sendKeys("Football");
		 driver.findElement(By.id("personalcode")).sendKeys("38703181745");
		 driver.findElement(By.id("male")).click();
		 driver.findElement(By.id("address")).sendKeys("My Comp Address");
		 driver.findElement(By.id("phonenumber")).sendKeys("+37069795721");
		 new Select(driver.findElement(By.id("studyprogram"))).selectByIndex(1);
		 driver.findElement(By.id("online")).click();
		 driver.findElement(By.id("submit")).submit();
		 actualValue =driver.findElement(By.id("response")).getText();
		 assertEquals(expectedResposnse,actualValue);
	}
	
	@AfterAll
	public static void endDriver(){
		driver.quit();
	}
	

}
