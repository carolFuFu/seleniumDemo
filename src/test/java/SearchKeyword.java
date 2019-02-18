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
        SearchResultPage searchResultPage = homePage.gotoSearchResult(keyword);
//        assertTopics(keyword,searchResultPage);
        String actualMsg = "";
        for(WebElement topic : searchResultPage.returnTopics()) {
            actualMsg = topic.getText().trim();
            Assert.assertTrue(actualMsg.toLowerCase().contains(keyword), "期待的标题不包含" + keyword + "实际的标题是" + actualMsg);
        }
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
