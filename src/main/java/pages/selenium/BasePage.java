package pages.selenium;


import com.epam.healenium.SelfHealingDriver;

public class BasePage {
    protected String mainPageUrl = "https://healenium.io/sha";
    protected SelfHealingDriver driver;

    public BasePage(SelfHealingDriver driver) {
        this.driver = driver;
    }
}
