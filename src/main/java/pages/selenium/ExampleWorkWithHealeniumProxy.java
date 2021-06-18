package pages.selenium;

import pages.selenium.service.JsonWireRequestServiceImpl;

public class ExampleWorkWithHealeniumProxy {
    public static void main(String[] args) {

        JsonWireRequestServiceImpl jWRService = new JsonWireRequestServiceImpl();

        /**
         * response - String sessionId
         */
        String sessionId = jWRService.createSession("chrome");

        /**
         * response - state (success/fail)
         */
        String gettingWebPage =
                jWRService.openWebPageByURL(sessionId, "http://practice.automationtesting.in/my-account");

        /**
         * response - webElementId
         */
        String webElementId1 = jWRService.findElementById(sessionId, "username");

        /**
         * response - state (success/fail)
         */
        String sendingValue1 = jWRService.sendValueToWebElement(sessionId, webElementId1, "anatolyzbrush");

        /**
         * response - webElementId
         */
        String webElementId2 = jWRService.findElementById(sessionId, "password");

        /**
         * response - state (success/fail)
         */
        String sendingValue2 = jWRService.sendValueToWebElement(sessionId, webElementId2, "anatolNWO@42");

        /**
         * response - webElementId
         */
        String webElementId3 = jWRService.findElementByName(sessionId, "login");

        /**
         * response - state (success/fail)
         */
        String responseClickOnElement = jWRService.clickOnElement(sessionId, webElementId3);

        /**
         * response - state (success/fail)
         */
        String responseCloseWindow = jWRService.closeWindow(sessionId);

    }
}
