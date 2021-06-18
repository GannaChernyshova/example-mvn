package pages.selenium;

public class RequestData {
    private String browserName;
    private String url;
    private String elementId;
    private String elementName;
    private String sendValue;

    public RequestData() {
        this.browserName = "default";
        this.url = "default";
        this.elementId = "default";
        this.elementName = "default";
        this.sendValue = "default";
    }
    public String getBrowserName() {
        return this.browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getElementId() {
        return this.elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getSendValue() {
        return this.sendValue;
    }

    public void setSendValue(String sendValue) {
        this.sendValue = sendValue;
    }
}
