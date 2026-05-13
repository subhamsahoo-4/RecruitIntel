package com.project.recruitintel.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import com.project.recruitintel.dto.StudentDto;
import com.project.recruitintel.entity.StudentProfile;
import com.project.recruitintel.repository.StudentRepository;

@Service
public class LinkedInScraperService {

    private final WebDriver driver;
    
    private final StudentRepository studentRepository;

    private List<StudentDto> cachedStudents = new ArrayList<>();

    public LinkedInScraperService(WebDriver driver,StudentRepository studentRepository) {
        this.driver = driver;

        this.studentRepository = studentRepository;
    }

    public void scrapeLinkedInProfiles() {

        if (!cachedStudents.isEmpty()) {
            return;
        }

        List<StudentDto> students = new ArrayList<>();

        Set<String> uniqueProfiles = new HashSet<>();

        String[] searches = {"2024 passout","2025 passout"};

        try {


            Thread.sleep(500);


            for (String keyword : searches) {

                String url ="https://www.linkedin.com/search/results/people/?keywords=" + keyword.replace(" ", "%20");

                driver.get(url);

                Thread.sleep(5000);

                List<WebElement> profiles = driver.findElements(By.cssSelector("a[href*='/in/']"));

                System.out.println("Profiles Found: " + profiles.size());

                for (WebElement profile : profiles) {

                    try {

                        String profileUrl = profile.getAttribute("href");

                        String name = profile.getText().trim();

                        if (name.contains("\n")) {

                            name = name.split("\n")[0];
                        }

                        name = name.replace("? 2nd", "")
                                .replace("? 3rd+", "")
                                .trim();

                        if (!name.isEmpty() && profileUrl != null && profileUrl.contains("/in/") && !uniqueProfiles.contains(profileUrl)) {

                            uniqueProfiles.add(profileUrl);

                            StudentDto dto =
                                    new StudentDto(name, profileUrl);

                            students.add(dto);

                            System.out.println("SAVING: " + name);

                            StudentProfile entity =
                                    new StudentProfile(name, profileUrl);

                            studentRepository.save(entity);

                            System.out.println("SAVED SUCCESSFULLY");
                        }

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            }

            Thread.sleep(800);

            

            List<WebElement> profiles = driver.findElements(By.cssSelector("a[href*='/in/']"));

            System.out.println("Profiles Found: " + profiles.size());

            for (WebElement profile : profiles) {

                try {

                    String profileUrl =
                            profile.getAttribute("href");

                    String name =
                            profile.getText().trim();

                    if (name.contains("\n")) {

                        name = name.split("\n")[0];
                    }

                    name = name.replace("? 2nd", "")
                            .replace("? 3rd+", "")
                            .trim();

                    uniqueProfiles.add(profileUrl);

                    StudentDto dto =
                            new StudentDto(name, profileUrl);

                    students.add(dto);

                    System.out.println("SAVING: " + name);

                    StudentProfile entity =
                            new StudentProfile(name, profileUrl);

                    studentRepository.save(entity);

                    System.out.println("SAVED SUCCESSFULLY");

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            System.out.println("LinkedIn Login Successful");


        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("TOTAL: " + students.size());

        cachedStudents = students;

    }

    public List<StudentDto> getStudents() {
        return cachedStudents;
    }
}