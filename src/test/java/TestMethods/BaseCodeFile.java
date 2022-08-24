package TestMethods;
import java.io.File;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import Functionalities.Dashboard;
import Functionalities.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Default;
import Utility.*;
public class BaseCodeFile {
	protected static WebDriver driver;
	
	protected Login lp;
	
	protected Dashboard dp;
	@BeforeSuite
	public void initBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disabled-notifications");
//		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
//		options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
		
//		driver.manage().window().maximize();
		
		driver.get("https://kite.zerodha.com/");
	}

	@BeforeClass
	public void createObject()
	{
		 lp = new Login(driver);
		 dp = new Dashboard(driver);
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
