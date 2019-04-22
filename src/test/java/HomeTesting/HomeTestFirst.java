package HomeTesting;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTestFirst {

@Test
    public void itShouldOpenNewPage() {
        System.setProperty("webdriver.chrome.driver","chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8888/kalkulacka.php");

        driver.findElement(By.id("firstInput")).sendKeys("1");

        driver.findElement(By.id("secondInput")).sendKeys("2");

        driver.findElement(By.id("count")).click();

        Assert.assertEquals("3", driver.findElement(By.id("result")).getText());

        driver.close();

        driver.quit();

    }
}
