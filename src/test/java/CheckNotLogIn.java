import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CommunityPage;
import page.HogwartsPage;
import page.HomePage;
import page.SignInPage;
import utils.DateUtils;

public class CheckNotLogIn {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        //启动chrome浏览器
        System.err.println("CheckNotLogIn-------------" + DateUtils.getTime());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test()throws Exception{
        //在浏览器中键入网址
        driver.get("https://testerhome.com/");
        HomePage homePage = new HomePage(driver);
        homePage.clickNavByText("社团");

        CommunityPage communityPage = new CommunityPage(driver);
        //此处打印的仍然是home page呀
        communityPage.clickTeam("霍格沃兹测试学院");

        HogwartsPage hogwartsPage = new HogwartsPage(driver);
        hogwartsPage.clickFirstTopic();


        SignInPage signInPage = new SignInPage(driver);
        String alert = signInPage.getAlertMsg();
        Assert.assertTrue(alert.contains("权限"),"期望信息包含，实际信息是" + alert);
    }
    @AfterMethod
    public void teardown(){
        //启动chrome浏览器
        driver.quit();
    }
}
