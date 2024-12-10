package FinalExam.Q3.AdvangeShopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdvantageShoppingTest {
	
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
    	
        driver = new SafariDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void registerUser() {
    	// We can use the URL of register
        driver.get("http://advantageonlineshopping.com/#/register");

        try {

            // Fill out the registration form
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("usernameRegisterPage"))).sendKeys("testuser777");
            driver.findElement(By.name("emailRegisterPage")).sendKeys("testuser777@example.com");
            driver.findElement(By.name("passwordRegisterPage")).sendKeys("Password777");
            driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Password777");
            driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Test");
            driver.findElement(By.name("last_nameRegisterPage")).sendKeys("User");
            driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("99999999999");
            driver.findElement(By.name("countryListboxRegisterPage")).sendKeys("United States");
            driver.findElement(By.name("cityRegisterPage")).sendKeys("Manaos");
            driver.findElement(By.name("addressRegisterPage")).sendKeys("Mao");
            driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("State777");
            driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("6907788");

            WebElement agreeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.name("i_agree")));
            agreeCheckbox.click();

            WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register_btnundefined")));
            registerButton.click();

            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='success']")));
            Assert.assertTrue(successMessage.isDisplayed(), "Registration failed!");
       
        } catch (Exception e) {
        	
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "registerUser")
    public void loginUser() {
    	
        driver.get("http://advantageonlineshopping.com/#/login");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("testuser777");
            driver.findElement(By.name("password")).sendKeys("Password777");

            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign_in_btnundefined")));
            loginButton.click();

            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuUserLink")));
            Assert.assertTrue(logoutButton.isDisplayed(), "Login failed!");
        
        } catch (Exception e) {
        	
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        
        }
    }

    @Test(dependsOnMethods = "loginUser")
    public void searchForProduct() {
    	
        driver.get("http://advantageonlineshopping.com/#/category/Special%20offer");

        try {
        	
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("TABLETS"))).click();

            WebElement productContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("categoryRight")));
            Assert.assertTrue(productContainer.isDisplayed(), "Product listing not found!");
       
        } catch (Exception e) {
        	
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
       
        }
    }

    @AfterTest
    public void tearDown() {
    	
        if (driver != null) {
        	
            driver.quit();
        
        }
    }
}
