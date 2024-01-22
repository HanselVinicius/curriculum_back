package com.vh.curriculum_back.models.vo.experience;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "ExperienceVO")
@Table(name = "experience_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ExperienceVO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String role;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate  endDate;

    public ExperienceVO(CreateExperienceVoDto createExperienceVoDto) {
        this.company = createExperienceVoDto.company();
        this.role = createExperienceVoDto.role();
        this.description = createExperienceVoDto.description();
        this.startDate = createExperienceVoDto.startDate();
        this.endDate = createExperienceVoDto.endDate();
    }


}
