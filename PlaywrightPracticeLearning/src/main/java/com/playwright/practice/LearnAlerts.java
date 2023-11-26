package com.playwright.practice;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnAlerts {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		Locator button = page.locator("text='Click Me'");
		page.onDialog(alert -> {
			String message = alert.message();
			System.out.println(message);
			alert.accept();
		});
		button.first().click();

		page.onDialog(alert -> {
			String message = alert.message();
			System.out.println(message);
			alert.accept();
		});
		button.nth(1).click();
		System.out.println(page.locator("#confirm-demo").textContent());

		page.onceDialog(alert -> {
			String message = alert.message();
			System.out.println(alert.defaultValue());
			System.out.println(message);
			alert.accept("Jack");
		});
		button.last().click();
		System.out.println(page.locator("#prompt-demo").textContent());
		page.waitForTimeout(3000);
		playwright.close();
	}
}
