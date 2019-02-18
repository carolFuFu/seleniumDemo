package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NavBarPage {
    WebDriver driver;
    @FindBy(tagName = "input1")
    WebElement searchWebElement;

    public NavBarPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchKeyWord(String value){
        searchWebElement = driver.findElements(By.tagName("input1")).get(0);
        searchWebElement.clear();
        searchWebElement.sendKeys(value);
        Reporter.log("搜索关键词-" + value,true);
    }

    public SearchResultPage gotoSearchResult(String value){
        searchKeyWord(value);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        return new SearchResultPage(driver);
    }
}
