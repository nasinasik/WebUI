package lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import lesson6.base.BaseView;

public class NewCounterPartiesPage extends BaseView {

    @FindBy(name = "crm_contact[lastName]")
    private WebElement lastNameInput;

    @FindBy(name = "crm_contact[firstName]")
    private WebElement firstNameInput;

    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement contactInput;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    public NewCounterPartiesPage(WebDriver driver) {
        super(driver);
    }

    public NewCounterPartiesPage enterLastName(String description) {
        lastNameInput.sendKeys(description);
        return this;
    }

    public NewCounterPartiesPage enterFirstName(String description) {
        firstNameInput.sendKeys(description);
        return this;
    }

    public NewCounterPartiesPage enterDescription(String description) {
        contactInput.sendKeys(description);
        return this;
    }


   public AllCounterPartiesPage clickSubmit() {
        submitButton.click();
        return new AllCounterPartiesPage(driver);
    }




}
