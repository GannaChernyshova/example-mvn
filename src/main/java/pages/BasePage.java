package pages;


import com.epam.healenium.SelfHealingDriver;

public class BasePage {
    protected String mainPageUrl = "http://ssha.tilda.ws";
    protected SelfHealingDriver driver;

    public BasePage(SelfHealingDriver driver) {
        this.driver = driver;
    }
}
