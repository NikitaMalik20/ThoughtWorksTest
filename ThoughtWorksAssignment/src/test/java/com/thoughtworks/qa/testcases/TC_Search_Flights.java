package com.thoughtworks.qa.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.thoughtworks.qa.pages.HomePage;

public class TC_Search_Flights {

	public WebDriver driver;
	HomePage homePage = new HomePage();

	@BeforeSuite

	public void launchURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String baseURL = "https://marsair.thoughtworks-labs.net/NikitaMalik";
		driver.get(baseURL);
	}

	@Test(priority = 0)
	public void searchFlights() throws InterruptedException {

		homePage.departure(driver, "July");
		Thread.sleep(2000);
		homePage.returning(driver, "December (two years from now)");
		Thread.sleep(2000);
		homePage.promotionalCode(driver).sendKeys("RF3-JHY-216");
		Thread.sleep(2000);
		homePage.searchButton(driver).click();
		Thread.sleep(2000);

		// Check if search criteria is valid
		if (driver.getPageSource().contains("Seats available!")) {
			System.out.println("Seats are available");
		} else if (driver.getPageSource().contains("Sorry, there are no more seats available.")) {
			System.out.println("Seats are unavailable");
		} else if (driver.getPageSource().contains("Unfortunately, this schedule is not possible. Please try again.")) {
			System.out.println("Invalid schedule");
		}

		// Check if promotional code is applied
		if (driver.getPageSource().contains("Promotional code ")) {
			System.out.println("Promotional code is applied");
		} else {
			System.out.println("Promotional code is not applied");
		}
	}

	@AfterSuite
	public void afterSuite() {
		if (driver != null)
			driver.quit();
	}

}
