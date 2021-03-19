package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WishListPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'itemCount')]")
    private WebElement wishListItemAmount;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public String getWishListItemAmount() {
        waitVisibilityOfElement(60,wishListItemAmount);
        return wishListItemAmount.getText();
    }
}
