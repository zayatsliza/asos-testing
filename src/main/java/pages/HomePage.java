package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(xpath = "//input[@type = 'search']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@data-testid = 'miniBagIcon']")
    private WebElement cartIcon;

    @FindBy(xpath = "//a[@data-testid = 'savedItemsIcon']")
    private WebElement wishListIcon;

    @FindBy(xpath = "//button[@data-testid = 'myAccountIcon']")
    private WebElement accountIcon;

    @FindBy(xpath = "//div[@data-testid='header']")
    private WebElement header;

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womenButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']//span[contains(text(),'Hi')]")
    private WebElement welcomeText;

    @FindBy(xpath = "//span[@type='bagFilled']/following-sibling::span")
    private WebElement cartItems;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isSignInButtonVisible() { signInButton.isDisplayed();}

    public void isRegisterButtonVisible() { registerButton.isDisplayed();}

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public void isAccountIconVisible() {
        accountIcon.isDisplayed();
    }

    public boolean isWishListIconVisible() {
        return wishListIcon.isDisplayed();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public void isWomenButtonVisible() {
        womenButton.isDisplayed();
    }

    public void clickOnAccountIcon() {
        accountIcon.click();
    }

    public void clickOnWishListIcon() {
        wishListIcon.click();
    }

    public void clickRegisterButton() {
        waitVisibilityOfElement(60,registerButton);
        registerButton.click();
    }

    public void clickSignInButton() {
        waitVisibilityOfElement(60,signInButton);
        signInButton.click();
    }

    public void getWelcomeToSignedUpAccount(String firstName) {
        waitVisibilityOfElement(60,welcomeText);
        String welcome = welcomeText.getText();
        Assert.assertEquals("Hi "+ firstName +"",welcome);
    }

    public void enterTextToSearchField(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword,Keys.ENTER);
    }

    public String getAmountOfItemsInCart() {
        waitVisibilityOfElement(120,cartItems);
        return cartItems.getText();
    }
}
