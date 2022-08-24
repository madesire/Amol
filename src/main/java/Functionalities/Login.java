package Functionalities;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(xpath = "//*[@id='userid']")
	WebElement usernamefield;

	@FindBy(xpath = "//*[@id='password']")
	WebElement passwordfield;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginbutton;

	@FindBy(xpath = "//*[@id='pin']")
	WebElement pin;

	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String username, String password) {
		usernamefield.sendKeys(username);

		passwordfield.sendKeys(password);

		loginbutton.click();
	}

	public void enterPin(String passkey) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pin.sendKeys(passkey);
		loginbutton.click();
	} 

	public String titleOfPage() {
		String title = driver.getTitle();

		System.out.println(title);
		return title;
		
	}

}
