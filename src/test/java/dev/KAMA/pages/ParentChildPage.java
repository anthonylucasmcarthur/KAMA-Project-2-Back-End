package dev.KAMA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentChildPage {
	
	WebDriver driver;
	
	public ParentChildPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};


}
