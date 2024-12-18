package FinalExam.Q1.OpenKart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
	
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) {
    	
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        
    }

    public void searchForProduct(String productName) {
    	
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
   
    }
}
