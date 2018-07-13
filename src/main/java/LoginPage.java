import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class LoginPage {

    @FindBy(id = "txtUsername")
    private WebElement username;

    @FindBy(id = "txtPassword")
    private WebElement pw;

    @FindBy(id = "spanMessage")
    private WebElement spanMessage;


    public void login(WebDriver driver) {
        username.click();
        username.sendKeys("Admin");
        new Actions(driver).sendKeys(Keys.TAB, "AdminAdmin", Keys.ENTER).perform();

    }
}
