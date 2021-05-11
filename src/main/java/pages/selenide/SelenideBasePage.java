package pages.selenide;


import com.epam.healenium.SelfHealingDriver;

public class SelenideBasePage {
    public static String mainPageUrl = "https://healenium.io/sha";
    protected SelfHealingDriver driver;

    public SelenideBasePage(SelfHealingDriver driver) {
        this.driver = driver;
    }

}
