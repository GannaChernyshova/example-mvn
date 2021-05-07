package pages.selenide;


import com.epam.healenium.SelfHealingDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open tilda page")
    public MainPage open() {
        driver.get(mainPageUrl);
        return this;
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
