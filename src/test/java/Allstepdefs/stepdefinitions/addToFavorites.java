package Allstepdefs.stepdefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addToFavorites {
    @Managed
    WebDriver driver;

    @Then("Click on the first product and add it to the favorite items list")
    public void clickOnTheFirstProduct() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/h2[1]/a[1]")).click();
        driver.findElement(By.xpath("//a[@id='btn_addToWatchList']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Ok, inchide')]")).click();
    }
}
