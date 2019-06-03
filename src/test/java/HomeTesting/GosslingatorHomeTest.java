package HomeTesting;

import baseHome.TestBaseHome;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GosslingatorHomeTest extends TestBaseHome{

    private String actualNumberOfRyans;
    private String actualRyanDescription;


    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74");
        driver.get(BASE_URL + "/gosslingator.php");
    }


    @Test
    public void itShouldAddOneRyan(){
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
        Assert.assertEquals("1", actualNumberOfRyans);
        Assert.assertEquals("ryan", actualRyanDescription);
        System.out.println("Number of ryans: " + actualNumberOfRyans);

    }
    @Test
    public void itShouldAddTwoRyans(){
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
        addRyanButton.click();
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
        Assert.assertEquals("2", actualNumberOfRyans);
        Assert.assertEquals("ryans", actualRyanDescription);
        System.out.println("Number of ryans: " + actualNumberOfRyans);
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
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            Assert.assertEquals(String.valueOf(i+1),actualNumberOfRyans);
            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i+1==1){
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i+1>=2){
                Assert.assertEquals("ryans", actualDescription);
            }
            System.out.println("index i = " +i);
            System.out.println("pocet ryanov = " + actualNumberOfRyans);
        }
        Assert.assertEquals( "NUMBER OF\n" + "RYANS\n" + "IS TOO DAMN\n" + "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        int clicksLimit = 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50") && clicks < clicksLimit) {
            addRyanButton.click();
            actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            clicks++;
        }

    }
}
