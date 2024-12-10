package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {
	
    WebDriver driver;

    @FindBy(id = "ap_email")
	public
    WebElement emailField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "ap_password")
	public
    WebElement passwordField;

    @FindBy(id = "signInSubmit")
    WebElement signInButton;

    public AmazonLoginPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    public void enterEmail(String email) {
    	
        emailField.sendKeys(email);
        continueButton.click();
        
    }

    public void enterPassword(String password) {
    	
        passwordField.sendKeys(password);
        signInButton.click();
        
    }
}
