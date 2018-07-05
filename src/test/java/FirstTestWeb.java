
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

import java.util.List;

/**
 * Class for test simple operations with WebDriver
 */
public class FirstTestWeb {


    @Test
    public void startWebDriver() {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Java\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        WebDriver driver = new PhantomJSDriver(caps);

        driver.get("https://ekb.zarplata.ru/resume");

        List<WebElement> resumeList = driver.findElements(By.cssSelector(".resume"));
        resumeList.forEach(r ->{
            System.out.println(r.getText());
        });

        driver.close();
//        Assert.assertTrue();
    }

}
