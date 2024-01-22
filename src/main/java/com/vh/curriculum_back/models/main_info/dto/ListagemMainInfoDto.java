package com.vh.curriculum_back.models.main_info.dto;

import com.vh.curriculum_back.models.main_info.MainInformation;
import com.vh.curriculum_back.models.vo.experience.ExperienceVO;
import java.util.List;

public record ListagemMainInfoDto(Long id,
                                  String name,
                                  String surname,
                                  List<ExperienceVO> experienceVOS,

                                  String description) {


    public ListagemMainInfoDto(MainInformation mainInformation) {
        this(
                mainInformation.getId(),
                mainInformation.getName(),
                mainInformation.getSurname(),
                mainInformation.getExperienceVOS(),
                mainInformation.getDescription()
        );
    }

}
