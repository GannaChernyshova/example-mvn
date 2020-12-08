package pages;


import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class MainPageWithFindBy extends BasePage {

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private WebElement email;

    @FindBy(xpath = "//div[contains(text(), 'Quality')]")
    private List<WebElement> listElements;


    public MainPageWithFindBy(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPageWithFindBy open() {
        driver.get(mainPageUrl);
        return this;
    }

    public MainPageWithFindBy inputEmailToSubmit(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }

    public MainPageWithFindBy inputNameToSubmit(String nameValue) {
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(nameValue);
        return this;
    }

    public MainPageWithFindBy inputPhoneToSubmit(String phoneValue) {
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(phoneValue);
        return this;
    }

    public MainPageWithFindBy clickLearnMore() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement button = driver.findElement(By.xpath("//button[text()='Learn More']"));
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
        return this;
    }

    public List<String> getTextFromWhyChooseUsList() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(text(), 'Quality')]"));
//        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getEmailErrorNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement errorNotification = driver.findElement(By.xpath("(//div[@class='t-form__errorbox-text t-text t-text_md'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(errorNotification));
        return errorNotification.getText();
    }

}
