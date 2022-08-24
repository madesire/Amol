package TestMethods;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.ReadDataFrompropertiesFiles;
public class TestNgMethods extends BaseCodeFile {
	
	@Test(priority = 1)
	public void validateLogin() throws IOException {
		lp.loginToApplication(ReadDataFrompropertiesFiles.readconfigdata("username"),ReadDataFrompropertiesFiles.readconfigdata("password") );
		lp.enterPin(ReadDataFrompropertiesFiles.readconfigdata("passkey"));
	}
	@Test(priority = 2)
	public void validateTitle() {
	String actualtital	=lp.titleOfPage();
	String expectedtital = "Kite - Zerodha's fast and elegant flagship trading platform";
	Assert.assertEquals(actualtital, expectedtital);;
	
	}

}
