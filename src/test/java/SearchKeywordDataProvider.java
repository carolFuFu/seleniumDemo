import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.io.FileReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchKeywordDataProvider {
    WebDriver driver = null;
    @BeforeMethod
    private void setup(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @DataProvider
    public Iterator<Object[]> getData() throws Exception {
        String filePath = SearchKeywordDataProvider.class.getResource("/searchWords.csv").getPath();
        filePath = URLDecoder.decode(filePath,"utf-8");
        return readCsvFile(filePath);
    }

    @Test(dataProvider = "getData")
    private void test(String value) throws Exception{
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);

        SearchResultPage searchResultPage = homePage.gotoSearchResult(value);
    }

    public Iterator<Object[]> readCsvFile(String filePath) throws Exception {
        List<Object[]> dataArray = new ArrayList<Object[]>();
        Reader in = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for(CSVRecord record:records){
            List<Object> rowList = new ArrayList();
            Iterator i = record.iterator();
            while(i.hasNext()){
                rowList.add(i.next());
            }
            Object[] rowArray = rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
