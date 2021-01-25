package lesson6.features.expences;

import lesson6.enums.CounterPartiesSubMenuButtons;
import lesson6.pages.AllCounterPartiesPage;
import org.junit.jupiter.api.Test;
import lesson6.base.BaseUITest;
import lesson6.common.Configuration;
import lesson6.enums.ExpenseSubMenuButtons;
import lesson6.enums.NavigationBarTabs;
import lesson6.pages.AllExpensesPage;
import lesson6.pages.LoginPage;

public class NewExpensesTest extends BaseUITest {

      @Test
    public void createNewExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();
    }
}

