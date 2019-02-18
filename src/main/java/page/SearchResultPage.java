package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends NavBarPage {
    @FindBy(css=".topic a")
   public List<WebElement> topics;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> returnTopics(){
        return topics;
    }

    public List<String> getTitles(String keyword){
        ArrayList<String> arrayList=new ArrayList<String>();
        for(WebElement topic : returnTopics()){
            String actualMsg = topic.getText().trim();
            arrayList.add(actualMsg);

        }
        return arrayList;
    }



}
