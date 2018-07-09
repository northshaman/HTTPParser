
import config.AppConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.SiteParserService;

import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.core.env.Environment;

/**
 * Class for test simple operations with WebDriver
 */
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FirstTestWeb {
    @Autowired
    private SiteParserService siteParserService;
    @Autowired
    private Environment env;

    @Test
    @Ignore
    public void simpleConnectionTest() {
        siteParserService.setTargetURL("https://ekb.zarplata.ru/resume");
        List<WebElement> resumeList = siteParserService.getDriver().findElements(By.cssSelector(".resume"));
        resumeList.forEach(r -> System.out.println(r.getText()));
    }


    @Test
    public void testProps() {
        siteParserService.initCSSFromProps();
        siteParserService.getCssPropertiesMap().forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }

    @Test
    public void parseResumeTest() throws InterruptedException {
        //                TODO: replace this test with map of props
        siteParserService.setTargetURL("https://ekb.zarplata.ru/resume");
        siteParserService.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        siteParserService.getDriver().manage().window().setSize(new Dimension(1280, 1024));
        siteParserService.getDriver().get(siteParserService.getTargetURL());

        List<WebElement> resumeList = siteParserService.getDriver()
                .findElements(By.cssSelector(".ui.segment.resume.resume-item"));
        System.out.println("Found -> " + resumeList.size() + " resume\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
//            System.out.println(resumeList.get(i).getText());

            System.out.println("Parse permanently:\n");
            // ID
            System.out.println("ID - >" + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.id"))).getAttribute("name"));
            // FIO + Age
            System.out.println("FIO and age - > " + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.fio"))).getText());
            // Link to resume
            System.out.println("Link to resume - > " + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.resumeLink"))).getAttribute("href"));
            // PositionName
            System.out.println("PositionName - > " + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.positionName"))).getText());
            // last visit?
            System.out.println("Last visit - > "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.lastVisit"))).getText());
            // City
            System.out.println("City - > "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.city"))).getText());
            //wageLevel
            System.out.println("Zarplata -> "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.wageLevel"))).getText());
            //education type
            System.out.println("Education type -> "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.education"))).getText());
            //expirience
            System.out.println("Experience -> "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.expirience"))).getText());
            //lastPlaceOfWork
            System.out.println("LastPlaceOfWork -> "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.lastPlaceOfWork"))).getText());
            //lastPositionName
            System.out.println("LastPositionName -> "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.lastPositionName"))).getText());
            //lastPlaceDuration
            System.out.println("LastPlaceDuration -> "
                    + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.lastPlaceDuration"))).getText());
            //
            //Picture
            try {
                System.out.println("Picture - > " + resumeList.get(i).findElement(By.cssSelector(env.getProperty("css.picture"))).getAttribute("src"));
            } catch (Exception nse) {
//                TODO: fix Exception
                System.out.println("No Photo!");
            }
            System.out.println();
        }

    }
}