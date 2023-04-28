package PageDrive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityDrive.Utils;

public class Scenario2 extends Utils {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
	WebElement dds;

	@FindBy(xpath = "//div[@id='slider3']//input")
	WebElement slider3;

	public Scenario2(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDragandDrop() {
		dds.click();
	}

	public void dragSlider() {
		Actions actions = new Actions(driver);
		actions.build().perform();
		actions.dragAndDropBy(slider3, 95, 0).build().perform();
	}

	public String getSliderValue() {
		return slider3.getAttribute("value");
	}

}
