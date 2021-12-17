package com.thoughtworks.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public static WebElement element = null;

	public void departure(WebDriver driver, String departMonth) {

		element = driver.findElement(By.id("departing"));
		Select s = new Select(element);
		s.selectByVisibleText(departMonth);
	}

	public void returning(WebDriver driver, String returnMonth) {

		element = driver.findElement(By.id("returning"));
		Select s = new Select(element);
		s.selectByVisibleText(returnMonth);

	}

	public WebElement promotionalCode(WebDriver driver) {

		element = driver.findElement(By.id("promotional_code"));
		return element;

	}

	public WebElement searchButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		return element;
	}
}
