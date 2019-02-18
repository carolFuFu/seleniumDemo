import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EventPage;
import page.HomePage;

public class ClickBanner {
    WebDriver driver = null;
    @BeforeMethod
    private void setup(){
        driver = new ChromeDriver();
    }

    @Test
    private void test() throws Exception{
        driver.get("https://testerhome.com/");

        HomePage homePage = new HomePage(driver);
        String handle1 = driver.getWindowHandle();
        Reporter.log("原窗口是" + handle1,true);
        homePage.clickBanner();

        WebDriverWait wait = new WebDriverWait(driver,2000);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for(String handle:driver.getWindowHandles()){
            if(!handle.equalsIgnoreCase(handle1)){
                driver.switchTo().window(handle);
                Reporter.log("切换到窗口" + handle,true);
            }

        }
        String expectTitle = "大会";
        wait.until(ExpectedConditions.titleContains(expectTitle));
//        Thread.sleep(5000);
    }

    @AfterMethod
    private void teardown(){
//        driver.quit();
    }
}
