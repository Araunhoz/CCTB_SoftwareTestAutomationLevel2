import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
	
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    WebElement addToCartButton;

    public ProductDetailPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    public void clickAddToCart() {
    	
        addToCartButton.click();
        
    }

    public boolean isAddToCartButtonDisplayed() {
    	
        return addToCartButton.isDisplayed();
        
    }
}
