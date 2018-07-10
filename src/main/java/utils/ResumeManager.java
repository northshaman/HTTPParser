package utils;

import model.ResumeItem;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for operations with resume objects
 */
@Service
public class ResumeManager {

    final SiteParserService parserService;

    @Autowired
    public ResumeManager(SiteParserService parserService) {
        this.parserService = parserService;
    }


    public void getNewResumePack() {
        List<WebElement> resumeList = parserService.getTargetElementsList();
        List<ResumeItem> resumeItems;

        resumeList.forEach(resume -> {
            String fioAge = parserService.getElementVal(resume, "fioAndAge");
            String fio = parserService.getElementVal(resume, "fioAndAge").substring(0, fioAge.indexOf(','));
            String age = parserService.getElementVal(resume, "fioAndAge").substring(fioAge.indexOf(',' + 1));
            ResumeItem resumeItem = new ResumeItem(
                    Long.parseLong(parserService.getElementVal(resume, "idOriginal", "name")),
                    fio,
                    Integer.parseInt(age),
                    parserService.getElementVal(resume, "resumeLink", "href"),
                    parserService.getElementVal(resume, "positionName"),
                    parserService.getElementVal(resume, "lastVisit"),
                    parserService.getElementVal(resume, "city"),
                    parserService.getElementVal(resume, "wageLevel"),
                    parserService.getElementVal(resume, "education"),
                    parserService.getElementVal(resume, "experience"),
                    parserService.getElementVal(resume, "lastPlaceOfWork"),
                    parserService.getElementVal(resume, "lastPositionName"),
                    parserService.getElementVal(resume, "lastPlaceDuration"),
                    parserService.getElementVal(resume, "pictureLink", "src"));
            System.out.println(resumeItem);
        });
    }
}
