package lesson6.pages;
import lesson6.base.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AllCounterPartiesPage extends BaseView {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewContactButton;

    public AllCounterPartiesPage(WebDriver driver) {
        super(driver);
    }

    public NewCounterPartiesPage clickOnCreateNewContactButton() {
        createNewContactButton.click();
        return new NewCounterPartiesPage(driver);
    }
    public AllCounterPartiesPage checkNewExpensePopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Контакт сохранен"));
        return this;
    }


}
