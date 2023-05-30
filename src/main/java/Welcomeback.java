import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Welcomeback {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions o = new ChromeOptions();
		
		o.addArguments("--remote-allow-origins=*");
		o.addArguments("--incognito");
//
	WebDriver driver=new ChromeDriver(o);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.navigate().to("http://www.qa.lessunicorns.com/");  
		driver.navigate().refresh();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign')]")).click();	
		driver.findElement(By.xpath("//input[@placeholder='Username / Email']")).sendKeys("pof_pri27");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test");
		driver.findElement(By.xpath("//span[contains(text(),'Log')]")).click();
		
			
			if(driver.findElement(By.xpath("//p[contains(text(),'Welcome')]")).isDisplayed())
			{
				driver.findElement(By.id("createprofile-firstname-input")).sendKeys("dshj");
				driver.findElement(By.xpath("//div[@aria-label='State / Province']")).click();
				driver.findElement(By.xpath("//li[contains(text(),'Arkansas')]")).click();
				driver.findElement(By.xpath("//input[@id='createprofile-city-input']")).sendKeys("kadhjh");
				driver.findElement(By.xpath("//input[@id='createprofile-postalcode-input']")).sendKeys("kadhjh");
				Thread.sleep(30);
				Actions a = new Actions(driver);
			      a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Next')]"))).
			      doubleClick().
			      build().perform();
//				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

			}
		
		}
	

	}


	
