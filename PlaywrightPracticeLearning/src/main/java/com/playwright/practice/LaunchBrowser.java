package com.playwright.practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("https://www.google.co.in");
		String title=page.title();
		System.out.println("Title is " + title);
		page.close();
		browser.close();
		playwright.close();
	}

}
