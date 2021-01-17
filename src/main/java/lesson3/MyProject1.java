package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyProject1 {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://www.keshet-teamim.co.il/";
    private static final String M_LOGIN = "nasinasik@gmail.com";
    private static final String M_PASSWORD = "nasinasik1";
    private static final String AREA = "פתח תקווה";


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/header/div[2]/span[2]/span[10]/button")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement loginTextInput = driver.findElement(By.name("email"));
        loginTextInput.sendKeys(M_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.name("password"));
        passwordTextInput.sendKeys(M_PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"sp_tab_pane_0\"]/ng-include/ng-switch/form/button[1]")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.findElement(By.cssSelector("span[class='language']")).click();

        //driver.findElement(By.xpath("/html/body/header/div[2]/span[2]/span[8]/sp-dropdown/ul/li[2]/label/span/span")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/header/div[3]/ul/li[7]")).click();

       driver.findElement(By.xpath("/html/body/header/div[3]/ul/li[7]/div[2]/div[2]/ul[1]/a")).click();

        driver.findElement(By.xpath("/html/body/section/section/div/div/sp-items/div[3]/div[1]/div[3]/div/sp-product/span")).click();

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[2]")).click();

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/button[2]")).click();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*WebElement areaTextInput = driver.findElement(By.xpath("//*[@id=\"filter-areas-input\"]"));
        areaTextInput.sendKeys(AREA);
       driver.findElement(By.xpath("//*[@id="filter-areas-input"]")).sendKeys("פתח תקווה");*/

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/button")).click();

        driver.quit();

    }
}
