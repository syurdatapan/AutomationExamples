package testcases;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	@Test
	public void RegisterUser() {

		// 1. Launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// 2. Navigate to url 'http://automationexercise.com'
		driver.get("https://automationexercise.com");

		// 3. Verify that home page is visible successfully
		WebElement logoSrc = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
		Assert.assertTrue(logoSrc.isDisplayed());

		// 4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

		// 5. Verify 'New User Signup!' is visible
		WebElement userSignupElement = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		Assert.assertTrue(userSignupElement.isDisplayed());

		// 6. Enter name and email address
		WebElement signupName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
		WebElement signupEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		signupName.sendKeys("John");
		signupEmail.sendKeys("john123@tesmail.com");

		// 7. Click 'Signup' button
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

		// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		WebElement enterAccountElement = driver
				.findElement(By.xpath("//*[contains(text(),'Enter Account Information')]"));
		Assert.assertTrue(enterAccountElement.isDisplayed());

		// 9. Fill details: Title, Name, Email, Password, Date of birth
		driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("12345");

		WebElement selectDayElement = driver.findElement(By.xpath("//select[@data-qa='days']"));
		Select selectDay = new Select(selectDayElement);
		selectDay.selectByValue("13");

		WebElement selectMonthElement = driver.findElement(By.xpath("//select[@data-qa='months']"));
		Select selectMonth = new Select(selectMonthElement);
		selectMonth.selectByVisibleText("January");

		WebElement selectYearElement = driver.findElement(By.xpath("//select[@data-qa='years']"));
		Select selectYear = new Select(selectYearElement);
		selectYear.selectByVisibleText("1984");

		// 10. Select checkbox 'Sign up for our newsletter!'
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();

		// 11. Select checkbox 'Receive special offers from our partners!'
		driver.findElement(By.xpath("//input[@id='optin']")).click();

		// 12. Fill details: First name, Last name, Company, Address, Address2, Country,
		// State, City, Zipcode, Mobile Number
		driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Arnold");
		driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Harrington St. 90210 Beverly Hills");
		WebElement selectCountryElement = driver.findElement(By.xpath("//select[@data-qa='country']"));
		Select selectCountry = new Select(selectCountryElement);
		selectCountry.selectByVisibleText("United States");
		driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("California");
		driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Orange Country");
		driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("90210");
		driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("1555752555");

		// 13. Click 'Create Account button'
		driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

		// 14. Verify that 'ACCOUNT CREATED!' is visible
		WebElement createdAccountElement = driver.findElement(By.xpath("//*[contains(text(),'Account Created!')]"));
		Assert.assertTrue(createdAccountElement.isDisplayed());

		// 15. Click 'Continue' button
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

		// 16. Verify that 'Logged in as username' is visible
		WebElement loggedTextElement = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
		Assert.assertTrue(loggedTextElement.isDisplayed());

		// 17. Click 'Delete Account' button
		driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

		// 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		WebElement deletedAccountElement = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
		Assert.assertTrue(deletedAccountElement.isDisplayed());
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
	}
}
