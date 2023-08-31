package lambdanew;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("  ** Test Started** ");
		WebDriver driver = new ChromeDriver();
		
		String username = "rahulkusingh2@gmail.com";
		String Password = "Rahul#@44";
		System.out.println("Browser opened");
		driver.manage().window().maximize();
		
		Login(driver, username , Password);
//		Changepasser( driver, Password);
		Changepass(driver);

	}
	public static void Login(WebDriver driver, String username, String Password) {
		
		
		
//		 Navigate to the login page
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		sleep(1);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon.fas.fa-user")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon.fas.fa-user")));
		
		driver.findElement(By.cssSelector(".icon.fas.fa-user")).click();
		
//		Find the email
		driver.findElement(By.cssSelector("#input-email")).sendKeys(username);
		sleep(1);
		driver.findElement(By.cssSelector("#input-password")).sendKeys(Password);
		sleep(1);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Login']")));
		sleep(1);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		if (driver.getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/index.php?route=account/account")) {
           System.out.println("Login successful!");
       } else {
           System.out.println("Login failed!");
       }

		
		System.out.println(driver.findElements(By.xpath("//aside[@id='column-right']")).size());
		
		
		
}
public static void Changepasser(WebDriver driver, String Password)
{
	driver.findElement(By.cssSelector(".fas.fa-2x.mb-1.fa-key")).click();
	sleep(1);
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".#input-password"))); 
	
	driver.findElement(By.cssSelector("#input-password")).sendKeys(Password);
	sleep(1);
	driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Rahul#@67");
	sleep(1);
	driver.findElement(By.cssSelector("input[value='Continue']")).click();
	sleep(1);
	System.out.println(driver.findElement(By.cssSelector(".text-danger")).getText());
}
public static void Changepass(WebDriver driver)
{
	driver.findElement(By.cssSelector("#input-password")).sendKeys("Rahul#@67");
	sleep(1);
	driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Rahul#@67");
	sleep(1);
	driver.findElement(By.cssSelector("input[value='Continue']")).click();
	sleep(1);
	System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
}

private static void sleep(int s) {
	// TODO Auto-generated method stub
	try
	{
		Thread.sleep(s*1000);
	}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

