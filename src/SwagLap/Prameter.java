package SwagLap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Prameter {
		static String Url = "https://www.saucedemo.com/";
		static String StandardUserName = "standard_user";
		static String ProblemUserName = "problem_user";
		static String PerformanceUserName = "performance_glitch_user";
		static String passWord = "secret_sauce";
		static WebDriver driver = new ChromeDriver();
		static Random Rand = new Random();

		static void LogInFunction(String UserName, String Password) {
			WebElement userNameInputField = driver.findElement(By.id("user-name"));
			WebElement PassWordInputField = driver.findElement(By.id("password"));
			userNameInputField.sendKeys(UserName);
			PassWordInputField.sendKeys(Password);
			driver.findElement(By.id("login-button")).click();
		}
		
	}


