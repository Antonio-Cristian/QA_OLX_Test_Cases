package Allstepdefs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IncorrectSearchOkazii {
    @Managed
    WebDriver driver;

    //The test is being done with the following Keyword:
    String txt = "5231]'ASF@%!&lxda";


    @And("I search for something that is not being sold there")
    public void searchSomethingThatIsNotBeingSold() {
        driver.findElement(By.xpath("//input[@id='terms']")).sendKeys(txt);
        driver.findElement(By.xpath("//input[@id='main-search-button']")).click();
    }

    @Then("Show the no results found message")
    public void showNoResults() {
        String ActualTxt = driver.findElement(By.xpath("//h1[@class='h1resultTitle']")).getText();
        Assert.assertTrue(ActualTxt.contains("0 rezultate") );
    }
}
