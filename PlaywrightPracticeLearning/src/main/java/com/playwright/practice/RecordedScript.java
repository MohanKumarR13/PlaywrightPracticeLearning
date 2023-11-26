package com.playwright.practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
import java.util.regex.Pattern;

public class RecordedScript {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://letcode.in/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email"))
					.fill("1234");
			page.getByPlaceholder("Enter password").click();
			page.getByPlaceholder("Enter password").fill("1234");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign up")).click();
			page.getByPlaceholder("Enter your name").click();
			page.getByPlaceholder("Enter your name").fill("MohanKumar");
			page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Email$"))).click();
			page.getByPlaceholder("Enter valid email address").click();
			page.getByPlaceholder("Enter valid email address").fill("svgvedha@gmail.com");
			page.getByPlaceholder("Enter valid email address").press("Tab");
			page.getByPlaceholder("Enter your password").fill("moh@n&kum@rR13");
			page.getByText("I agree to the terms and conditions").click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN UP")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign out")).click();
			playwright.close();
		}
	}
}
