import static org.junit.Assert.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;
    ExtentReports report;
    ExtentTest test;
    LoginPage homepage;
    Dashboard dash;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Constant.filepath+Constant.chromeDriver);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        report = new ExtentReports(Constant.filepath+ Constant.report, true);
        test = report.startTest("Administrate an employee");

        homepage = PageFactory.initElements(driver, LoginPage.class);
        dash = PageFactory.initElements(driver, Dashboard.class);

    }

    @After
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait( 500, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
        report.endTest(test);
        report.flush();
    }

    @Given("^the login page$")
    public void the_login_page()  {
        driver.get(Constant.url);
    }

    @When("^I login$")
    public void i_login() {
        homepage = PageFactory.initElements(driver, LoginPage.class);
        homepage.login(driver);
        test.log(LogStatus.INFO, "Login attempted.");
    }


    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab(){

        dash.clickPim(driver);
        test.log(LogStatus.INFO, "PIM Tab clicked.");
    }


    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() {

        dash.clickEmployeeTab(driver);
        test.log(LogStatus.INFO, "Add Employee Tab clicked.");
    }

    @When("^I fill out the Employee Details correctly$")
    public void i_fill_out_the_Employee_Details_correctly() {
        test.log(LogStatus.INFO, "Click employee tabs success.");
        dash.fillEmployee(driver);
        test.log(LogStatus.INFO, "Filling in employee form.");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
        test.log(LogStatus.INFO, "Fill out employee details successful.");
        dash.selectLogin();

        test.log(LogStatus.INFO, "Click create login details");
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        test.log(LogStatus.INFO, "Click success.");
        dash.fillOutLoginDetails(driver);
        test.log(LogStatus.INFO,"Filling out login details.");
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws InterruptedException {
        Thread.sleep(500);
        dash.clickSave();
        Thread.sleep(500);
        test.log(LogStatus.INFO, "Click save.");

    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws InterruptedException {
        Thread.sleep(500);
        dash.searchEmployee(driver);
        Thread.sleep(500);
        test.log(LogStatus.INFO, "Searching for Rayyan");
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dash.select4Inspection();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        test.log(LogStatus.INFO, "Selecting Rayyan for inspection");
//        assertEquals();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(LogStatus.PASS, "Passed somehow.");

    }



}
