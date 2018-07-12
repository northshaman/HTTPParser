package com.shaman.parser.utils;

import com.shaman.parser.model.ResumeItem;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service for operations with resume objects
 */
@Service
public class ResumeManager {

    private  SiteParserService parserService;

    @Autowired
    public ResumeManager(SiteParserService parserService) {
        this.parserService = parserService;
    }


    public List<ResumeItem> getNewResumeList() {
        List<WebElement> resumeList = parserService.getTargetElementsList();
        List<ResumeItem> resumeItems = new ArrayList<>();

        resumeList.forEach(resume -> {
            String fioAge = parserService.getElementVal(resume, "fioAndAge");
            String fio = fioAge.substring(0, fioAge.indexOf(','));
            String age = "";
            Pattern p = Pattern.compile("-?\\d+");
            Matcher m = p.matcher(fioAge.substring(fioAge.indexOf(',')));
            while (m.find()) {
                age = m.group();
            }
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
            resumeItems.add(resumeItem);
        });
        return resumeItems;
    }
}
