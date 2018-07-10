import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.ResumeManager;

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
        manager.getNewResumePack();
    }
}
