package FinalExam.Q1.OpenKart;

import FinalExam.Q1.OpenKart.pages.LoginPage;
import FinalExam.Q1.OpenKart.pages.RegistrationPage;
import FinalExam.Q1.OpenKart.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenKartTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	
        driver = new SafariDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com"); 
        
    }

    @AfterClass
    public void tearDown() {
    	
        if (driver != null) {
        	
            driver.quit();
            
        }
    }

    @Test
    public void registerUser() {
    	
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser("Joao", "Paulo", "joao.paulo@blabla.com", "blablabla777");
        
    }

    @Test
    public void loginUser() {
    	
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("joao.paulo@blabla.com", "blablabla777");
        
    }

    @Test
    public void searchForProduct() {
    	
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForProduct("Laptop");
        
    }
}
