package com.vh.curriculum_back.models.main_info.dto;

import com.vh.curriculum_back.models.vo.ExperienceVO;

import java.util.List;

public record MainInfoDto(
        String name,
        String surname,
        String description,
        List<ExperienceVO> experienceVOS
) {
}
