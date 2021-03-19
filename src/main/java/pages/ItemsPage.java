package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemsPage extends BasePage {

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> addToWishListIcon;

    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> searchedItems;

    @FindBy(xpath = "//span[text()='Add to bag']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//select[@data-id='sizeSelect']//option")
    private List<WebElement> rangeOfSize;

    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishListIconOnFirstProduct() {
        actions.moveToElement(addToWishListIcon.get(0));
        addToWishListIcon.get(0).click();
        addToWishListIcon.get(2).click();
    }

    public void clickOnLastItem() {
        actions.moveToElement(searchedItems.get(searchedItems.size() - 1));
        searchedItems.get(searchedItems.size() - 1).click();
    }

    public void selectSizeItem() {
        rangeOfSize.get(10).click();
    }

    public void clickAddToBagButton() {
        addToCartButton.click();
    }

}
