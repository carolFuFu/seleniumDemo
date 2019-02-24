import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EventPage;
import page.HomePage;
import utils.SeleniumUtils;

import java.util.Date;
import java.util.Set;

public class ClickBanner {
    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        driver = new ChromeDriver();
    }

    @Test
    private void test() throws Exception{
        driver.get("https://testerhome.com/");
//        HomePage homePage = new HomePage(driver);
//        EventPage eventPage = homePage.clickBannerAndReturnPage();
//
//        String expectTitle = "大会";
//        eventPage.waitTitleContains(5,expectTitle);
        String expectTitle = "大会";
        new HomePage(driver).clickBannerAndReturnPage().waitTitleContains(5,expectTitle);
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }
}
