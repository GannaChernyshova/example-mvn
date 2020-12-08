package selenium;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.MainPageWithFindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(NotificationsTest.class);


//    @Test
//    public void submitApplication() {
//        LOGGER.info("submitApplication test start");
//        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
//        mainPage.open()
//            .inputEmailToSubmit("mail@mail")
//            .inputNameToSubmit("Name")
//            .inputPhoneToSubmit("89992346789").clickLearnMore();
//        String notificationText = mainPage.getEmailErrorNotificationText();
//        assertThat(notificationText, equalToIgnoringCase("Please put a correct e-mail"));
//    }

    @Test
    public void verifyWhyChooseUsList() {
        LOGGER.info("verifyWhyChooseUsList test start");
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        List<String> elementsText = mainPage.open()
                .getTextFromWhyChooseUsList();
        assertThat(elementsText.size(), is(3));
    }


}
