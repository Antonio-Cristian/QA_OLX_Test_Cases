package Allstepdefs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchOkazii {
    @Managed
    WebDriver driver;

    //The test is being done with the following Keyword (it needs to be uppercase):
    String text = "Bomboane";

    @When("I access Okazii.ro")
    public void accessOkazii() {
        driver.get("https://www.okazii.ro/");
        String ActualTitle = driver.getTitle();
        driver.findElement(By.xpath("//button[contains(text(),'De acord')]")).click();
        String ExpectedTitle = "Okazii.ro: cele mai bune oferte (magazine si vanzatori profesionisti)";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @And("I search for something that is being sold there")
    public void searchSomethingThatIsBeingSold() {
        driver.findElement(By.xpath("//input[@id='terms']")).sendKeys(text);
        driver.findElement(By.xpath("//input[@id='main-search-button']")).click();
    }

    @Then("Show all the results for that product")
    public void showResults() {
        String ActualText = driver.findElement(By.xpath("//h1[@class='h1resultTitle']")).getText();
        String ExpectedText = text;
        Assert.assertEquals(ActualText, ExpectedText);
    }
}