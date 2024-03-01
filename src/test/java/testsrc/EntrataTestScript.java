package testsrc;

import com.entrata.locators.EntrataLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.*;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EntrataTestScript extends PojoClass {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        EntrataTestScript.setDriver(new ChromeDriver());
        driver = EntrataTestScript.getDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public static void stratApplication() {
        driver.get(ReadPropertiesFile.readPropertyFile("URL"));
        EntrataTestScript.acceptCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String Expected = "https://www.entrata.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, Expected);
    }

    /*
     Form Interaction and Navigate back to Home URL without submitting the form.
      */
    @Test(priority = 1)
    public static void formInteraction() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        EntrataLocators el = new EntrataLocators(driver);
        el.clickWatchDemo();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        el.setFirstName("Sonali");
        el.setlasttName("test");
        el.setemail("abc@test.com");
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("mktoButton"))));
        el.selectUnitCountByValue("1 - 10");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(300,1000);");
        driver.navigate().back();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Property Management Software | Entrata");
        Assert.assertTrue(verifyTitle);
    }

    @Test(priority = 2)
    public static void windowsInteraction() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        EntrataLocators el = new EntrataLocators(driver);
        String originalWindow = driver.getWindowHandle(); ////Store original window
        String orignalWinowTitle = driver.getTitle(); //before Switch
        assert driver.getWindowHandles().size() == 1; //Check we don't have other windows open already
        el.clickBaseCamp(); // open New Window
        Set<String> handles = driver.getWindowHandles();
        System.out.println("" + handles);
        //Loop through until we find a new window handle
        for (String handle : handles) {
            if (!driver.equals(originalWindow)) // check its not orifinal window
            {
                driver.switchTo().window(handle); // switch to child window
            }
        }
        wait.until(ExpectedConditions.titleIs("Base Camp 2024 | Entrata"));
        System.out.println("Driver Current Window (Child): " + driver.getTitle());
        Assert.assertFalse(false);
        driver.close();
        driver.switchTo().window(originalWindow); // switch to default window
        System.out.println("Driver Current Window (Child): " + driver.getTitle());

        Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Property Management Software | Entrata");
        Assert.assertTrue(verifyTitle);
    }



   @AfterClass
    public static void tearDown()
    {
        driver.close();
    }


}
