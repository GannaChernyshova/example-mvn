package selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.selenium.MainPageWithFindBy;

public class FindElementsTest extends BaseTest{
  @Test
  public void findTwoEmailFields(){
    MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
    int count = mainPage.open()
                  .getEmailFields().size();
    Assertions.assertEquals(count, 2);
  }

}
