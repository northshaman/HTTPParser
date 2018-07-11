import config.AppConfig;
import model.ResumeItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.ResumeService;


/**
 *
 */
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResumeServiceImplTest {
    @Autowired
    ResumeService resumeService;

    @Test
    public void getNewResumePack(){

        System.out.println(resumeService.addResume(
                new ResumeItem(100,
                        "Ivanov",
                        25,
                        "http",
                        "boss",
                        "11.07.2018",
                        "Ekb",
                        "2 goda",
                        "netu",
                        "netu",
                        "netu",
                        null,
                        null,
                        null
                        )));
    }

}
