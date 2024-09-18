package stepDef;

import base.config;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class signupSteps extends config {

    Faker faker = new Faker();
    @Given("user in express Homepage")
    public void userInExpressHomepage() {

    }

    @And("user click on accept all button")
    public void userClickOnAcceptAllButton() {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    @And("user click on Account button")
    public void userClickOnAccountButton() {
        driver.findElement(By.cssSelector("svg.Aslx9l1u.svg-icon--account")).click();
    }

    @And("user clicks on {string} link")
    public void userClicksOnLink(String arg0) {
        driver.findElement(By.cssSelector("css=svg.Aslx9l1u.svg-icon--account")).click();
    }

    @And("user enter valid email address")
    public void userEnterValidEmailAddress() {
        RANDOM_EMAIL = FIRST_NAME.toLowerCase()+"."+LAST_NAME.toLowerCase()+faker.number().digits(4)+"@gmail.com";
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(RANDOM_EMAIL);
    }

    @And("user enter valid First Name")
    public void userEnterValidFirstName() {
        FIRST_NAME = faker.name().firstName().replaceAll("[^a-zA-Z0-9]", "");
        driver.findElement(By.name("firstname")).sendKeys(FIRST_NAME);
    }

    @And("user enter valid Last Name")
    public void userEnterValidLastName() {
        LAST_NAME = faker.name().lastName().replaceAll("[^a-zA-Z0-9]", "");
        driver.findElement(By.name("lastname")).sendKeys(LAST_NAME);
    }

    @And("user enter password")
    public void userEnterPassword() {
        RANDOM_PASSWORD = FIRST_NAME.toUpperCase()+LAST_NAME.toLowerCase()+faker.number().digits(5);
        driver.findElement(By.name("password")).sendKeys(RANDOM_PASSWORD);

    }

    @And("user select valid {string}")
    public void userSelectValid(String enterCountry) {
        Select c =new Select(driver.findElement(By.name("country")));
        c.selectByVisibleText(enterCountry);
    }

    @When("user click on {string} button")
    public void userClickOnButton(String arg0) {
        driver.findElement(By.xpath("//button[@class='btn VgwgDBBL i31kbSky a-YwkJU2 VKXzR']")).click();
    }


    @Then("the user should be able to signup successfully")
    public void theUserShouldBeAbleToSignupSuccessfully() {
        String expText = "WELCOME BACK";
        String developerCodeExp = driver.findElement(By.xpath("//p[@class='cOPW1']")).getText();
        Assert.assertEquals(expText, developerCodeExp);
    }



}
