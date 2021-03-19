package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;


public class RegisterPage extends BasePage {
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id= 'FirstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id= 'LastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id= 'Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class = 'tickbox-container subfield qa-gender-female selected']")
    private WebElement genderFemaleSelection;

    @FindBy(xpath = "//input[@id= 'register']")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorMessage;

    Actions actions = new Actions(driver);

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void isEmailFieldVisible() {
        emailField.isDisplayed();
    }

    public void isFirstNameFieldVisible() {
        firstNameField.isDisplayed();
    }

    public void isLastNameFieldVisible() {
        lastNameField.isDisplayed();
    }

    public void isPasswordFieldVisible() {
        passwordField.isDisplayed();
    }

    public boolean isPasswordErrorMessageVisible() {
        return passwordErrorMessage.isDisplayed();
    }

    public void clickOnGenderFemaleSelection() {
        genderFemaleSelection.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password, Keys.ENTER);
    }

    public void selectDayOfBirth(String day) {
        WebElement neededDay = driver.findElement(By.xpath("//select[@id='BirthDay']/option[@value='"+day+"']"));
        actions.moveToElement(neededDay);
        neededDay.click();
    }

    public void selectMonthOfBirth(Integer month) {
        WebElement neededMonth = driver.findElement(By.xpath("//select[@id='BirthMonth']/option[@value='"+month+"']"));
        actions.moveToElement(neededMonth);
        neededMonth.click();
    }

    public void selectYearOfBirth(Integer year) {
        WebElement neededYear = driver.findElement(By.xpath("//select[@id='BirthYear']/option[@value='"+year+"']"));
        actions.moveToElement(neededYear);
        neededYear.click();
    }
}
