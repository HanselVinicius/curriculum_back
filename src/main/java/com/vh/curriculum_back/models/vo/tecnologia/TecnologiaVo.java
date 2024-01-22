package com.vh.curriculum_back.models.vo.tecnologia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tecnologias_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TecnologiaVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int experienceYears;


    public TecnologiaVo(CreateTecnologiaVoDto createTecnologiaVoDto) {
        this.name = createTecnologiaVoDto.name();
        this.experienceYears = createTecnologiaVoDto.experienceYears();
    }
}
