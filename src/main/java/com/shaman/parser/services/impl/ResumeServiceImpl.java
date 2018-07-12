package com.shaman.parser.services.impl;

import com.shaman.parser.model.ResumeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shaman.parser.repository.ResumeRepository;
import com.shaman.parser.services.ResumeService;

import java.util.List;

/**
 *
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public ResumeItem addResume(ResumeItem resume) {
        return resumeRepository.saveAndFlush(resume);
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
        return resumeRepository.findAll();
    }

    @Override
    public ResumeItem getBypositionName(String positionName) {
        return null;
    }
}
