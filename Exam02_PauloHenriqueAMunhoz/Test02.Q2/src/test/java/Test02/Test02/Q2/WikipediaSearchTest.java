package Test02.Test02.Q2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikipediaSearchTest {
	
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
    	
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait time
   
    }

    @Test
    public void testWikipediaSearch() {
    	
        // Open the Wikipedia.org HomePage
        driver.get("https://www.wikipedia.org/");

        // Enter a search term in the search bar
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        searchInput.sendKeys("Itachi Uchira");

        // Click the "Search" button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        searchButton.click();

        // Verify that the search results page contains the search term
        WebElement firstHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstHeading")));
        String headingText = firstHeading.getText();
        Assert.assertTrue(headingText.contains("Selenium (software)"), "The search results page does not contain the search term.");
    
    }

    @AfterClass
    public void tearDown() {
    	
        if (driver != null) {
        	
            driver.quit();
            
        }
    }
}
