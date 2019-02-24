package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

public class HogwartsPage {
    @FindBy(css = ".media-body .media-heading a")
    List<WebElement> topicsElement;

    public HogwartsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        new WebDriverWait(driver,30).until(ExpectedConditions.titleIs("TesterHome"));
    }

    public void clickFirstTopic(){
        Reporter.log("一共 " + topicsElement.size(),true);
        topicsElement.get(0).click();
        Reporter.log("点击了第一个标题",true);
    }
}
