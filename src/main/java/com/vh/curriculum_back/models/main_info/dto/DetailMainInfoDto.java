package com.vh.curriculum_back.models.main_info.dto;

import com.vh.curriculum_back.models.main_info.MainInformation;
import com.vh.curriculum_back.models.vo.experience.ExperienceVO;

import java.util.List;

public record DetailMainInfoDto(
        String name,
        String surname,
        String description,
        List<ExperienceVO> experienceVOS) {

    public DetailMainInfoDto(MainInformation mainInformation) {
        this(
                mainInformation.getName(),
                mainInformation.getSurname(),
                mainInformation.getDescription(),
                mainInformation.getExperienceVOS()
        );
    }

}
