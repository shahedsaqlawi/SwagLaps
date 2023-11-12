package SwagLap;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwagLap extends Prameter {
	@BeforeMethod
	public void mySetup() {
		driver.get(Url);
		driver.manage().window().maximize();
	}

	@BeforeTest
	public void MySetUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test()
	public void Magento() throws InterruptedException {
//		login
		LogInFunction(StandardUserName, passWord);
		Thread.sleep(3000);
//	Sorting Randomly
		WebElement mySelector = driver.findElement(By.className("product_sort_container"));
		Select selector = new Select(mySelector);
		selector.selectByIndex(Rand.nextInt(3));
		Thread.sleep(4000);
//	   AddedToCart
		List<WebElement> addtoCartButtons = driver.findElements(By.className("btn_primary"));
		for (int i = 0; i < addtoCartButtons.size(); i++) {
			addtoCartButtons.get(i).click();
		}
		Thread.sleep(3000);

//	Checkout
		WebElement Cart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		Cart.click();
		WebElement CheckOut = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		CheckOut.click();
		Thread.sleep(3000);

//Random Value
		String[] FirstNames = { "Shahed", "Sara", "Qamar", "Sahar" };
		String[] LastNames = { "Salem", "Islam", "Ahmad", "Karam", "Sami" };
		// Random Items
		int RandomFirstNames = Rand.nextInt(FirstNames.length);// firstName
		int Random = Rand.nextInt(20000);// Email
		int RandomLastNames = Rand.nextInt(LastNames.length);// LastName
		
//		firstName
		WebElement FirstNameInput = driver.findElement(By.id("first-name"));
//		LastName
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
//		Postalcode
		WebElement PostalCodeInput = driver.findElement(By.id("postal-code"));
		FirstNameInput.sendKeys(FirstNames[RandomFirstNames]);
		LastNameInput.sendKeys(LastNames[RandomLastNames]);
		PostalCodeInput.sendKeys("1234"+Random);
		Thread.sleep(3000);

//		btn checkout
		WebElement SubmitBtn = driver.findElement(By.id("continue"));
		SubmitBtn.click();
		Thread.sleep(3000);

		WebElement FinishBtn = driver.findElement(By.id("finish"));
		FinishBtn.click();
		Thread.sleep(3000);


	}

	@AfterTest
	public void myPostTesting() {

	}
}
