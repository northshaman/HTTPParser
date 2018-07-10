package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * SiteParser HTML
 */
@Service
public class SiteParserService {

    private WebDriver driver;

    @Value("${phantomJS.defaultURL}")
    private String targetURL;


    private Map<String, String> cssPropertiesMap = new HashMap<>();

    @Autowired
    public SiteParserService(WebDriver driver) {
        this.driver = driver;
        initCSSFromProps();
    }

    public List<WebElement> getTargetElementsList(By by) {
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1280, 1024));
        this.driver.get(targetURL);
        return driver.findElements(by);
    }

    public Map<String, String> getCssPropertiesMap() {
        return cssPropertiesMap;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTargetURL() {
        return targetURL;
    }

    public void setTargetURL(String targetURL) {
        this.targetURL = targetURL;
        this.driver.get(targetURL);
    }

    /**
     * initialize map for storage css selectors
     */
    public void initCSSFromProps() {
        Properties prop = null;
        InputStream is;
        try {
            prop = new Properties();
            is = this.getClass().getResourceAsStream("/css.properties");
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Object> keys = prop.keySet();
        Properties finalProp = prop;
        keys.forEach(k ->
                cssPropertiesMap.put((String) k, finalProp.getProperty((String) k))
        );
    }

    public String getElementVal(WebElement element, String elementName) {
        String elementValue = null;
        try {

            elementValue = element.findElement(By.cssSelector(cssPropertiesMap.get(elementName))).getText();
        } catch (NoSuchElementException nse) {
//        NOP
        }
        return elementValue;
    }

    public String getElementVal(WebElement element, String elementName, String attrName) {
        String elementValue = null;
        try {
            elementValue = element.findElement(By.cssSelector(cssPropertiesMap.get(elementName))).getAttribute(attrName);
        } catch (NoSuchElementException nse) {
//        NOP
        }
        return elementValue;
    }
}