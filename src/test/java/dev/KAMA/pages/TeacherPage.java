package dev.KAMA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherPage {
	
	WebDriver driver;
	
	public TeacherPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};


}
