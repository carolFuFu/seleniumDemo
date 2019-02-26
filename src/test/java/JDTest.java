import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class JDTest {
    @Test
    public void JDTest()throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jd.com/");
        List<WebElement> nav = driver.findElements(By.cssSelector(".J_cate li a"));
        WebElement dq =  nav.get(0);

        Actions actions = new Actions(driver);
//        actions.moveToElement(dq).perform();
        actions.clickAndHold(dq).perform();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.id("J_popCtn")));
        WebElement jdg = driver.findElements(By.cssSelector("#J_popCtn a")).get(0);
        jdg.click();
        Thread.sleep(5000);
    }
}
