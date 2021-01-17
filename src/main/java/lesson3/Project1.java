package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

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

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[class='pull-left btn-group icons-holder']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("mmmm");


        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("mmmm");

        /*driver.findElement(By.xpath("//*[@id=\"s2id_crm_contact_company-uid-6002aeeec0922\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("12323142342134");

*/

        driver.findElement(By.xpath("//*[@id=\"s2id_crm_contact_company-uid-60032e16a60ce\"]/a")).click();
        WebElement orgTextInput = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
        orgTextInput.sendKeys("12323142342134");

        /*Select companyDropDown = new Select(driver.findElement(By.cssSelector("span[class='select2-chosen']")));
        companyDropDown.selectByVisibleText("Test Organisation_1");*/

       /* driver.findElement(By.xpath("//*[@id=\"s2id_crm_contact_company-uid-6001e3d4de43f\"]/a/span[1]")).click();*/
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("mmmm");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"crm_contact-uid-6002b2ee4efd1\"]/div[1]/div/div/div[2]/div[1]/div[4]/button")).click();




        driver.quit();
    }
}
