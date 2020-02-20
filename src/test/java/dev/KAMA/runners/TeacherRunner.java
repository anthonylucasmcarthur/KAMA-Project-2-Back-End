package dev.KAMA.runners;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.KAMA.pages.HomePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Teacher.feature", glue = "dev.KAMA.steps")
public class TeacherRunner {

	public static WebDriver driver;
	public static HomePage homepage;

	static {
		File file = new File("src/main/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		homepage = new HomePage(driver);
	}
	
	@Test
	public void english() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
	}
	
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
