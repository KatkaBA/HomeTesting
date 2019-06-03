package HomeTesting;

import baseHome.TestBaseHome;
import io.netty.handler.codec.sctp.SctpOutboundByteStreamHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorHomeTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74");
        driver = new ChromeDriver();
        driver.get("http://localhost:8888/gosslingator.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }



    @Test
    public void itShouldAddRyans(){
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        WebElement ryanCounter = driver.findElement(By.cssSelector("div.ryan-counter h2"));
        addRyanButton.click();
        Assert.assertEquals("1", ryanCounter.getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        addRyanButton.click();
        Assert.assertEquals("2", ryanCounter.getText());
        Assert.assertEquals("ryans", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());
        System.out.println("Number of ryans: " + ryanCounter.getText());

    }

    @Test
    public void itShouldDisplayTitle(){
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage(){
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i=0; i<50;i++) {
            addRyanButton.click();
            String actualNumberOgRyans = driver.findElement(By.id("ryanCounter")).getText();
            Assert.assertEquals(String.valueOf(i+1),actualNumberOgRyans);
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i+1==1){
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i+1>=2){
                Assert.assertEquals("ryans", actualDescription);
            }
            System.out.println("index i = " +i);
            System.out.println("pocet ryanov = " + actualNumberOgRyans);
        }
        Assert.assertEquals( "NUMBER OF\n" + "RYANS\n" + "IS TOO DAMN\n" + "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }


}
