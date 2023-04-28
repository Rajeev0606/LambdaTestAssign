package TestDrive;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseDrive.BaseClass;
import PageDrive.Scenario1;

public class Scenario1_TestPage extends BaseClass {
	
	@Test
	
	public void TestpageforScenario1() {
		
		Scenario1 sc1 = new Scenario1(driver);
		sc1.clickSimpleFormDemo();
		Assert.assertTrue(sc1.validation(), "Simple Form Demo");
		sc1.textEnterMessage(prop.getProperty("InputMessage"));
		sc1.clickGetCheckedValueButton();
		Assert.assertTrue(sc1.ResultMessage(), prop.getProperty("InputMessage"));
	}

}
