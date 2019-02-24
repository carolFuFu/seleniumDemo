package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends NavBarPage {
    @FindBy(css=".topic a")
    private List<WebElement> topics;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public List<String> returnTopicsTitle(){
        List<String> list = new ArrayList<String>();
        for(WebElement topic : topics){
            list.add(topic.getText().trim().toLowerCase());
        }
        return list;
    }



}
