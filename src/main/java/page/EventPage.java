package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EventPage {
    WebDriver driver;
   public EventPage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }

   public String getPageTitle(){
       return driver.getTitle();
   }
}
