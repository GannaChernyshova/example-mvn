package selenium;

import com.epam.healenium.SelfHealingDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPageWithFindBy;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class NotificationsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(NotificationsTest.class);

    @Test
    public void subscribeForMailing() {
        LOGGER.info("subscribeForMailing test start");
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        mainPage.open()
            .inputEmailToSubscribe("test")
            .clickSubscribe();
        String notificationText = mainPage.getSubscriptionValidationErrorText();
        assertThat(notificationText, equalToIgnoringCase("Please put a correct e-mail"));
    }

//    @Test
//    public void submitApplication() {
//        LOGGER.info("submitApplication test start");
//        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
//        mainPage.open()
//            .inputEmailToSubmit("mail@mail")
//            .inputNameToSubmit("Name")
//            .inputPhoneToSubmit("89992346789").clickSubmit();
//        String notificationText = mainPage.getEmailErrorNotificationText();
//        assertThat(notificationText, equalToIgnoringCase("Please put a correct e-mail"));
//    }
}
