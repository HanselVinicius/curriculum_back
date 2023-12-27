package com.vh.curriculum_back.models.main_info.dto;

import com.vh.curriculum_back.models.main_info.MainInformation;

public record ListagemMainInfoDto(Long id,
                                  String name,
                                  String surname,
                                  String email,
                                  String phone,
                                  String city,
                                  String description) {


    public ListagemMainInfoDto(MainInformation mainInformation) {
        this(
                mainInformation.getId(),
                mainInformation.getName(),
                mainInformation.getSurname(),
                mainInformation.getEmail(),
                mainInformation.getPhone(),
                mainInformation.getCity(),
                mainInformation.getDescription()
        );
    }

}
