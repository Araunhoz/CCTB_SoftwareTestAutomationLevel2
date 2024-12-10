import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public UserLoginPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    public void enterUsername(String username) {
    	
        usernameField.sendKeys(username);
        
    }

    public void enterPassword(String password) {
    	
        passwordField.sendKeys(password);
        
    }

    public void clickLoginButton() {
    	
        loginButton.click();
        
    }
}
