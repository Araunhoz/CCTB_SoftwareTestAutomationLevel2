package main;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;
import pages.AmazonSearchResultsPage;

public class MainTest extends BaseTest {

    public static void main(String[] args) {
    	
        MainTest test = new MainTest();
        test.setUp();

        try {
            // Navigate to Amazon
            test.driver.get("https://www.amazon.com");

            // Initialize Page Objects
            AmazonHomePage homePage = new AmazonHomePage(test.driver);
            AmazonLoginPage loginPage = new AmazonLoginPage(test.driver);
            AmazonSearchResultsPage searchResultsPage = new AmazonSearchResultsPage(test.driver);

            // Login
            homePage.clickSignIn();

            // Wait for login page to load
            WebDriverWait wait = new WebDriverWait(test.driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(loginPage.emailField));

            // Enter email and password
            loginPage.enterEmail("your-email@example.com");
            wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
            loginPage.enterPassword("your-password");

            // Search for a product
            homePage.searchForProduct("Laptop");

            // Wait for search results to load
            wait.until(ExpectedConditions.visibilityOf(searchResultsPage.someElementOnSearchResultsPage));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}
