package com.shaman.parser.services;

import com.shaman.parser.model.ResumeItem;

import java.util.List;

/**
 *
 */
public interface ResumeService {

    ResumeItem addResume(ResumeItem resume);
    ResumeItem editResume(ResumeItem resume);
    void delete(long id);
    List<ResumeItem> getAll();
    ResumeItem getBypositionName(String positionName);
}
