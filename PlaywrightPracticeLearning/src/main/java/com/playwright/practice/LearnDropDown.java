package com.playwright.practice;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle.SelectOptionOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class LearnDropDown {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
		// 1.
		page.selectOption("#fruits", "1");
		String notification = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(notification);
		// 2.
		Locator locator = page.locator("#fruits");
		locator.selectOption(new SelectOption().setLabel("Banana"));
		String notificationMsg = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(notificationMsg);

		// 3.
		Locator locator1 = page.locator("#fruits");
		locator1.selectOption(new SelectOption().setIndex(3));
		String notificationMsg1 = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(notificationMsg1);
		// 4.
		Locator hero = page.locator("#superheros");
		hero.selectOption(new String[] { "aq", "bt", "cm" });
		System.out.println(hero);

		// 5.
		Locator lang = page.locator("#lang");
		Locator options = lang.locator("option");
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(i -> System.out.println(i));
		int count = options.count();
		System.out.println("Length:" + count);
		lang.selectOption(new SelectOption().setIndex(count - 1));
		// ,new SelectOptionOptions().setTimeout(5000));

		page.close();
		playwright.close();
	}

}
