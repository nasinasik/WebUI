package lesson6.enums;

import lesson6.base.SubMenuButtons;
import org.openqa.selenium.By;


public enum CounterPartiesSubMenuButtons implements SubMenuButtons {

    CONTACT_PERSONS("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[4]/a/span");


    private final By by;

    CounterPartiesSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
