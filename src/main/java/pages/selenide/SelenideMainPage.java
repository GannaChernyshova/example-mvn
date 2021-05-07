package pages.selenide;


import com.epam.healenium.SelfHealingDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SelenideMainPage extends SelenideBasePage {

    public SelenideMainPage(SelfHealingDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    @Step("Open tilda page")
    public SelenideMainPage open() {
        driver.get(mainPageUrl);
        return this;
    }

    @Step("10$ button text is correct")
    public SelenideMainPage tenDollarsButtonTextShouldBe(String text) {
        $(By.xpath("//button[contains(@class, 't988__pricebtn_active') and @value = '$10']/span"))
                .shouldHave(text(text));
        return this;
    }

    @Step("Select donation value")
    public void selectDonationValue(int value) {
        $(By.xpath(String.format("//button[@value = '$%s']", value))).click();
    }

}
