import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;
import utils.DateUtils;
import utils.FileUtils;

import java.net.URLDecoder;
import java.util.Iterator;

public class SearchKeywordDataProvider {
    WebDriver driver = null;
    String url = "";
    @BeforeMethod
    private void setup(){
        System.err.println("SearchKeywordDataProvider------------" + DateUtils.getTime());
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        try {
            url = FileUtils.readYmlFile(FileUtils.getPath("/config.yml"), "url");
        }catch(Exception e){

        }
    }

    @DataProvider
    public Iterator<Object[]> getData() throws Exception {
        String filePath = SearchKeywordDataProvider.class.getResource("/searchWords.csv").getPath();
        filePath = URLDecoder.decode(filePath,"utf-8");
        return FileUtils.readCsvFile(filePath);
    }

    @Test(dataProvider = "getData")
    private void test(String value) throws Exception{
        driver.get(url);
        HomePage homePage = new HomePage(driver);

        SearchResultPage searchResultPage = homePage.gotoSearchResult(value);
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
