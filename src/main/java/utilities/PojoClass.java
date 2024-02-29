package utilities;

import org.openqa.selenium.WebDriver;

/*
this file is used to setting and getting the drivers values
 */
public class PojoClass {
    private static WebDriver driver;

/*
getDriver() returns the driver return type of this methode is WebDriver
 */

    public static WebDriver getDriver() {
        return driver;
    }

    /*
    setDriver(WebDriver ldriver)
    setting the driver values
     */
    public static void setDriver(WebDriver ldriver) {
        driver = ldriver;
    }

}
