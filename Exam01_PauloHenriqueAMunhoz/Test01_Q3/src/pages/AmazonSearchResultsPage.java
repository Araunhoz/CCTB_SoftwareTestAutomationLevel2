package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchResultsPage {
	
    WebDriver driver;
	public WebElement someElementOnSearchResultsPage;

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }
}
