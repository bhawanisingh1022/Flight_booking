package Fbuking;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight 
{
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement drpcuntry = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select dcity=new Select(drpcuntry);
		dcity.selectByVisibleText("Portland");
		WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select d1=new Select(destination);
		d1.selectByValue("London");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Thread.sleep(15);
		 List<WebElement> totalflight = driver.findElements(By.xpath("//tr//form[@method='post']"));
		System.out.println(totalflight.size());
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();
		driver.findElement(By.id("inputName")).sendKeys("bhawani singh");
		driver.findElement(By.id("address")).sendKeys("1022 thanedar ki kothi");
		driver.findElement(By.name("city")).sendKeys("rewari");
		driver.findElement(By.name("state")).sendKeys("haryana");
		driver.findElement(By.name("zipCode")).sendKeys("123411");
		driver.findElement(By.name("creditCardNumber")).sendKeys("4160210804260412");
		driver.findElement(By.name("creditCardMonth")).sendKeys("12");
		driver.findElement(By.name("creditCardYear")).sendKeys("2023");
		driver.findElement(By.name("nameOnCard")).sendKeys("bhawani singh");
		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Thread.sleep(5000);
		String msghd = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		if(msghd.equals("Thank you for your purchase today!"))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		driver.quit();
	}

}
