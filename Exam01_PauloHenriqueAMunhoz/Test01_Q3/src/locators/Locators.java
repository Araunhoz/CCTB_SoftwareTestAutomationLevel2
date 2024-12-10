package locators;

import org.openqa.selenium.By;

public class Locators {
    // AmazonHomePage Locators
    public static final By SIGN_IN_LINK = By.id("nav-link-accountList");
    public static final By SEARCH_BOX = By.id("twotabsearchtextbox");
    public static final By SEARCH_BUTTON = By.id("nav-search-submit-button");

    // AmazonLoginPage Locators
    public static final By EMAIL_FIELD = By.id("ap_email");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By PASSWORD_FIELD = By.id("ap_password");
    public static final By SIGN_IN_BUTTON = By.id("signInSubmit");
}
