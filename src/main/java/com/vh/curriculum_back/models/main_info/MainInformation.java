package com.vh.curriculum_back.models.main_info;

import com.vh.curriculum_back.models.main_info.dto.MainInfoDto;
import com.vh.curriculum_back.models.vo.ExperienceVO;
import jakarta.persistence.*;
import lombok.*;

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
    @ElementCollection
    @CollectionTable(name = "experience_vos", joinColumns = @JoinColumn(name = "main_information_id"))
    private List<ExperienceVO> experienceVOS;


    public MainInformation(MainInfoDto dto){
        this.name = dto.name();
        this.surname = dto.surname();
        this.description = dto.description();
        this.experienceVOS = dto.experienceVOS();
    }

    public void update(MainInfoDto createMainInfoDto) {
        if (createMainInfoDto.name() != null) this.name = createMainInfoDto.name();
        if (createMainInfoDto.surname() != null) this.surname = createMainInfoDto.surname();
        if (createMainInfoDto.description() != null) this.description = createMainInfoDto.description();
        if (createMainInfoDto.experienceVOS() != null) this.experienceVOS = createMainInfoDto.experienceVOS();
    }
}
