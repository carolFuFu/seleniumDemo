package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {
    @FindBy(css=".alert")
    WebElement alertMsg;

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String getAlertMsg(){
        return alertMsg.getText().trim();
    }
}
