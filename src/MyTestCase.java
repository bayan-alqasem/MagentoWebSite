import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase extends Parameters {

	WebDriver driver = new EdgeDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	public void createAccount() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();
		
		WebElement firstName=driver.findElement(By.id("firstname"));
				WebElement lastName=driver.findElement(By.id("lastname"));
				WebElement email=driver.findElement(By.id("email_address"));
				WebElement password=driver.findElement(By.id("password"));
				WebElement confirmPassword= driver.findElement(By.id("password-confirmation"));
				WebElement createAccountButton=driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
				
				firstName.sendKeys(firstNames[randomFirstNames]);
				lastName.sendKeys(lastNames[randomLastNames]);
				password.sendKeys(commonPassword);
				confirmPassword.sendKeys(commonPassword);
				email.sendKeys(emailId);
				createAccountButton.click();
				
				String actualMessage= driver.findElement(By.className("message-success")).getText();
				System.out.println(actualMessage);
				assertEquals(actualMessage, "Thank you for registering with Main Website Store.");
	}

}

