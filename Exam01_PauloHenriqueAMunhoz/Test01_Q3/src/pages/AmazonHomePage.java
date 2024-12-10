package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
    WebDriver driver;

    @FindBy(id = "nav-link-accountList")
    WebElement signInLink;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
    
    }

    public void clickSignIn() {
    	
        signInLink.click();
        
    }

    public void searchForProduct(String product) {
    	
        searchBox.sendKeys(product);
        searchButton.click();
   
    }
}
