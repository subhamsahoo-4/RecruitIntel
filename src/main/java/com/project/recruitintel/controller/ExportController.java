package com.project.recruitintel.controller;

import com.project.recruitintel.dto.StudentDto;
import com.project.recruitintel.service.LinkedInScraperService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
public class ExportController {

    private final LinkedInScraperService scraperService;

    public ExportController(LinkedInScraperService scraperService) {

        this.scraperService = scraperService;
    }

    @GetMapping("/export-csv")
    public String exportCsv() {

        List<StudentDto> students =
                scraperService.getStudents();

        try {

            FileWriter writer =
                    new FileWriter("students.csv");

            writer.append("Name,Profile URL\n");

            for (StudentDto student : students) {

                writer.append(student.getName())
                        .append(",")

                        .append(student.getProfileUrl())

                        .append("\n");
            }

            writer.flush();

            writer.close();

            return "CSV Exported Successfully";

        } catch (IOException e) {

            e.printStackTrace();

            return "CSV Export Failed";
        }
    }
}