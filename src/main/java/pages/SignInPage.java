package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id= 'EmailAddress']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@id= 'Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id= 'signin']")
    private WebElement signInButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void enterEmail(String email) {
        emailAddressField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
}
