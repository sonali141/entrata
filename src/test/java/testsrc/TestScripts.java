package testsrc;

import com.entrata.locators.EntrataLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestScripts {

  public static WebDriver driver;
    @Test(priority = 1)
    public static void formInteraction()
    {
    /*    WebElement watchDemo  = driver.findElement(By.xpath("//div[@class='main-header-grid']//a[@class='button-default solid-dark-button']"));
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      watchDemo.click();
*/    EntrataLocators el = new EntrataLocators(driver);
el.clickWatchDemo();




    }
}
