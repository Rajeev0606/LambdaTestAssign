package TestDrive;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseDrive.BaseClass;
import PageDrive.Scenario3;

public class Scenario3_TestPage extends BaseClass {
	
	@Test
	
	public void TestPageforScenario3() {
		
		Scenario3 s3 = new Scenario3(driver);
		s3.clickInputFormSubmit();
		s3.clickSubmit();
		
		//Assert.assertEquals(s3.getFormResponseMessage(), "Please fill out this fields");
		s3.fillForm(prop.getProperty("Name"), prop.getProperty("Email"), prop.getProperty("Password"), prop.getProperty("Company"), prop.getProperty("Website"));
		s3.SelectCountry(prop.getProperty("Country"));
		s3.fillForms(prop.getProperty("City"), prop.getProperty("Address1"), prop.getProperty("Address2"), prop.getProperty("State"), prop.getProperty("Zipcode"));
		s3.clicksubmit1();
        Assert.assertEquals(s3.getFormResponseMessage1(), "Thanks for contacting us, we will get back to you shortly.");
		
	}

}
