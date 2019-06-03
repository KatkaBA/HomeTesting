package baseHome;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseHome {
    protected WebDriver driver;
    protected final String BASE_URL = "http://localhost:8888";

   @Before
    public void setUp(){
       System.setProperty("webdriver.chrome.driver", "chromedriver74");
       driver = new ChromeDriver();
    }

    @After
    public void testDown(){
       driver.close();
       driver.quit();
    }
}
