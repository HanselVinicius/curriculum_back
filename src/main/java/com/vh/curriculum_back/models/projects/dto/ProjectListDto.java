package com.vh.curriculum_back.models.projects.dto;

import com.vh.curriculum_back.models.projects.Project;
import com.vh.curriculum_back.models.vo.tecnologia.TecnologiaVo;

import java.util.List;

public record ProjectListDto(
        Long id,
        String name,
        String description,
        String link,
        List<TecnologiaVo> technologies
) {

    public ProjectListDto(Project project) {
        this(project.getId(),project.getName(), project.getDescription(), project.getLink(), project.getTechnologies());
    }

}
