package pages;


import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageWithFindBy extends BasePage {

    public MainPageWithFindBy(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPageWithFindBy open() {
        driver.get(mainPageUrl);
        return this;
    }

    public MainPageWithFindBy inputEmailToSubmit(String email) {
        driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys(email);
        return this;
    }

    public MainPageWithFindBy inputNameToSubmit(String name) {
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
        return this;
    }

    public MainPageWithFindBy inputPhoneToSubmit(String phone) {
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(phone);
        return this;
    }

    public MainPageWithFindBy clickSubmit() {
        driver.findElement(By.cssSelector("div.t-form__submit > button.t-submit")).click();
        return this;
    }

    public String getEmailErrorNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebElement errorNotification = driver.findElement(By.xpath("(//div[@class='t-form__errorbox-text t-text t-text_md'])[2]"));
        wait.until(ExpectedConditions.visibilityOf(errorNotification));
        return errorNotification.getText();
    }

}
