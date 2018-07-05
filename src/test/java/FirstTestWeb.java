
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.SiteParserService;

import java.util.List;

/**
 * Class for test simple operations with WebDriver
 */
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FirstTestWeb {
    @Autowired
    private SiteParserService siteParserService;

    @Test
    public void simpleConnectionTest() {
        siteParserService.setTargetURL("https://ekb.zarplata.ru/resume");
        List<WebElement> resumeList = siteParserService.getDriver().findElements(By.cssSelector(".resume"));
        resumeList.forEach(r -> System.out.println(r.getText()));
        siteParserService.getDriver().close();
    }
}
