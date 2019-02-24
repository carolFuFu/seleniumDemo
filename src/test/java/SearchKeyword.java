import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.util.ArrayList;
import java.util.List;

public class SearchKeyword {
    WebDriver driver = null;
    @BeforeMethod
    private void setup(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    private void test() throws Exception{
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);

        String keyword = "selenium";
        String expectTopic = "seleniumMMM";
        SearchResultPage searchResultPage = homePage.gotoSearchResult(keyword);
        List<String> assertMsg = new ArrayList<String>();
        int i = 0;
        for(String topic : searchResultPage.returnTopicsTitle()) {
            System.err.println("正在校验第" + i++ + "条数据");
            if(!topic.contains(expectTopic)){
                assertMsg.add("期待的标题不包含" + expectTopic + "实际的标题是" + topic +"\r\n");
            }
        }

        if(!assertMsg.isEmpty())
        Assert.assertTrue(false,assertMsg.toString());
    }

//    public void assertTopics(String value,SearchResultPage searchResultPage){
//        String actualMsg = "";
//        for(WebElement topic : searchResultPage.topics){
//            actualMsg = topic.getText().trim();
//            Assert.assertTrue(actualMsg.toLowerCase().contains(value.toLowerCase()),"期待的标题不包含" + value + "实际的标题是" + actualMsg);
//        }
//    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
