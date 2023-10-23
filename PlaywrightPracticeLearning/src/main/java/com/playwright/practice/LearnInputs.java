package com.playwright.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnInputs {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		String title = page.title();
		System.out.println("Title is " + title);
		// page.locator("#fullName").fill("MohanKumar");
		page.fill("#fullName", "MohanKumar");
		Locator locator = page.locator("#join");
		locator.press("End");
		locator.type("man");
		locator.press("Tab");
		String attribute = page.locator("#getMe").getAttribute("value");
		System.out.println(attribute);
		page.locator("#clearMe").clear();
		page.close();
		browser.close();
		playwright.close();
	}

}
