package seleniumUitls;

import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    public void switchToWindow(String title, WebDriver driver) {
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(title)){
               break;
            }
        }
    }
}
