package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventPage {
    WebDriver driver;

   public EventPage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }

   public void waitTitleContains(long time,String partTitle){
       WebDriverWait wait = new WebDriverWait(driver,time);
       wait.until(ExpectedConditions.titleContains(partTitle));
   }
}
