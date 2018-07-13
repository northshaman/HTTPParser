package com.shaman.parser.services.impl;

import com.shaman.parser.entity.ResumeItem;
import org.springframework.stereotype.Service;
import com.shaman.parser.services.ResumeService;

import java.util.List;

/**
 *
 */
@Service
public class ResumeServiceImpl implements ResumeService{




    @Override
    public ResumeItem addResume(ResumeItem resume) {
        return
                null;
//                resumeRepository.saveAndFlush(resume);
    }

    @Override
    public ResumeItem editResume(ResumeItem resume) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<ResumeItem> getAll() {
        return
                null;
//                resumeRepository.findAll();
    }

    @Override
    public ResumeItem getBypositionName(String positionName) {
        return null;
    }
}
