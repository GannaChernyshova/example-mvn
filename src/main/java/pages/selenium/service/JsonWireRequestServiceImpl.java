package pages.selenium.service;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import pages.selenium.RequestData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class JsonWireRequestServiceImpl implements JsonWireRequestService {
    private String PROXY_URI_CREATE_SESSION = "http://192.168.20.107:8082/session";
    private String PROXY_URI_CREATE_SESSION_LOCAL = "http://127.0.0.1:8082/session";

    private String PROXY_URI_OPEN_WEB_PAGE_BY_URL = "http://192.168.20.107:8082/session/%s/url";
    private String PROXY_URI_OPEN_WEB_PAGE_BY_URL_LOCAL = "http://127.0.0.1:8082/session/%s/url";

    private String PROXY_URI_FIND_ELEMENT_BY_ID = "http://192.168.20.107:8082/session/%s/element";
    private String PROXY_URI_FIND_ELEMENT_BY_ID_LOCAL = "http://127.0.0.1:8082/session/%s/element";

    private String PROXY_URI_FIND_ELEMENT_BY_NAME = "http://192.168.20.107:8082/session/%s/element";
    private String PROXY_URI_FIND_ELEMENT_BY_NAME_LOCAL = "http://127.0.0.1:8082/session/%s/element";

    private String PROXY_URI_SEND_KEYS_VALUE = "http://192.168.20.107:8082/session/%s/element/%s/value";
    private String PROXY_URI_SEND_KEYS_VALUE_LOCAL = "http://127.0.0.1:8082/session/%s/element/%s/value";

    private String PROXY_URI_CLICK_ON_ELEMENT = "http://192.168.20.107:8082/session/%s/element/%s/click";
    private String PROXY_URI_CLICK_ON_ELEMENT_LOCAL = "http://127.0.0.1:8082/session/%s/element/%s/click";

    private String PROXY_URI_CLOSE_WINDOW = "http://192.168.20.107:8082/session/%s/window";
    private String PROXY_URI_CLOSE_WINDOW_LOCAL = "http://127.0.0.1:8082/session/%s/window";

    @Override
    public String createSession(String browserName) {
        HttpPost httpPost = new HttpPost(PROXY_URI_CREATE_SESSION_LOCAL);

        RequestData requestData = new RequestData();
        if (browserName.equals("chrome") || browserName.equals("firefox") || browserName.equals("ie")) {
            requestData.setBrowserName(browserName);
        } else {
            requestData.setBrowserName("chrome");
        }

        httpPost.setEntity(createStringEntity(requestData));
        return executeHttpRequest(httpPost);
    }

    @Override
    public String openWebPageByURL(String sessionId, String url) {
        HttpPost httpPost = new HttpPost(String.format(PROXY_URI_OPEN_WEB_PAGE_BY_URL_LOCAL, sessionId));

        RequestData requestData = new RequestData();
        requestData.setUrl(url);

        httpPost.setEntity(createStringEntity(requestData));
        return executeHttpRequest(httpPost);
    }

    @Override
    public String findElementById(String sessionId, String elementId) {
        HttpPost httpPost = new HttpPost(String.format(PROXY_URI_FIND_ELEMENT_BY_ID_LOCAL, sessionId));

        RequestData requestData = new RequestData();
        requestData.setElementId(elementId);

        httpPost.setEntity(createStringEntity(requestData));
        return executeHttpRequest(httpPost);
    }

    @Override
    public String findElementByName(String sessionId, String elementName) {
        HttpPost httpPost = new HttpPost(String.format(PROXY_URI_FIND_ELEMENT_BY_NAME_LOCAL, sessionId));

        RequestData requestData = new RequestData();
        requestData.setElementName(elementName);

        httpPost.setEntity(createStringEntity(requestData));
        return executeHttpRequest(httpPost);
    }

    @Override
    public String sendValueToWebElement(String sessionId, String elementId, String sendValue) {
        HttpPost httpPost = new HttpPost(String.format(PROXY_URI_SEND_KEYS_VALUE_LOCAL, sessionId, elementId));

        RequestData requestData = new RequestData();
        requestData.setSendValue(sendValue);

        httpPost.setEntity(createStringEntity(requestData));
        return executeHttpRequest(httpPost);
    }

    @Override
    public String clickOnElement(String sessionId, String elementId) {
        HttpPost httpPost = new HttpPost(String.format(PROXY_URI_CLICK_ON_ELEMENT_LOCAL, sessionId, elementId));

        return executeHttpRequest(httpPost);
    }

    @Override
    public String closeWindow(String sessionId) {
        HttpDelete httpDelete = new HttpDelete(String.format(PROXY_URI_CLOSE_WINDOW_LOCAL, sessionId));

        return executeHttpRequest(httpDelete);
    }

    private String executeHttpRequest(HttpRequestBase httpRequest) {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        httpRequest.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = null;
        String responseData = "";
        try {
            response = closeableHttpClient.execute(httpRequest);
            HttpEntity entityResponse = response.getEntity();
            responseData = EntityUtils.toString(entityResponse, StandardCharsets.UTF_8);
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    private StringEntity createStringEntity(RequestData requestData) {
        Gson gson = new Gson();
        StringEntity postStringEntity = null;
        try {
            postStringEntity = new StringEntity(gson.toJson(requestData));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return postStringEntity;
    }
}
