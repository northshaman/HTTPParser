package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;


/**
 * Parser HTML
 */
public class Parser {
    private WebDriver driver;
    private String targetURL;


    public Parser() {
        this.driver = initWebDriver();
    }

    /**
     *
     * @return location of phantomjs
     */
    private String getPhantomjsPath() {
        return getClass().getResource("/phantomjs/bin/phantomjs.exe").getPath();
    }

    /**
     *
     * @return initialized PhantomJS WebDriver
     */
   private WebDriver initWebDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getPhantomjsPath());
        return new PhantomJSDriver(caps);
    }

    private List<WebElement> getTargetElementsList(By by){
        this.driver.get(targetURL);
        System.out.println("Trying to connect to -> "+targetURL);
        List<WebElement> elementList = driver.findElements(by);
        return elementList;

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

}
