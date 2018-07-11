import config.AppConfig;
import model.ResumeItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.ResumeManager;

import java.util.List;

/**
 * Class for testing ResumeService
 */

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResumeServiceTest {
    @Autowired
    ResumeManager manager;

    @Test
    public void getNewResumePack(){
        List<ResumeItem> resumeItems = manager.getNewResumeList();
        resumeItems.forEach(System.out::println);
    }
}
