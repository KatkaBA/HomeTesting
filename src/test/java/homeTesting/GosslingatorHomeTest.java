package homeTesting;

import baseHome.TestBaseHome;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagesHome.GosslingatorPageHome;

public class GosslingatorHomeTest extends TestBaseHome{

    private String actualNumberOfRyans;
    private String actualRyanDescription;

    private GosslingatorPageHome gossPageHome;


    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74");
        driver.get(BASE_URL + "/gosslingator.php");
        gossPageHome = new GosslingatorPageHome(driver);
    }


    @Test
    public void itShouldAddOneRyan(){
        gossPageHome.addRyan();
        Assert.assertEquals("1", gossPageHome.getRyanCounterNumber());
        Assert.assertEquals("ryan", gossPageHome.getCounterDescription());
        System.out.println("Number of ryans: " + gossPageHome.getRyanCounterNumber());

    }
    @Test
    public void itShouldAddTwoRyans(){
        gossPageHome.addRyan();
        gossPageHome.addRyan();
        Assert.assertEquals("2", gossPageHome.getRyanCounterNumber());
        Assert.assertEquals("ryans", gossPageHome.getCounterDescription());
        System.out.println("Number of ryans: " + gossPageHome.getRyanCounterNumber());
    }

    @Test
    public void itShouldDisplayTitle(){
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessage(){
        for (int i=0; i<50;i++) {
            gossPageHome.addRyan();
            Assert.assertEquals(String.valueOf(i+1), gossPageHome.getRyanCounterNumber());
            if (i+1==1){
                Assert.assertEquals("ryan", gossPageHome.getCounterDescription());
            }
            if (i+1>=2){
                Assert.assertEquals("ryans", gossPageHome.getCounterDescription());
            }
            System.out.println("index i = " +i);
            System.out.println("pocet ryanov = " + gossPageHome.getRyanCounterNumber());
        }
        Assert.assertEquals( "NUMBER OF\n" + "RYANS\n" + "IS TOO DAMN\n" + "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        int clicksLimit = 30;
        int clicks = 0;
        while (!gossPageHome.getRyanCounterNumber().equals("50") && clicks < clicksLimit) {
            gossPageHome.addRyan();
            clicks++;
        }

    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(0, gossPageHome.getNumberOfRyanImages());
    }



}
