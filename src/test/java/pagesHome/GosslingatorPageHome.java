package pagesHome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GosslingatorPageHome {

    private WebDriver pagedriver;
    public GosslingatorPageHome(WebDriver driver){
        this.pagedriver = driver;
        PageFactory.initElements(pagedriver, this);
    }


    public void addRyan(){
        WebElement addRyanButton = pagedriver.findElement(By.id("addRyan"));
        addRyanButton.click();
    }

    public String getRyanCounterNumber(){
        return pagedriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription(){
        return pagedriver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    public int getNumberOfRyanImages() {
        return pagedriver.findElements(By.cssSelector("img")).size();
    }


}
