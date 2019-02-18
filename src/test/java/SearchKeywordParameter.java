import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

public class SearchKeywordParameter {
    WebDriver driver = null;
    @BeforeMethod
    private void setup(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] o = {{"selenium"},{"testng"}};
        return o;
    }

    @Test(dataProvider = "getData")
    private void test(String value) throws Exception{
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);

        SearchResultPage searchResultPage = homePage.gotoSearchResult(value);
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
