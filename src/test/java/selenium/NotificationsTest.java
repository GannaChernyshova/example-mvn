package selenium;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.selenium.MainPageWithFindBy;

public class NotificationsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(NotificationsTest.class);

    @Test
    public void submitApplication() {
        LOGGER.info("submitApplication test start");
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        mainPage.open()
            .inputEmailToSubmit("mail@mail")
            .inputNameToSubmit("Name")
            .inputPhoneToSubmit("89992346789").clickLearnMore();
        String notificationText = mainPage.getEmailErrorNotificationText();
        assertThat(notificationText, equalToIgnoringCase("Please put a correct e-mail"));
    }

    @Test
    public void submitApplicationSuccessfully() {
        LOGGER.info("submitApplication test start");
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        mainPage.open()
            .inputEmailToSubmit("mail@gmail.com")
            .inputNameToSubmit("Name")
            .inputPhoneToSubmit("89992346789").clickLearnMore();
        String notificationText = mainPage.getEmailSuccessNotificationText();
        assertThat(notificationText, equalToIgnoringCase("Thank you! Your data has been submitted."));
    }

    @Test
    public void donationValueTest(){
        LOGGER.info("donationValueTest test start");
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        mainPage.open();
        Assertions.assertEquals("$10", mainPage.getTextForTenDollars());
        mainPage.selectDonationValue(50);
        Assertions.assertEquals("$10", mainPage.getTextForTenDollars());
    }
}
