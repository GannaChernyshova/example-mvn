package pages.selenide;


import com.codeborne.selenide.SelenideElement;
import com.epam.healenium.SelfHealingDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.selenide.SelenideBasePage.mainPageUrl;

public class SelenideMainPageWithFindBy {

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private SelenideElement email;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private SelenideElement name;

    @FindBy(xpath = "//input[@placeholder='Phone']")
    private SelenideElement phone;

    @FindBy(xpath = "//button[text()='Learn More']")
    private SelenideElement learnMoreButton;

    @FindBy(className = "t-form__successbox")
    private SelenideElement successMessage;

    @FindBy(css = ".t-form__errorbox-bottom>div>div.t-form__errorbox-text.t-text.t-text_md")
    private SelenideElement errorMessage;


    @Step("Open tilda page")
    public static SelenideMainPageWithFindBy openPage() {
        return open(mainPageUrl, SelenideMainPageWithFindBy.class);
    }

    @Step("Fill email input")
    public SelenideMainPageWithFindBy inputEmailToSubmit(String emailValue) {
        email.sendKeys(emailValue);
        return this;
    }

    @Step("Fill name input")
    public SelenideMainPageWithFindBy inputNameToSubmit(String nameValue) {
        name.sendKeys(nameValue);
        return this;
    }

    @Step("Fill phone input")
    public SelenideMainPageWithFindBy inputPhoneToSubmit(String phoneValue) {
        phone.sendKeys(phoneValue);
        return this;
    }

    @Step("Click Learn more button")
    public SelenideMainPageWithFindBy clickLearnMore() {
        learnMoreButton.click();
        return this;
    }

    @Step("Get Error message text")
    public void emailErrorNotificationShouldHaveText(String errorText) {
        $(".t-form__errorbox-bottom>div>div.t-form__errorbox-text.t-text.t-text_md")
                .shouldHave(text(errorText));
    }

    @Step("Get Success message text")
    public void emailSuccessNotificationShouldHaveText(String successText) {
        $(By.className("t-form__successbox")).shouldHave(text(successText));
    }

    @Step("10$ button text is correct")
    public void tenDollarsButtonTextShouldBe(String text) {
        $(By.xpath("//button[contains(@class, 't988__pricebtn_active') and @value = '$10']/span"))
                .shouldHave(text(text));
    }

    @Step("Select donation value")
    public void selectDonationValue(int value) {
        $(By.xpath(String.format("//button[@value = '$%s']", value))).click();
    }

}
