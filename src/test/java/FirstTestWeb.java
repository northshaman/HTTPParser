import config.AppConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Ignore
    @Test
    public void testProps() {
        siteParserService.getCssPropertiesMap().forEach((k, v) ->
                System.out.println(k + " -> " + v));
    }

    @Test
    public void getTargetElementsListTest() {
        List<WebElement> resumeList = siteParserService.getTargetElementsList();
        System.out.println("Found -> " + resumeList.size() + " resume\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Resume N"+i);
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "idOriginal", "name"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "fioAndAge"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "resumeLink", "href"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "positionName"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "lastVisit"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "city"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "wageLevel"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "education"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "experience"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "lastPlaceOfWork"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "lastPositionName"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "lastPlaceDuration"));
            System.out.println(siteParserService.getElementVal(resumeList.get(i), "pictureLink", "src"));
            System.out.println();
        }
    }

}