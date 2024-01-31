import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase extends Parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
//
//	@Test(priority = 1)
//	public void createAccount() {
//		driver.get("https://magento.softwaretestingboard.com/");
//		driver.findElement(By.linkText("Create an Account")).click();
//
//		WebElement firstName = driver.findElement(By.id("firstname"));
//		WebElement lastName = driver.findElement(By.id("lastname"));
//		WebElement email = driver.findElement(By.id("email_address"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
//		WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
//
//		firstName.sendKeys(firstNames[randomFirstNames]);
//		lastName.sendKeys(lastNames[randomLastNames]);
//		password.sendKeys(commonPassword);
//		confirmPassword.sendKeys(commonPassword);
//		email.sendKeys(emailId);
//		createAccountButton.click();
//
//		String actualMessage = driver.findElement(By.className("message-success")).getText();
//		System.out.println(actualMessage);
//		assertEquals(actualMessage, "Thank you for registering with Main Website Store.");
//	}
//
//	@Test(priority = 2)
//	public void logOut() throws InterruptedException {
//		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/\"");
//		Thread.sleep(3000);
//		boolean actualMessage = driver.getCurrentUrl().contains("logoutSuccess");
//		assertEquals(actualMessage, true);
//	}
//
//	@Test(priority = 3)
//	public void logIn() throws InterruptedException {
//		driver.get(
//				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/\"");
////		driver.findElement(By.linkText("Sign In")).click();
//		WebElement email = driver.findElement(By.id("email"));
//		WebElement password = driver.findElement(By.id("pass"));
//		WebElement signInButton = driver.findElement(By.id("send2"));
//		email.sendKeys(emailId);
//		password.sendKeys(commonPassword);
//		signInButton.click();
//		Thread.sleep(2000);
//
//		boolean actual = driver.findElement(By.cssSelector(".greet.welcome")).getText().contains("Welcome,");
//		System.out.println("this is actual" + driver.findElement(By.cssSelector(".greet.welcome")).getText());
//		assertEquals(actual, true);
//	}
//
//	@Test(priority = 4)
//	public void footerItems() throws InterruptedException {
//		WebElement footer = driver.findElement(By.cssSelector(".footer.content"));
//		int countOfTagA = footer.findElements(By.tagName("a")).size();
//		System.out.println(countOfTagA);
//
//	}

	@Test(priority = 1)
	public void addRandoomIteam() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement bodyContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));

		int itemsInTheBody = bodyContainer.findElements(By.tagName("li")).size();
		System.out.println(itemsInTheBody);
		int randomIteam = rand.nextInt(4);
		bodyContainer.findElements(By.tagName("li")).get(randomIteam).click();

		WebElement sizeContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int itemsInSizeContainer = sizeContainer.findElements(By.cssSelector(".swatch-option.text")).size();
		System.out.println("the number of iteams in size container " + itemsInSizeContainer);
		int randomSizeIteam = rand.nextInt(5);
		sizeContainer.findElements(By.cssSelector(".swatch-option.text")).get(randomSizeIteam).click();

		WebElement colorContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int itemsInColorContainer = colorContainer.findElements(By.cssSelector(".swatch-option.color")).size();
		System.out.println(itemsInColorContainer);
		int randomColor = rand.nextInt(itemsInColorContainer);
		colorContainer.findElements(By.cssSelector(".swatch-option.color")).get(randomColor).click();

		WebElement addToCardButton = driver.findElement(By.id("product-addtocart-button"));
		addToCardButton.click();

		Thread.sleep(2000);
		String actual = driver.findElement(By.cssSelector(".message-success.success.message")).getText();
		System.out.println(actual);
		assertEquals(actual.contains("You added"), true);

	}

}
