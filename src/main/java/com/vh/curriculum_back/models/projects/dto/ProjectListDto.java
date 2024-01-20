package com.vh.curriculum_back.models.projects.dto;

import com.vh.curriculum_back.models.projects.Project;

import java.util.List;

public record ProjectListDto(
        String name,
        String description,
        String link,
        List<String> technologies
) {

    public ProjectListDto(Project project) {
        this(project.getName(), project.getDescription(), project.getLink(), project.getTechnologies());
    }

}
