package com.vh.curriculum_back.models.main_info.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CreateExperienceVoDto(
        String company,
        String role,
        String description,
        @JsonFormat(pattern = "dd-MM-yyyy")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate startDate,
        @JsonFormat(pattern = "dd-MM-yyyy")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate endDate
        ) {
}
