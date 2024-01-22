package com.vh.curriculum_back.models.main_info.dto;

import com.vh.curriculum_back.models.vo.experience.CreateExperienceVoDto;

import java.util.List;

public record CreateMainInfoDto(
        String name,
        String surname,
        String description,

        List<CreateExperienceVoDto> experienceVOS
) {
}
