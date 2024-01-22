package com.vh.curriculum_back.models.projects.dto;

import com.vh.curriculum_back.models.vo.tecnologia.TecnologiaVo;

import java.util.List;

public record ProjectUpdateDto(
        String name,
        String description,
        String link,
        List<TecnologiaVo> technologies
) {
}
