package lesson6.views;
import lesson6.pages.AllCounterPartiesPage;
import org.openqa.selenium.WebDriver;
import lesson6.base.BaseView;
import lesson6.base.SubMenu;
import lesson6.base.SubMenuButtons;
import lesson6.enums.CounterPartiesSubMenuButtons;



public class CounterPartiesSubMenu extends SubMenu {

    public CounterPartiesSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof CounterPartiesSubMenuButtons) {
            switch ((CounterPartiesSubMenuButtons) buttons) {
                case CONTACT_PERSONS:
                    driver.findElement(((CounterPartiesSubMenuButtons) buttons).getBy()).click();
                    return new AllCounterPartiesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
