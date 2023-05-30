import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registeration {

	public static void main(String[] args) throws InterruptedException, IOException {
//		// TODO Auto-generated method stub
		//WebDriver driver = WebDriverManager.chromedriver().create();
		ChromeOptions o = new ChromeOptions();
	
		o.addArguments("--remote-allow-origins=*");
		o.addArguments("--incognito");
//
	WebDriver driver=new ChromeDriver(o);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.navigate().to("http://www.qa.lessunicorns.com/");  
		driver.navigate().refresh();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		 driver.findElement(By.linkText("Register")).click();	
	WebDriverWait wait1   = new WebDriverWait(driver,Duration.ofSeconds(30));
	WebElement bfd=driver.findElement(By.xpath("//input[@placeholder='What can we call you?']"));
	wait1.until(ExpectedConditions.elementToBeClickable(bfd)).click();
	//	bfd.click();
		bfd.sendKeys("Method"+Integer.toString(((new Random().nextInt(10))+1)));
		driver.findElement(By.id("registration-next")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Man')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Latin/Hispanic')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Month')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'May')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Day')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'6')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Year')]")).click();

		List<WebElement> listofEle1=driver.findElements(By.xpath("//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1nf10eb']"));

		for(WebElement el2 :listofEle1)
		{
			if(el2.getText().trim().equals("1997"))
			{
				el2.click();
				break;
			}
		}
		
//		WebElement el= driver.findElement(By.xpath("//li[@data-value='1997']"));
//	Actions action=new Actions(driver);	
//	action.moveToElement(el).click().build().perform();
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//div[contains(text(),'Country')]")).click();

List<WebElement> listofEle=driver.findElements(By.xpath("//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters POFSelectItem css-q7zi3z']"));

for(WebElement el1 :listofEle)
{
	if(el1.getText().trim().equals("Canada"))
	{
		el1.click();
		break;
	}
}

driver.findElement(By.xpath("//div[contains(text(),'State / Province')]")).click();
List<WebElement> listofEle2=driver.findElements(By.xpath("//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1nf10eb']"));

for(WebElement el3 :listofEle2)
{
	if(el3.getText().trim().equals("Manitoba"))
	{
		el3.click();
		break;
	}
}
driver.findElement(By.xpath("//*[@class='MuiInputBase-input css-mnn31' and @placeholder='City']")).sendKeys("Vancover");
driver.findElement(By.xpath("//*[@class='MuiInputBase-input css-mnn31' and @placeholder='Postal Code / ZIP']")).sendKeys("Vancover");

driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
String email="Method00"+Integer.toString(((new Random().nextInt(100))+1))+"@gmail.com";
driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
driver.findElement(By.xpath("//input[@placeholder='Confirm email']")).sendKeys(email);
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Risk00"+Integer.toString(((new Random().nextInt(10))+1)));

driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("testing");
driver.findElement(By.xpath("//input[@placeholder='Confirm password']")).sendKeys("testing");
driver.findElement(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
WebDriverWait wait2  = new WebDriverWait(driver,Duration.ofSeconds(60));
//WebElement el2=driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
//wait2.until(ExpectedConditions.elementToBeClickable(el2)).click();
Boolean nn=driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/div[5]/div[2]/button")).isDisplayed();
if(nn)
{
	driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/div[5]/div[2]/button")).click();
	driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
	driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/div[5]/div[2]/button")).click();
	}
else 
{
	System.out.println("taking time");
}
try {
while(driver.findElement(By.xpath("//p[@id='-input-error-helper']")).isDisplayed())
{
	String s1 = Keys.chord(Keys.CONTROL, "a");
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(s1);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Keys.DELETE);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Risk00"+Integer.toString(((new Random().nextInt(100))+1)));	
	driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/div[5]/div[2]/button")).click();
	driver.findElement(By.xpath("//input[@placeholder='Confirm password']")).click();
	driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/div[5]/div[2]/button")).click();
	driver.findElement(By.xpath("//input[@placeholder='Confirm password']")).click();
	driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/div[5]/div[2]/button")).click();
} 
}
catch(Exception e){
	System.out.println("Element is not proeset " +e);
}

try {
while(driver.findElement(By.xpath("//p[contains(text(),'This address is already registered')]")).isDisplayed())
{  
	String s = Keys.chord(Keys.CONTROL, "a");
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(s);
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Keys.DELETE);
	String email1="Method00"+Integer.toString(((new Random().nextInt(100))+1))+"@gmail.com";
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email1);
	driver.findElement(By.xpath("//input[@placeholder='Confirm email']")).sendKeys(s);
	driver.findElement(By.xpath("//input[@placeholder='Confirm email']")).sendKeys(Keys.DELETE);
	driver.findElement(By.xpath("//input[@placeholder='Confirm email']")).sendKeys(email1);
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
}
}
catch(Exception e){
	System.out.println("Element is not proeset " +e);
}

WebDriverWait wait3  = new WebDriverWait(driver,Duration.ofSeconds(60));
//try {
//WebElement bfd1=driver.findElement(By.xpath("//span[contains(text(),\"Let's go\")]"));
//wait2.until(ExpectedConditions.elementToBeClickable(bfd1)).click();
//}catch(StaleElementReferenceException exe) {exe.printStackTrace();  }

Thread.sleep(30);

driver.findElement(By.xpath("//*[@id=\"main-body\"]/div/main/div/div/div[2]/div/button")).click();
try{
	
	if(driver.findElement(By.xpath("//p[contains(text(),'Welcome')]")).isDisplayed())
	{
		driver.findElement(By.id("createprofile-firstname-input")).sendKeys("dshj");
		driver.findElement(By.xpath("//div[@aria-label='State / Province']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Manitoba')]")).click();
		driver.findElement(By.xpath("//input[@id='createprofile-city-input']")).sendKeys("kadhjh");
		driver.findElement(By.xpath("//input[@id='createprofile-postalcode-input']")).sendKeys("kadhjh");
		Thread.sleep(30);
		Actions a = new Actions(driver);
	      a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Next')]"))).
	      doubleClick().
	      build().perform();
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

	}
	
}
catch(Exception e){
	System.out.println("Element is not proeset " +e);
}

//Actions action1=new Actions(driver);	
//action1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Argentina')]"))).click().build().perform();
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
		// driver.quit();

//Boolean n2= driver.findElement(By.xpath("//div[@id='dropout-account-scene']")).isDisplayed();
//System.out.println(n2);
//while(n2)
//{
//driver.findElement(By.xpath("//input[@id='createprofile-firstname-input']")).sendKeys("dshj");
//driver.findElement(By.xpath("//div[@aria-label='State / Province']")).click();
//driver.findElement(By.xpath("//li[contains(text(),'Newfoundland')]")).click();
//driver.findElement(By.xpath("//input[@id='createprofile-city-input']")).sendKeys("kadhjh");
//driver.findElement(By.xpath("//input[@id='createprofile-postalcode-input']")).sendKeys("kadhjh");
//driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//}


//Welcomeback(n2);

driver.findElement(By.xpath("//span[contains(text(),'Women')]")).click();
WebElement slider3 = driver. findElement(By. xpath("//*[@id=\"distance-slider-input\"]/span[5]/input"));
int width3 = slider3.getSize().getWidth();
//Actions action = new Actions(driver);
Actions act3= new Actions(driver);
act3.dragAndDropBy(slider3, 60, 0).perform();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//driver.findElement(By.xpath("//span[contains(text(),'I am putting in serious effort to find someone')]")).click();
//driver.findElement(By.xpath("//span[contains(text(),'I only date smokers')]")).click();
//driver.findElement(By.xpath("//*[@id=\"createprofile-would-date-parent-chip-group\"]/div/div[2]/div[2]/span[1]/span")).click();
//driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

driver.findElement(By.xpath("//input[@id=\"createprofile-profession-input\"]")).sendKeys("tester");

driver.findElement(By.xpath("//span[contains(text(),'High school')]")).click();
driver.findElement(By.xpath("//span[contains(text(),'High school')]")).click();
driver.findElement(By.xpath("//span[contains(text(),'I am putting in serious effort to find someone')]")).click();
WebElement slider = driver. findElement(By. xpath("//*[@id=\"createprofile-ambition-select\"]/span[5]/input"));
int width = slider.getSize().getWidth();
int x =slider.getSize().getHeight();

System.out.println(width);
System.out.println(x);
//Actions action = new Actions(driver);
//Actions act= new Actions(driver);
Actions act= new Actions(driver);
//act.dragAndDropBy(slider, -911, 1064).perform();
act.moveToElement(slider, 150, 10).click();
act.build().perform();
//action.clickAndHold(slider);
//action.moveByOffset(100, 0).build().perform();
driver.findElement(By.xpath("//*[@id=\"createprofile-income-chip-group\"]/div/div[2]/div[6]/span[1]/span")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-religion-chip-group\"]/div/div[2]/div[11]/span[1]/span")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-second-language-chip-group\"]/div/div[2]/div[13]/span[1]/span")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//span[text()='Single']")).click();
driver.findElement(By.xpath("//span[text()='Hazel']")).click();
driver.findElement(By.xpath("//span[text()='Black']")).click();
WebElement slider1 = driver. findElement(By. xpath("//*[@id=\"createprofile-height-select\"]/span[5]/input"));
int width1 = slider1.getSize().getWidth();
//Actions action = new Actions(driver);
Actions act1= new Actions(driver);
act1.dragAndDropBy(slider1, 60, 0).perform();
//act1.moveToElement(slider1, ((width1*10)/100), 0).click();
//act1.build().perform();

//Actions move1 = new Actions(driver);
//Action action1 = (Action) move1.dragAndDropBy(slider1, 30, 0).build();
//((Actions) action1).perform();
//Actions action1 = new Actions(driver);
//action1.clickAndHold(slider1);
//action.moveByOffset(10, 10).build().perform();
driver.findElement(By.xpath("//span[text()='Thin']")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();


driver.findElement(By.xpath("//span[text()='Adventurer']")).click();
driver.findElement(By.xpath("//span[text()='Socially']")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-smokes-chip-group\"]/div/div[2]/div[2]/span[1]/span")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-drugs-chip-group\"]/div/div[2]/div[1]/span[1]/span")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-car-chip-group\"]/div/div[2]/div[2]/span[1]/span")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//span[text()='All my kids are over 18']")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-want-children-chip-group\"]/div/div[2]/div[4]/span[1]/span")).click();
driver.findElement(By.xpath("//span[text()='Cat']")).click();
driver.findElement(By.xpath("//span[text()='Still married']")).click();
WebElement slider2 = driver. findElement(By. xpath("//*[@id=\"createprofile-siblings-select\"]/span[5]/input"));
//int width2 = slider2.getSize().getWidth();
//Actions action = new Actions(driver);
Actions act2= new Actions(driver);
act2.moveToElement(slider2, 60, 0).click();
act2.build().perform();
driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
Thread.sleep(30);
driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div/input")).sendKeys("testing");
Thread.sleep(30);
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//*[@id=\"onboarding-dw-buttons\"]/div[2]/button")).click();
driver.findElement(By.xpath("//*[@id=\"createprofile-styled-textarea-input-with-border\"]")).sendKeys("testing");
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
Thread.sleep(30);
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//WebDriverWait wait4   = new WebDriverWait(driver,Duration.ofSeconds(30));
//WebElement sms=driver.findElement(By.xpath("//*[@id=\"sms-phonenumber-input\"]/label/div/input"));
//wait4.until(ExpectedConditions.elementToBeClickable(sms)).isDisplayed();
Thread.sleep(30);
driver.findElement(By.xpath("//*[@id=\"sms-phonenumber-input\"]/label/div/input")).sendKeys("7781111111");
driver.findElement(By.xpath("//*[@id=\"verification-flow-container S\"]/div/button")).click();
for(int i=1;i<=6;i++)
{
	driver.findElement(By.xpath("//input[@aria-label='Input verification code digit " +i+"\']")).sendKeys("1");
}
driver.findElement(By.xpath("//*[@id=\"verification-flow-container S\"]/div/div[2]/button")).click();
//driver.findElement(By.xpath("//*[@id='complete-profile-scene']/div/div[1]/div[1]/button")).click();


// Confirmation message
//WebElement frame =driver.switchTo().activeElement();
//frame.sendKeys("C:\\Users\\thinksysuser\\Downloads\\1654596386412.jpeg");



driver.findElement(By.xpath("//*[@id=\"complete-profile-scene\"]/div/div[2]/button")).click();

//ProcessBuilder pb =new ProcessBuilder("C:\\Users\\thinksysuser\\Documents\\Uploadscript.exe");
//pb.start();

//driver.findElement(By.xpath("//*[@id=\"createprofile-car-chip-group\"]/div/div[2]/div[2]/span[1]/span")).click();
//driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

Thread.sleep(30);
Runtime.getRuntime().exec("C:\\Users\\thinksysuser\\Documents\\Uploadscript.exe");
driver.findElement(By.xpath("//button[@id='upload-image-dialog-save-button']")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
driver.findElement(By.xpath("//button[@id='pledge-submit-button']")).click();
driver.findElement(By.xpath("//span[contains(text(),'No thanks')]")).click();


//	
//	private static void Welcomeback(Boolean n2) {
//		// TODO Auto-generated method stub
//		if (n2)
//		{
//			ChromeDriver.findElement(By.xpath("//input[@id='createprofile-firstname-input']")).sendKeys("dshj");
//			
//			ChromeDriver.findElement(By.xpath("//div[@aria-label='State / Province']")).sendKeys("asdghj");
//			ChromeDriver.findElement(By.xpath("//input[@id='createprofile-city-input']")).sendKeys("kadhjh");
//			ChromeDriver.findElement(By.xpath("//input[@id='createprofile-postalcode-input']")).sendKeys("kadhjh");
//			
//		}
//		else 
//		{
//			exist(0);
//		}
//	}
//
//	private static void exist(int i) {
//		// TODO Auto-generated method stub
//		
//	}

	}
}
