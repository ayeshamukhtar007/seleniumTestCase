import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class devops{
	public static void main(String[] args) {
		
		testSuccessfulLogin();
		testSuccessfulSignup();
		testIncorrectLogin();
		testEmptyFieldsLogin();
		testExistingEmailSignup();
	}
	
	public static void testSuccessfulLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		  // Navigate to the login page
		  driver.get("https://app.dealmachine.com/login");

		  // Enter a valid username and password
		  driver.findElement(By.name("email")).sendKeys("umerhayat176@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("umer12345");

		  // Click the login button
		  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

		  // Verify that the user is redirected to the home screen
		  String currentUrl = driver.getCurrentUrl();
		  assertEquals("https://app.dealmachine.com/home", currentUrl);
		}
	
	@Test
	public static void testSuccessfulSignup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the signup page
	  driver.get("https://app.dealmachine.com/signup");

	  // Enter a unique email and valid password
	  driver.findElement(By.name("email")).sendKeys("testuser@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("testpass");

	  // Click the signup button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that the user is redirected to the home screen
	  String currentUrl = driver.getCurrentUrl();
	  assertEquals("https://app.dealmachine.com/home", currentUrl);
	}
	
	@Test
	public static void testIncorrectLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the login page
	  driver.get("https://app.dealmachine.com/login");

	  // Enter a valid username and incorrect password
	  driver.findElement(By.name("email")).sendKeys("testuser");
	  driver.findElement(By.name("password")).sendKeys("incorrectpass");

	  // Click the login button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that an error message is displayed
	  WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
	  assertTrue(errorMessage.isDisplayed());
	  assertEquals("Incorrect password", errorMessage.getText());
	}
	
	@Test
	public static void testEmptyFieldsLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the login page
	  driver.get("https://app.dealmachine.com/login");

	  // Leave the username and password fields empty
	  driver.findElement(By.name("email")).sendKeys("");
	  driver.findElement(By.name("password")).sendKeys("");

	  // Click the login button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that an error message is displayed
	  WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
	  assertTrue(errorMessage.isDisplayed());
	  assertEquals("email and password cannot be empty", errorMessage.getText());
	}
	
	@Test
	public static void testExistingEmailSignup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the signup page
	  driver.get("https://app.dealmachine.com/signup");

	  // Enter an email that is already in use
	  driver.findElement(By.id("email")).sendKeys("testuser@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("testpass");

	  // Click the signup button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that an error message is displayed
	  WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
	  assertTrue(errorMessage.isDisplayed());
	  assertEquals("Email already in use", errorMessage.getText());
	}
	
}