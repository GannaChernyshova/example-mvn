package pages.selenium;


import com.epam.healenium.SelfHealingDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageWithFindBy extends BasePage {

    @FindBy(xpath = "//input[@placeholder='E-mail']" )
    private WebElement email;

    public MainPageWithFindBy(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open tilda page")
    public MainPageWithFindBy open() {
        driver.get(mainPageUrl);
        return this;
    }

    @Step("Fill email input")
    public MainPageWithFindBy inputEmailToSubmit(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }
    @Step("Fill name input")
    public MainPageWithFindBy inputNameToSubmit(String nameValue) {
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(nameValue);
        return this;
    }

    @Step("Fill phone input")
    public MainPageWithFindBy inputPhoneToSubmit(String phoneValue) {
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(phoneValue);
        return this;
    }

    @Step("Click Learn more button")
    public MainPageWithFindBy clickLearnMore() {
        driver.findElement(By.xpath("//button[text()='Learn More']")).click();
        return this;
    }

    @Step("Get Error message text")
    public String getEmailErrorNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement errorNotification = driver.findElement(By.xpath("(//div[@class='t-form__errorbox-text t-text t-text_md'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(errorNotification));
        return errorNotification.getText();
    }

    @Step("Get Success message text")
    public String getEmailSuccessNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement errorNotification = driver.findElement(By.className("t-form__successbox"));
        wait.until(ExpectedConditions.visibilityOf(errorNotification));
        return errorNotification.getText();
    }

    @Step("Get text for 10$ button")
    public String getTextForTenDollars() {
        return driver.findElement(By.xpath("//button[contains(@class, 't988__pricebtn_active') and @value = '$10']/span")).getText();

    }

    @Step("Select donation value")
    public void selectDonationValue(int value) {
        driver.findElement(By.xpath(String.format("//button[@value = '$%s']", value))).click();
    }

}
