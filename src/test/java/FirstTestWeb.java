
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.SiteParserService;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    }

    @Test
    public void parseResumeTest() throws InterruptedException {
        siteParserService.setTargetURL("https://ekb.zarplata.ru/resume");
        siteParserService.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("pageLoadTimeout SET!");
        siteParserService.getDriver().manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
        System.out.println("setScriptTimeout SET!");
        siteParserService.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        System.out.println("implicitlyWait SET!");
        siteParserService.getDriver().get(siteParserService.getTargetURL());
        System.out.println("trying");
        List<WebElement> resumeList = siteParserService.getDriver()
                .findElements(By.cssSelector(".ui.container .ui.segment.resume.resume-item .ui.grid .thirteen.wide.column .ui.grid .row .sixteen.wide.column .ui.grid div.five.wide.column div div.ui.text"));
        System.out.println("Found -> " + resumeList.size() + " resume\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            System.out.println(resumeList.get(i).getText());
            System.out.println(resumeList.get(i).getTagName());
            System.out.println(resumeList.get(i).getAttribute("text"));
            System.out.println(resumeList.get(i).getAttribute("value"));

//            System.out.println(secondList.get(i).findElement(By.cssSelector(".ui.grid .thirteen.wide.column .ui.grid .row .sixteen.wide.column .ui.grid .five.wide.column div ")).getText());


//            System.out.println(resumeList.get(i).getText());
//            System.out.println("Parse permanently:\n");
//            // ID
//            System.out.println("ID - >" + resumeList.get(i).findElement(By.cssSelector("div:nth-child(1)")).getAttribute("name"));
//            // FIO + Age
//            System.out.println("FIO and age - > " + resumeList.get(i).findElement(By.cssSelector(".eleven.wide.column h2.ui.tiny.header div")).getText());
//            // Link to resume
//            System.out.println("Link to resume - > " + resumeList.get(i).findElement(By.cssSelector(".eleven.wide.column h2.ui.tiny.header div a")).getAttribute("href"));
//            // PositionName
//            System.out.println("PositionName - > " + resumeList.get(i).findElement(By.cssSelector(".eleven.wide.column h2.ui.tiny.header div a")).getText());
//            // last visit?
//            System.out.println("Last visit - > "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid  .sixteen.wide.column .eleven.wide.column div:nth-child(3) div  span:nth-child(1).ui.text.small.grey span")).getText());
//            // City
//            System.out.println("Last visit - > "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid  .sixteen.wide.column .eleven.wide.column div:nth-child(3) div span:nth-child(2).ui.text.small.grey")).getText());
//            //wageLevel
//            System.out.println("Zarplata -> "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid .thirteen.wide.column .ui.grid .row .sixteen.wide.column .ui.grid .five.wide.column div ")).getText());
//
//            //education type
//            System.out.println("Education type -> "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid .five.wide.column div div.ui.text.small.grey:nth-child(3)")).getText());
//            //expirience
//            System.out.println("Experience -> "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid .five.wide.column div div.ui.text.small.grey:nth-child(2)")).getText());
//            //lastPlaceOfWork
//            System.out.println("LastPlaceOfWork -> "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid .row .eleven.wide.column.transition-resume_content-closed div div.ui.list.contacts div.item:nth-child(1) span")));
//            //lastPositionName
//            System.out.println("LastPositionName -> "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid .row .eleven.wide.column.transition-resume_content-closed div div.ui.list.contacts div.item:nth-child(2) span")));
//            //lastPlaceDuration
//            System.out.println("LastPlaceDuration -> "
//                    + resumeList.get(i).findElement(By.cssSelector(".ui.grid .row .eleven.wide.column.transition-resume_content-closed div div.ui.list.contacts div.item:nth-child(3) span span.ui.text.grey")));
//            //
//            //Picture
//            try {
//                System.out.println("Picture - > " + resumeList.get(i).findElement(By.cssSelector(".ui .logo img")).getAttribute("src"));
//            } catch (NoSuchElementException nse) {
//                System.out.println("No picture!");
//            }

        System.out.println();
    }
//        resumeList.forEach(e -> {
//            System.out.println(e.getText());
////            try {
////                System.out.println("Picture - >" + e.findElement(By.cssSelector(".ui .logo img")).getAttribute("src"));
////            } catch (NoSuchElementException nse){
////                System.out.println("No picture!");
////            }
//            });
    }
}