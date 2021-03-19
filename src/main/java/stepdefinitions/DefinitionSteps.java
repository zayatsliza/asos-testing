package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    public final static long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    SignInPage signInPage;
    ItemsPage itemsPage;
    WishListPage wishListPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    @Then("User gets {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }
    public void openRegisterPage() {
        registerPage = pageFactoryManager.getRegisterPage();
    }

    public void openSignInPage() {
        signInPage = pageFactoryManager.getSignInPage();
    }

    public void openItemPage() {
        itemsPage = pageFactoryManager.getItemPage();
    }

    public void openWishListPage() {
        wishListPage = pageFactoryManager.getWishListPage();
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks wish list icon visibility")
    public void checkWishListIconVisibility() {
        homePage.isWishListIconVisible();
    }

    @And("User checks cart icon visibility")
    public void checkCartIconVisibility() {
        homePage.isCartIconVisible();
    }

    @And("User checks women button visibility")
    public void checkWomenButtonVisibility() {
        homePage.isWomenButtonVisible();
    }

    @And("User checks account icon visibility")
    public void checkAccountIconVisibility() {
        homePage.isAccountIconVisible();
    }

    @When("User clicks on 'Account' icon")
    @When("User clicks on 'Account' icon on home page")
    public void clickOnAccountIcon() {
        homePage.clickOnAccountIcon();
    }

    @And("User clicks on register button")
    public void clickRegisterOnHomePagePopUp(){
        homePage.clickRegisterButton();
    }

    @And("User fills in {string} field")
    public void fillInEmailAddressFieldOnRegisterPage(String emailAddress) {
        openRegisterPage();
        registerPage.enterEmail(emailAddress);
    }

    @And("User fills in first name value = {string}")
    public void fillInFirstNameFieldOnRegisterPage(String firstName) {
        registerPage.enterFirstName(firstName);
    }

    @And("User fills in last name value = {string}")
    public void fillInLastNameFieldOnRegisterPage(String lastName) {
        registerPage.enterLastName(lastName);
    }

    @And("User fills in password value = {string}")
    public void fillInPasswordFieldOnRegisterPage(String password) {
        registerPage.enterPassword(password);
    }

    @Then("User gets password error message")
    public void checkPasswordErrorMessageVisibility() {
        assertTrue(registerPage.isPasswordErrorMessageVisible());
    }

    @And("User selects day of birth")
    public void selectDayOfBirth(){
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        registerPage.selectDayOfBirth("20");
    }
    @And("User selects month of birth")
    public void selectMonthOfBirth() {
        registerPage.selectMonthOfBirth(8);
    }

    @And("User selects year of birth")
    public void selectYearOfBirth() {
        registerPage.selectYearOfBirth(1910);
    }

    @And("User selects preference of wear")
    public void selectPreferenceOfWear() {
        registerPage.clickOnGenderFemaleSelection();
    }

    @And("User clicks on 'Join Asos' button")
    public void clickOnJoinAsosButton() {
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        registerPage.clickOnRegisterButton();
    }
    @And("User sees 'Hi {string}'")
    public void checkWelcomeToSignedUpAccount(String firstName) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.getWelcomeToSignedUpAccount(firstName);
    }

    @And("User clicks on sign in button")
    public void clickOnSignInButtonOnHomePage() {
        homePage.clickSignInButton();
    }

    @And("User fills in email address = {string} field on sign in page")
    public void fillInEmailAddressFieldOnSignInPage(String emailAddress) {
        openSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.enterEmail(emailAddress);
    }

    @And("User fills in password address = {string} field on sign in page")
    public void fillInPasswordFieldOnSignInPage(String password) {
        signInPage.enterPassword(password);
    }

    @And("User clicks on 'Sign In' button")
    public void clickOnSignInButtonOnSignInPage() {
        signInPage.clickOnSignInButton();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @And("User checks register button visibility")
    public void checkRegisterButtonVisiblity() {
        homePage.isRegisterButtonVisible();
    }

    @And("User checks email field visibility")
    public void checkEmailFieldVisibility() {
        openRegisterPage();
        registerPage.isEmailFieldVisible();
    }

    @And("User checks first name and last name fields visibility")
    public void checkFirstAndLastNameFielsVisibility() {
        registerPage.isFirstNameFieldVisible();
        registerPage.isLastNameFieldVisible();
    }

    @And("User checks password field visibility")
    public void checkPasswordFieldVisibility() {
        registerPage.isPasswordFieldVisible();
    }

    @When("User makes search by {string}")
    public void searchAnItemByKeyword(String keyword) {
        assertTrue(homePage.isSearchFieldVisible());
        homePage.enterTextToSearchField(keyword);
    }

    @And("User adds to wish list first and third items")
    public void addToWishListFirstAndThirdItem() {
        openItemPage();
        itemsPage.clickWishListIconOnFirstProduct();
    }

    @And("User clicks on wish list icon")
    public void clickOnWishListIcon() {
        assertTrue(homePage.isWishListIconVisible());
        openWishListPage();
        homePage.clickOnWishListIcon();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that amount of items in wish list are {string}")
    public void checkAmountOfItemsInWishList(final String expectedAmount) {
        assertEquals(expectedAmount, wishListPage.getWishListItemAmount());
    }

    @And("User clicks at last items on a page")
    public void clickOnLastItem() {
        openItemPage();
        itemsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        itemsPage.clickOnLastItem();
    }

    @And("User selects size of item")
    public void selectItemSize() {
        itemsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        itemsPage.selectSizeItem();
    }

    @And("User adds to cart item")
    public void addItemToCart() {
        itemsPage.clickAddToBagButton();
    }

    @And("User checks that amount of items in cart are {string}")
    public void checkAmountOfItemsInCart(final String expectedAmount) {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertEquals(expectedAmount,homePage.getAmountOfItemsInCart());
    }
    @After
    public void tearDown() {
        driver.close();
    }

}
