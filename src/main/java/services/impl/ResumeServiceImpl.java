package services.impl;

import model.ResumeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ResumeRepository;
import services.ResumeService;

import java.util.List;

/**
 *
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public ResumeItem addResume(ResumeItem resume) {
        ResumeItem savedResume = resumeRepository.saveAndFlush(resume);
        return savedResume;
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
