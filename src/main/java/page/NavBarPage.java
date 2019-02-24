package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

public class NavBarPage {
    WebDriver driver;
    WebDriverWait wait;
    long time = 30;

    @FindBy(tagName = "input")
    WebElement searchWebElement;

    @FindBy(css="#main-nav-menu .nav li")
    List<WebElement> navList;

    public NavBarPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,time);
        PageFactory.initElements(driver,this);
    }

    public void searchKeyWord(String value){
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

    public boolean clickNavByText(String menu){
        for(WebElement e:navList){
            if(e.getText().trim().equalsIgnoreCase(menu)){
                e.click();
                return true;
            }
        }
        return false;
    }
}
