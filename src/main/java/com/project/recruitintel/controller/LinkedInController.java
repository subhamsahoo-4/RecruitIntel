package com.project.recruitintel.controller;

import com.project.recruitintel.service.LinkedInScraperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.recruitintel.dto.StudentDto;
import java.util.List;

@RestController
public class LinkedInController {

    private final LinkedInScraperService scraperService;

    public LinkedInController(LinkedInScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @GetMapping("/scrape")
    public String scrapeProfiles() {

        scraperService.scrapeLinkedInProfiles();

        return "Scraping Completed";
    }

    @GetMapping("/students")
    public List<StudentDto> getStudents() {

        return scraperService.getStudents();
    }
}