package Test02.Test02.Q3;

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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;

public class TargetSearchTest {
	
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
    	
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased wait time to 10 seconds
    
    }

    @Test
    public void testTargetSearch() {
        
    	try {
            // Open the Target.com HomePage
            driver.get("https://www.target.com/");

            // Wait for the page to load completely
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            // Enter a search term in the search bar
            WebElement searchInput = driver.findElement(By.id("search"));
            searchInput.sendKeys("laptop");

            // Click the search button
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            searchButton.click();

            // Verify that the search results page contains the search term
            String pageSource = driver.getPageSource();
            Assert.assertTrue(pageSource.contains("laptop"), "The search results page does not contain the search term.");
        
        } catch (NoSuchElementException e) {
        	
            System.err.println("Element not found: " + e.getMessage());
            Assert.fail("Test failed due to missing element.");
            
        } catch (TimeoutException e) {
        	
            System.err.println("Element not interactable within time limit: " + e.getMessage());
            Assert.fail("Test failed due to timeout.");
            
        } catch (Exception e) {
        	
            System.err.println("An unexpected error occurred: " + e.getMessage());
            Assert.fail("Test failed due to an unexpected error.");
        
        }
    }

    @AfterClass
    public void tearDown() {
    	
        if (driver != null) {
        	
            driver.quit();
            
        }
    }
}
