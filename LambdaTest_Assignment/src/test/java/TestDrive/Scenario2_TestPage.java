package TestDrive;

import org.testng.annotations.Test;

import BaseDrive.BaseClass;
import PageDrive.Scenario2;

public class Scenario2_TestPage extends BaseClass {
	
	@Test
	
	public void TestPageForScenario2() {
		
		Scenario2 s2 = new Scenario2(driver);
		s2.clickDragandDrop();
		s2.dragSlider();
		String sliderValue = s2.getSliderValue();
		if(sliderValue.equals("95")) {
			System.out.println("Test Passed: Slider value is 95");
		}
		else {
			System.out.println("Test Failed: Slider value is" + sliderValue);
		}
	}

}
