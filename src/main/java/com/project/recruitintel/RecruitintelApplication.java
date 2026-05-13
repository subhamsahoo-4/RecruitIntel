package com.project.recruitintel;

import com.project.recruitintel.service.LinkedInScraperService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecruitintelApplication {

    public static void main(String[] args) {

        SpringApplication.run(RecruitintelApplication.class, args);
    }
}