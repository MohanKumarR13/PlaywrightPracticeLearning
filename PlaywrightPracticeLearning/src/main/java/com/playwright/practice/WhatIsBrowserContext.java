package com.playwright.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WhatIsBrowserContext {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions());
		Page page = browserContext.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()='Login']/..");
		page.locator("input[formcontrolname='username']").type("ortoni");
		page.locator("input[formcontrolname='password']").type("Pass1234$");
		page.locator("button[color='primary']").click();
		page.bringToFront();
		page.locator("input[type='search']").type("HP3");
		String userName = page.locator(
				"(//button[contains(@class,'mat-focus-indicator mat-icon-button')]/following-sibling::button)[2]")
				.textContent();
		System.out.println(userName.split(" ")[1].split(" ")[0]);

//New Tab

		Page newPage = browserContext.newPage();
		newPage.navigate("https://bookcart.azurewebsites.net/");
		
		// New Browser
		BrowserContext newContext = browser.newContext();

		Page newPage1 = newContext.newPage();
		newPage1.navigate("https://bookcart.azurewebsites.net/");
		/*
		 * newPage1.click("//span[text()='Login']/..");
		 * newPage1.locator("input[formcontrolname='username']").type("ortoni");
		 * newPage1.locator("input[formcontrolname='password']").type("Pass1234$");
		 * newPage1.locator("button[color='primary']").click(); userName =
		 * newPage.locator(
		 * "(//button[contains(@class,'mat-focus-indicator mat-icon-button')]/following-sibling::button)[2]"
		 * ) .textContent(); System.out.println(userName.split(" ")[1].split(" ")[0]);
		 * newPage1.close(); newContext.close();
		 */
	
		playwright.close();

	}

}
