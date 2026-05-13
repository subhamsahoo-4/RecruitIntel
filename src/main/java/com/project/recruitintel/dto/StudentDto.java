package com.project.recruitintel.dto;

public class StudentDto {

    private String name;

    private String profileUrl;

    public StudentDto(String name, String profileUrl) {

        this.name = name;

        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}