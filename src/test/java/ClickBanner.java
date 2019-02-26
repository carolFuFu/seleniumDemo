import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EventPage;
import page.HomePage;
import utils.DateUtils;
import utils.FileUtils;
import utils.SeleniumUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClickBanner {
    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        System.err.println("ClickBanner启动浏览器--------" + DateUtils.getTime());
        driver = new ChromeDriver();
    }

    @Test
    private void clickBannerTest() throws Exception{
        String url = FileUtils.readYmlFile(FileUtils.getPath("/config.yml"),"url");
        driver.get("https://testerhome.com/");
//        HomePage homePage = new HomePage(driver);
//        EventPage eventPage = homePage.clickBannerAndReturnPage();
//
//        String expectTitle = "大会";
//        eventPage.waitTitleContains(5,expectTitle);
        String expectTitle = FileUtils.readYmlFile(FileUtils.getPath("/clickBanner.yml"),"expectTitle");
        new HomePage(driver).clickBannerAndReturnPage().waitTitleContains(5,expectTitle);
    }

    public static String getProperty(String property)throws Exception{
        String configPath = FileUtils.getPath("/config.yml");
        String dataPath = FileUtils.getPath("/notSignIn.yml");
        Map configMap = FileUtils.readYmlFile(configPath);
        Map dataMap = FileUtils.readYmlFile(dataPath);
        Map crossMap = new HashMap();
        crossMap.putAll(configMap);
        crossMap.putAll(dataMap);

        return (String) crossMap.get(property);
    }

    public static void main(String[] args)throws Exception{
        System.err.println(getProperty( "url"));
        System.err.println(getProperty( "community"));
    }
    @AfterMethod
    private void teardown(){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(file, new File("screenshot.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
