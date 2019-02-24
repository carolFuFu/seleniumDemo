package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import utils.SeleniumUtils;

import java.util.Set;

public class HomePage extends NavBarPage{
    @FindBy(css=".content img")
    WebElement banner;
    public HomePage(WebDriver driver){
        super(driver);
    }
    public void clickBanner(){
        banner.click();
        Reporter.log("点击图片",true);
    }

    public EventPage clickBannerAndReturnPage(){
        String handle1 = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Reporter.log("原窗口是" + handle1,true);
        clickBanner();
        SeleniumUtils.switchWindow(driver,5,handles);
        return new EventPage(driver);
    }
}
