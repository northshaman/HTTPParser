
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Parser;

import java.util.List;

/**
 * Class for test simple operations with WebDriver
 */
public class FirstTestWeb {

    Parser parser = new Parser();

    @Test
    public void simpleConnectionTest() {
        Parser parser = new Parser();
        parser.setTargetURL("https://ekb.zarplata.ru/resume");
        List<WebElement> resumeList = parser.getDriver().findElements(By.cssSelector(".resume"));
        resumeList.forEach(r -> System.out.println(r.getText()));
        parser.getDriver().close();
    }


}
