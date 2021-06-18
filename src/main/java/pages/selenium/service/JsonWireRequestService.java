package pages.selenium.service;

public interface JsonWireRequestService {

    String createSession(String browserName);

    String openWebPageByURL(String sessionId, String url);

    String findElementById(String sessionId, String elementId);

    String findElementByName(String sessionId, String elementName);

    String sendValueToWebElement(String sessionId, String elementId, String sendValue);

    String clickOnElement(String sessionId, String elementId);

    String closeWindow(String sessionId);
}
