package com.vh.curriculum_back.models.projects.dto;

import com.vh.curriculum_back.models.vo.tecnologia.CreateTecnologiaVoDto;

import java.util.List;

public record ProjectCreateDto(
        String name,
        String description,
        String link,
        List<CreateTecnologiaVoDto> technologies

) {
}
