package com.vh.curriculum_back.models.main_info;

import com.vh.curriculum_back.models.main_info.dto.CreateMainInfoDto;
import com.vh.curriculum_back.models.main_info.dto.MainInfoDto;
import com.vh.curriculum_back.models.vo.ExperienceVO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "main_information")
@Entity(name = "MainInformation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class MainInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String description;
    @OneToMany(
            cascade=CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "main_information_id")
    private List<ExperienceVO> experienceVOS = new ArrayList<>();


    public MainInformation(MainInfoDto dto){
        this.name = dto.name();
        this.surname = dto.surname();
        this.description = dto.description();
        this.experienceVOS = dto.experienceVOS();
    }

    public MainInformation(CreateMainInfoDto createMainInfoDto) {
        this.name = createMainInfoDto.name();
        this.surname = createMainInfoDto.surname();
        this.description = createMainInfoDto.description();
        createMainInfoDto.experienceVOS().forEach(createExperienceVoDto -> this.experienceVOS.add(new ExperienceVO(createExperienceVoDto)));
    }

}
