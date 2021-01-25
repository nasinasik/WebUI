package lesson6.features.expences;

import lesson6.enums.CounterPartiesSubMenuButtons;
import lesson6.pages.AllCounterPartiesPage;
import org.junit.jupiter.api.Test;
import lesson6.base.BaseUITest;
import lesson6.common.Configuration;

import lesson6.enums.NavigationBarTabs;

import lesson6.pages.LoginPage;

public class NewCounterPartiesTest extends BaseUITest {

    @Test
    public void createNewCounterPartiesPositiveTest() {
        AllCounterPartiesPage expensesScreen = (AllCounterPartiesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(CounterPartiesSubMenuButtons.CONTACT_PERSONS);

        expensesScreen
                .clickOnCreateNewContactButton()
                .enterLastName("mmm")
                .enterFirstName("mmm")
                .enterDescription("mmm")
                .clickSubmit();

    }
}
