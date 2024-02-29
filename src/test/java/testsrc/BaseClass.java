package testsrc;


import com.entrata.locators.EntrataLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilities.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass extends PojoClass {
  static   WebDriver driver;
//    static FluentWait wait = new FluentWait(driver);

  @BeforeSuite
    public  static  void setUp()
    {
        WebDriverManager.chromedriver().setup();
        BaseClass.setDriver(new ChromeDriver());
        driver = BaseClass.getDriver();
       driver.manage().window().maximize();

    }

    @Test(priority = 0)
    public  static  void stratApplication()
    {
        driver.get(ReadPropertiesFile.readPropertyFile("URL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public static void formInteraction()
    {
      EntrataLocators el = new EntrataLocators(driver);
      el.clickWatchDemo();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      el.setFirstName("Sonali");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      el.setlasttName("test");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        wait.withTimeout(Duration.ofSeconds(5));
      el.setemail("abc@test.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        wait.withTimeout(Duration.ofSeconds(5));
      el.setPhone("5545464688");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
///      wait.withTimeout(Duration.ofSeconds(5));

  el.selectUnitCount();
    }

/*    @AfterSuite
    public static void tearDown()
    {
        driver.close();
    } */

//    public static void main(String[] args) {
//        setUp();
//        stratApplication();
//    }

}
