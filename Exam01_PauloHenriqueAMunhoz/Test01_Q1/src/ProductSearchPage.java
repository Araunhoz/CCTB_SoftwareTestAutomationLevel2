import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	
    WebDriver driver;

    @FindBy(id = "menuSearch")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@id='autoComplete']")
    WebElement searchInput;

    @FindBy(id = "menuSearch")
    WebElement searchButton;

    @FindBy(xpath = "//a[contains(@href, 'product/')]")
    WebElement firstProduct;

    public ProductSearchPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
    
    }

    public void enterSearchTerm(String term) {
    	
        searchIcon.click();
        searchInput.sendKeys(term);
        
    }

    public void clickSearchButton() {
    	
        searchButton.click();
        
    }

    public void clickFirstProduct() {
    	
        firstProduct.click();
        
    }
}
