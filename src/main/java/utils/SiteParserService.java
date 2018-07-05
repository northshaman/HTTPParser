package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * SiteParser HTML
 */
@Service
public class SiteParserService {

    private WebDriver driver;

    @Value("${phantomJS.defaultURL}")
    private String targetURL;


    @Autowired
    public SiteParserService(WebDriver driver) {
        this.driver = driver;
    }


//    /**
//     * @return location of phantomjs
//     */
//    private String getPhantomjsPath() {
//        return getClass().getResource("/phantomjs/bin/phantomjs.exe").getPath();
//    }

//    /**
//     * @return initialized PhantomJS WebDriver
//     */
//    private WebDriver initWebDriver() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getPhantomjsPath());
//        return new PhantomJSDriver(caps);
//    }

    private List<WebElement> getTargetElementsList(By by) {
        this.driver.get(targetURL);
        System.out.println("Trying to connect to -> " + targetURL);
        return driver.findElements(by);

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
