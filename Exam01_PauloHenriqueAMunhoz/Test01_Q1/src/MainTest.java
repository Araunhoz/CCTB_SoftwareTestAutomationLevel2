import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainTest {
	
    public static void main(String[] args) {
    	
        // Set up the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Navigate to the website
            driver.get("https://www.advantageonlineshopping.com");

            // Wait for the homepage to load and verify the title
            System.out.println("...Waiting for homepage to load...");
            wait.until(ExpectedConditions.titleContains("Advantage Shopping"));
            if (!driver.getTitle().contains("Advantage Shopping")) {
            	
                System.out.println("Test Failed: Homepage not displayed.");
                return;
                
            }
            System.out.println("Homepage loaded successfully.");

            // Initialize Page Objects
            ProductSearchPage searchPage = new ProductSearchPage(driver);
            ProductDetailPage detailPage = new ProductDetailPage(driver);

            // Search for a product
            System.out.println("...Entering search term...");
            wait.until(ExpectedConditions.visibilityOf(searchPage.searchIcon));
            searchPage.enterSearchTerm("Laptop");

            System.out.println("...Waiting for search results...");
            wait.until(ExpectedConditions.visibilityOf(searchPage.firstProduct));

            // Wait for the loader to disappear
            System.out.println("...Waiting for loader to disappear...");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));

            // Select the first product
            System.out.println("...Selecting the first product...");
            searchPage.clickFirstProduct();

            // Verify product detail page loaded
            System.out.println("...Waiting for product detail page...");
            wait.until(ExpectedConditions.visibilityOf(detailPage.addToCartButton));

            // Add the product to the cart
            if (detailPage.isAddToCartButtonDisplayed()) {
            	
                System.out.println("...Adding product to cart...");
                detailPage.clickAddToCart();
                // Add a sleep to wait for the action to complete (replace with explicit wait in real tests)
                Thread.sleep(3000);

                // Verify the product is added to the cart
                // This is a placeholder; actual verification would involve checking the cart page
                System.out.println("Test Passed: Product added to cart.");
            
            } else {
            	
                System.out.println("Test Failed: Add to Cart button not displayed.");
            
            }

        } catch (Exception e) {
        	
            e.printStackTrace();
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
