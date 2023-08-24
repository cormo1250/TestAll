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
public class AutomationStoreStepDef {

    WebDriver webDriver;
    WebDriverWait wait;
    //@Given("Open browser")
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","/Users/patryknerc/Desktop/WebDrivers/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 3);
    }

    @Given("I open home page of Automation Store")
    public void iOpenLoginPageAutomationStore() {
        webDriver.get("https://automationteststore.com");
    }

    @When("I click on account baner")
    public void iClickOnAccountBaner() {
        WebElement element = webDriver.findElement(By.cssSelector("div#customernav a[href]"));
        element.click();
    }

    @And("I type {string} as login in login page")
    public void iTypeAsLoginInLoginPage(String login) {
        WebElement element = webDriver.findElement(By.cssSelector("input[name='loginname']"));
        element.sendKeys(login);
    }

    @And("I type {string} as password in login page")
    public void iTypeAsPasswordInLoginPage(String password) {
        WebElement element = webDriver.findElement(By.cssSelector("input[name='password']"));
        element.sendKeys(password);
    }

    @And("i click Login button")
    public void iClickLoginButton() {
        WebElement element = webDriver.findElement(By.cssSelector("button[title='Login']"));
        element.click();

    }

    @Then("I'm logged in")
    public void iMLoggedIn() {
        wait.until(ExpectedConditions.urlContains("account/account"));
    }

    @After
    public void closeBrowser() {
        webDriver.quit();
    }


    @Then("I'm not logged in")
    public void iMNotLoggedIn() {
        WebElement element = webDriver.findElement(By.cssSelector("div[class='alert alert-error alert-danger']"));
        String currentelement = element.getText();
        String expected = "Error: Incorrect login or password provided.";
        Assert.assertTrue(currentelement.contains(expected));
    }

    @When("I type {string} as login, {string} as password in login page and click login button")
    public void loginPassswordLog(String login, String password) {
        iTypeAsLoginInLoginPage(login);
        iTypeAsPasswordInLoginPage(password);
        iClickLoginButton();
    }

    @Given("I open home page of Automation Store and click on account baner")
    public void openHpAndAccount() {
    iOpenLoginPageAutomationStore();
    iClickOnAccountBaner();
    }

    @Then("<expectedResult>")
    public void expectedresult() {
    }
}
