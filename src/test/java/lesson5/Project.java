package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Project {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String S_LOGIN = "Applanatest";
    private static final String S_PASSWORD = "Student2020!";


    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        setupWebDriverSession();
        login();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }


        @Test
        public void createNewTest () {

            By btnLocator = By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span");
            Actions actions = new Actions(driver);
            WebElement menuBtn = driver.findElement(btnLocator);
            actions.moveToElement(menuBtn);

            WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[4]/a/span"));
            actions.moveToElement(subMenu);
            actions.click().build().perform();


            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div/a")).click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.name("crm_contact[lastName]")).sendKeys("mmmm");

            driver.findElement(By.name("crm_contact[firstName]")).sendKeys("mmmm");





        /*driver.findElement(By.xpath("//*[@id=\"s2id_crm_contact_company-uid-6002aeeec0922\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("12323142342134");



        driver.findElement(By.xpath("//*[@id=\"s2id_crm_contact_company-uid-60032e16a60ce\"]/a")).click();
        WebElement orgTextInput = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
        orgTextInput.sendKeys("12323142342134");*/

        /*Select companyDropDown = new Select(driver.findElement(By.cssSelector("span[class='select2-chosen']")));
        companyDropDown.selectByVisibleText("Test Organisation_1");*/

            /* driver.findElement(By.xpath("//*[@id=\"s2id_crm_contact_company-uid-6001e3d4de43f\"]/a/span[1]")).click();*/
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //driver.findElement(By.cssSelector("#s2id_crm_project_company-uid-60071015f1460 > a > span.select2-chosen")).click();
            driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("mmmm");

           /* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"crm_contact-uid-6002b2ee4efd1\"]/div[1]/div/div/div[2]/div[1]/div[4]/button")).click();
*/

        }

        private void login () {
            driver.get(LOGIN_PAGE_URL);

            WebElement loginTextInput = driver.findElement(By.cssSelector(".span2[name='_username']"));
            loginTextInput.sendKeys(S_LOGIN);

            WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
            passwordTextInput.sendKeys(S_PASSWORD);

            WebElement loginButton = driver.findElement(By.name("_submit"));
            loginButton.click();

        }

        private void setupWebDriverSession () {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
    }



