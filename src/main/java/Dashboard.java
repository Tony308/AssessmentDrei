import com.google.common.base.Function;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Dashboard {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a")
    private WebElement pimTab;

    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    private WebElement addEmployeeTab;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"select-options-f20e2e24-0f26-532c-ee1a-325944f6e092\"]")
    private WebElement location;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement loginDetails;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"systemUserSaveBtn\"]")
    private WebElement savebtn;

    @FindBy(xpath = "//*[@id=\"employee_name_quick_filter_employee_list_value\"]")
    private WebElement searchEmployee;

    @FindBy(className = "cursor-pointer")
    private WebElement addedEmployee;

    @FindBy(id = "first_name")
    private WebElement personalForename;

    @FindBy(id = "last_name")
    private WebElement personalSurname;


    public void clickEmployeeTab(WebDriver driver) {
        WebElement myDynamicElement = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")));

            addEmployeeTab.click();
    }

    public void clickPim(WebDriver driver) {
        pimTab.click();
    }

    public void fillEmployee(WebDriver driver) {
        WebElement myDynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));

        firstName.click();
        firstName.sendKeys("Rayyan");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB, "middle", Keys.TAB, "Rayman").perform();
        action.sendKeys(Keys.TAB, Keys.TAB).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.sendKeys("london").perform();
        action.sendKeys(Keys.RETURN).perform();


    }

    public void selectLogin() {
        loginDetails.click();
    }

    public void fillOutLoginDetails(WebDriver driver) {
        Actions action = new Actions(driver);

        //Duplicate userNames creates errors and must be at least 5 characters long.
        username.sendKeys("hellaBut" ,Keys.TAB);
        action.sendKeys("Enabled",Keys.RETURN,Keys.TAB).perform();

        //Password must be 8 characters long
        action.sendKeys("rayyanrayman", Keys.TAB, "rayyanrayman",Keys.TAB, "Default ESS",Keys.TAB).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.sendKeys("Default Supervisor", Keys.RETURN, Keys.TAB).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action.sendKeys("global admin",Keys.RETURN).perform();

    }

    public void clickSave() {

        savebtn.click();
    }

    public void searchEmployee(WebDriver driver) {

        searchEmployee.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchEmployee.sendKeys("rayman", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void select4Inspection() {
        addedEmployee.click();
    }
}