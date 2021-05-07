package selenide;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.selenide.SelenideMainPage;
import pages.selenide.SelenideMainPageWithFindBy;
import selenium.NotificationsTest;

public class SelenideTest extends SelenideBaseTest{

  private static final Logger LOGGER = LogManager.getLogger(NotificationsTest.class);


  @Test
  public void submitApplication() {
    LOGGER.info("submitApplication test start");
    SelenideMainPageWithFindBy mainPage = new SelenideMainPageWithFindBy();
    mainPage.openPage()
        .inputEmailToSubmit("mail@mail")
        .inputNameToSubmit("Name")
        .inputPhoneToSubmit("89992346789").clickLearnMore();
    mainPage.emailErrorNotificationShouldHaveText("Please put a correct e-mail");
  }

  @Test
  public void submitApplicationSuccessfully() {
    LOGGER.info("submitApplication test start");
    SelenideMainPageWithFindBy mainPage = new SelenideMainPageWithFindBy();
    mainPage.openPage()
        .inputEmailToSubmit("mail@gmail.com")
        .inputNameToSubmit("Name")
        .inputPhoneToSubmit("89992346789").clickLearnMore();
    mainPage.emailSuccessNotificationShouldHaveText("Thank you! Your data has been submitted.");
  }

  @Test
  public void donationValueTestWithFindBy(){
    LOGGER.info("donationValueTest test start");
    SelenideMainPageWithFindBy mainPage = new SelenideMainPageWithFindBy();
    mainPage.openPage();
    mainPage.tenDollarsButtonTextShouldBe("$10");
    mainPage.selectDonationValue(50);
    mainPage.tenDollarsButtonTextShouldBe("$10");
  }

  @Test
  public void donationValueTest(){
    LOGGER.info("donationValueTest test start");
    SelenideMainPage mainPage = new SelenideMainPage(driver);
    mainPage.open();
    mainPage.tenDollarsButtonTextShouldBe("$10");
    mainPage.selectDonationValue(50);
    mainPage.tenDollarsButtonTextShouldBe("$10");
  }
}
