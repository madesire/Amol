package Functionalities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
	private @FindBy(xpath = "//*[@type='button']")
	WebElement getstartedbutton;
	
	@FindBy(xpath = "//div[@class='instrument-search']//input[@placeholder='Search eg: infy bse, nifty fut, nifty weekly, gold mcx']")
	WebElement searchbox;
	
	@FindBy(xpath = "//button[normalize-space()='Buy']")
	WebElement buybutton;
	
	@FindBy(xpath = "//div[@class='four columns quantity']//input[@type='number']")
	WebElement quantity;
	
	@FindBy(xpath = "//button//span[text()='Buy']")
	WebElement finalbutton;
	
	@FindBy(xpath = "//div[@class='message']")
	WebElement validateshare;
	
	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void searchShares(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.switchTo().alert().dismiss();
		getstartedbutton.click();
		searchbox.sendKeys("deepakntr" , Keys.ENTER);
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element =mywait.until(ExpectedConditions.visibilityOf(buybutton));
		element.click();	
		quantity.sendKeys("10");
		
	}
	public void buyShare()
	{
//		buybutton.click();
		finalbutton.click();
	}
	public void validateshare() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println(validateshare.getText());
		if(validateshare.getText().contains("Markets are closed right now")) {
			System.out.println("market is closed");
		}
		
	}

}
