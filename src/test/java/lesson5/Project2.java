package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Project2 {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String S_LOGIN = "Applanatest";
    private static final String S_PASSWORD = "Student2020!";
    private JavascriptExecutor jsExecutor;


    @BeforeAll
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }

    @Test
    public void openSite() {
        login();
    }

    private void login() {
        driver.get(LOGIN_PAGE_URL);
        WebElement loginTextInput = driver.findElement(By.cssSelector(".span2[name='_username']"));
        loginTextInput.sendKeys(S_LOGIN);

        ArrayList<WebElement> elements = (ArrayList<WebElement>) jsExecutor.executeScript("return document.getElementsByName('_password')");

        WebElement passwordTextInput = elements.get(0);
        passwordTextInput.sendKeys(S_PASSWORD);


        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/ul/li[4]/a/span")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div/div/div[2]/div/div")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("crm_project[name]")).sendKeys("mmmm");

        //organizazia
        /*driver.findElement(By.xpath("//*[@id=\"crm_project_company-uid-600323b949c23\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li[1]/div")).click();*/

//podrazdelenie
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByValue("1");
//kurator
        Select curatorDropDown = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorDropDown.selectByValue("114");
//rukovod
        Select rpDropDown = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpDropDown.selectByValue("114");
//manager
        Select managerDropDown = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerDropDown.selectByValue("114");

//soxranit i zakrit
       /* driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"crm_project-uid-600323b9ab1da\"]/div[1]/div/div/div[2]/div[1]/div[4]/button")).click();
*/
        driver.quit();


    }
}
