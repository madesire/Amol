package TestMethods;
import org.testng.annotations.Test;
public class DashboardMethods extends BaseCodeFile {

		@Test(priority = 3)
		public void searchSharesTest()
		{
			dp.searchShares();
		}
		
		@Test(priority = 4)
		public void validateBuyShare()
		{
			dp.buyShare();
		}
		@Test(priority = 5)
		public void validateshare() {
			dp.validateshare();

}

}