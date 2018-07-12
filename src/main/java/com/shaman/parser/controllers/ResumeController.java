package com.shaman.parser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Cr
 */
@Controller
@RequestMapping("/resumes")
public class ResumeController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getResume(){
        return "resume";
    }

}
