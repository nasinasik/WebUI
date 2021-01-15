package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class Project1 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String S_LOGIN = "Applanatest";
    private static final String S_PASSWORD = "Student2020!";


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();

        WebElement loginTextInput = driver.findElement(By.cssSelector(".span2[name='_username']"));
        loginTextInput.sendKeys(S_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(S_PASSWORD);

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/ul/li[4]/a/span")).click();

        sleep(5000);
        driver.findElement(By.cssSelector("div[class='pull-left btn-group icons-holder']")).click();

        sleep(2000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("mmmm");


        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("mmmm");

        Select companyDropDown = new Select(driver.findElement(By.cssSelector("span[class='select2-chosen']")));
        companyDropDown.selectByVisibleText("Test Organisation_1");


        // driver.quit();
    }
}
