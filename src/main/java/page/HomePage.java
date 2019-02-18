package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

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
}
