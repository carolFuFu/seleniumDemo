package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommunityPage extends NavBarPage{
    @FindBy(css="#hot_teams .row div.media-body a")
    List<WebElement> teamList;

    public CommunityPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
//        wait.until(ExpectedConditions.titleContains("社团"));
    }

    public void clickTeam(String menu){
        for(WebElement menuElement:teamList){
            if(menuElement.getText().equals(menu)){
                menuElement.click();
                System.err.println("点击了" + menu);
                break;
            }
        }
    }
}
