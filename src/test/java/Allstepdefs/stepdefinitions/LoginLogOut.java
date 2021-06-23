package Allstepdefs.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginLogOut {
    @Managed
    WebDriver driver;

    @And("I access the login page")
    public void accesLoginPage() {
        driver.findElement(By.xpath("//span[@class='orange d-inline b']")).click();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "OKazii.ro: Intra in cont pentru vanzari si licitatii online";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @And("I enter correct credentials")
    public void enterCorrectCredentials() {
        driver.findElement(By.xpath("//input[@id='login_input']")).sendKeys("puscamusca@yahoo.com");
        driver.findElement(By.xpath("//input[@id='login_pass']")).sendKeys("PlaceholderPassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Show my account page")
    public void accountPage() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Okazii.ro: Contul meu";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @And("I'm logged in")
    public void iMLoggedIn() {
        WebElement ele = driver.findElement(By.xpath("//a[@id='login-trigger']"));
        Actions act = new Actions(driver);
        act.moveToElement(ele).perform();
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }

    @Then("Logout")
    public void logout() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Okazii.ro: Contul meu";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @And("I enter wrong credentials")
    public void iEnterWrongCredentials() {
        driver.findElement(By.xpath("//input[@id='login_input']")).sendKeys("puscamusca@yahoo.com");
        driver.findElement(By.xpath("//input[@id='login_pass']")).sendKeys("WrongPlaceholderPassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Show error message")
    public void showErrorMessage() {
        boolean result = driver.findElement(By.xpath("//p[contains(text(),'Autentificare esuata!')]")).isDisplayed();
    }
}

