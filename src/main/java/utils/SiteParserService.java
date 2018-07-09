package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


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
    }

    public List<WebElement> getTargetElementsList(By by) {
        this.driver.get(targetURL);
        System.out.println("Trying to connect to -> " + targetURL);
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

}