package pages.selenide;


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

    @FindBy(xpath = "//input[@placeholder='Name']" )
    private WebElement name;

    @FindBy(xpath = "//input[@placeholder='Phone']" )
    private WebElement phone;

    @FindBy(xpath = "//button[text()='Learn More']" )
    private WebElement learnMoreButton;

    @FindBy(className = "t-form__successbox" )
    private WebElement successMessage;

    @FindBy(className = "(//div[@class='t-form__errorbox-text t-text t-text_md'])[2]" )
    private WebElement errorMessage;

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
        name.sendKeys(nameValue);
        return this;
    }

    @Step("Fill phone input")
    public MainPageWithFindBy inputPhoneToSubmit(String phoneValue) {
        phone.sendKeys(phoneValue);
        return this;
    }

    @Step("Click Learn more button")
    public MainPageWithFindBy clickLearnMore() {
        learnMoreButton.click();
        return this;
    }

    @Step("Get Error message text")
    public String getEmailErrorNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    @Step("Get Success message text")
    public String getEmailSuccessNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
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
