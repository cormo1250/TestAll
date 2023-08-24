package io.cucumber.skeleton.AutomationStorePayment;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationStorePaymentStepDefs {

    WebDriver webDriver;
    WebDriverWait wait;
    //@Given("Open browser")
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","/Users/patryknerc/Desktop/WebDrivers/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 3);
    }
    public void iOpenLoginPageAutomationStore() {
        webDriver.get("https://automationteststore.com");
    }
    public void iClickOnAccountBaner() {
        WebElement element = webDriver.findElement(By.cssSelector("div#customernav a[href]"));
        element.click();
    }

    public void iTypeAsLoginInLoginPage(String login) {
        WebElement element = webDriver.findElement(By.cssSelector("input[name='loginname']"));
        element.sendKeys(login);
    }

    public void iTypeAsPasswordInLoginPage(String password) {
        WebElement element = webDriver.findElement(By.cssSelector("input[name='password']"));
        element.sendKeys(password);
    }

    public void iClickLoginButton() {
        WebElement element = webDriver.findElement(By.cssSelector("button[title='Login']"));
        element.click();

    }

    public void iMLoggedIn() {
        wait.until(ExpectedConditions.urlContains("account/account"));

    }



    public void iMNotLoggedIn() {
        WebElement element = webDriver.findElement(By.cssSelector("div[class='alert alert-error alert-danger']"));
        String currentelement = element.getText();
        String expected = "Error: Incorrect login or password provided.";
        Assert.assertTrue(currentelement.contains(expected));
    }


    //nowy
    @Given("I open home page of Automation Store, click ona account baner and login with correct credentials login {string} and password {string}")
    public void openHomePageAndLogIn(String login, String password) {
        webDriver.get("https://automationteststore.com");
        WebElement element = webDriver.findElement(By.cssSelector("div#customernav a[href]"));
        element.click();
        iTypeAsLoginInLoginPage(login);
        iTypeAsPasswordInLoginPage(password);
        iClickLoginButton();

    }

    @When("I go to cattegory -> Apparel & Accessories -> Shoes and click on red sandals")
    public void goToShoesRed() {
        WebElement element = webDriver.findElement(By.cssSelector("#categorymenu > nav > ul > li:nth-child(2) > a"));
        element.click();
        WebElement element2 = webDriver.findElement(By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(1) > div > a"));
        element2.click();
        WebElement element3 = webDriver.findElement(By.cssSelector("#maincontainer > div > div > div > div > div.thumbnails.grid.row.list-inline > div:nth-child(1) > div.fixed_wrapper > div > a"));
        element3.click();

    }

    @And("I choose size 4 UK, change quantity to {string}, click add to cart button, click checkout and confirm order")
    public void choseSizeConfirm(String quanity) {
        WebElement element = webDriver.findElement(By.cssSelector("#option344748"));
        element.click();
        WebElement element2 = webDriver.findElement(By.cssSelector("#product_quantity"));
        element2.clear();
        element2.sendKeys(quanity);
        WebElement element3 = webDriver.findElement(By.cssSelector("#product > fieldset > div:nth-child(6) > ul > li > a"));
        element3.click();
        WebElement element4 = webDriver.findElement(By.cssSelector("#cart_checkout1"));
        element4.click();
        WebElement element5 = webDriver.findElement(By.cssSelector("#checkout_btn"));
        element5.click();

    }

    @Then("My order has been processed")
    public void myOrderHasBeenProcessed() {
        wait.until(ExpectedConditions.urlContains("checkout/success"));

        }


    @After
    public void closeBrowser() {
        webDriver.quit();
    }

    @And("I choose size {int} UK \\(from 3, 4, 5, 6), change quantity to {string}, click add to cart button, click checkout and confirm order")
    public void chooseSizeIfOrder(int size, String quanity) {
        if (size == 3) {
            WebElement element = webDriver.findElement(By.cssSelector("#option344747"));
            element.click();
        }
        else if (size == 4) {
            WebElement element = webDriver.findElement(By.cssSelector("#option344748"));
            element.click();
        }
        else if (size == 5) {
            WebElement element = webDriver.findElement(By.cssSelector("#option344749"));
            element.click();
        }
        else if (size == 6) {
            WebElement element = webDriver.findElement(By.cssSelector("#option344750"));
            element.click();
        }else{
            System.out.println("podana liczba nie zawiera sie w przedziale dostepnych produktow");
        }
        WebElement element2 = webDriver.findElement(By.cssSelector("#product_quantity"));
        element2.clear();
        element2.sendKeys(quanity);
        WebElement element3 = webDriver.findElement(By.cssSelector("#product > fieldset > div:nth-child(6) > ul > li > a"));
        element3.click();
        WebElement element4 = webDriver.findElement(By.cssSelector("#cart_checkout1"));
        element4.click();
        WebElement element5 = webDriver.findElement(By.cssSelector("#checkout_btn"));
        element5.click();
    }

}
