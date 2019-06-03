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
        addRyan();
        Assert.assertEquals("1", getRyanCounterNumber());
        Assert.assertEquals("ryan", getCounterDescription());
        System.out.println("Number of ryans: " + getRyanCounterNumber());

    }
    @Test
    public void itShouldAddTwoRyans(){
        addRyan();
        addRyan();
        Assert.assertEquals("2", getRyanCounterNumber());
        Assert.assertEquals("ryans", getCounterDescription());
        System.out.println("Number of ryans: " + getRyanCounterNumber());
    }

    @Test
    public void itShouldDisplayTitle(){
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage(){
        for (int i=0; i<50;i++) {
            addRyan();
            Assert.assertEquals(String.valueOf(i+1),getRyanCounterNumber());
            if (i+1==1){
                Assert.assertEquals("ryan",getCounterDescription());
            }
            if (i+1>=2){
                Assert.assertEquals("ryans", getCounterDescription());
            }
            System.out.println("index i = " +i);
            System.out.println("pocet ryanov = " + getRyanCounterNumber());
        }
        Assert.assertEquals( "NUMBER OF\n" + "RYANS\n" + "IS TOO DAMN\n" + "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        int clicksLimit = 30;
        int clicks = 0;
        while (!getRyanCounterNumber().equals("50") && clicks < clicksLimit) {
            addRyan();
            clicks++;
        }

    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(0, getNumberOfRyanImages());
    }

    private void addRyan(){
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        addRyanButton.click();
    }

    private String getRyanCounterNumber(){
        return driver.findElement(By.id("ryanCounter")).getText();
    }

    private String getCounterDescription(){
        return driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    private int getNumberOfRyanImages() {
        return driver.findElements(By.cssSelector("img")).size();
    }


}
