package com.vh.curriculum_back.models.projects;

import com.vh.curriculum_back.models.projects.dto.ProjectCreateDto;
import com.vh.curriculum_back.models.projects.dto.ProjectUpdateDto;
import com.vh.curriculum_back.models.vo.tecnologia.TecnologiaVo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String link;
    @OneToMany(
            cascade=CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "project_id")
    private List<TecnologiaVo> technologies = new ArrayList<>();



    public Project(ProjectCreateDto projectCreateDto) {
        this.name = projectCreateDto.name();
        this.description = projectCreateDto.description();
        this.link = projectCreateDto.link();
        projectCreateDto.technologies().forEach(createTecnologiaVoDto -> this.technologies.add(new TecnologiaVo(createTecnologiaVoDto)));
    }

    public Project(ProjectUpdateDto projectUpdateDto) {
        this.name = projectUpdateDto.name();
        this.description = projectUpdateDto.description();
        this.link = projectUpdateDto.link();
        this.technologies = projectUpdateDto.technologies();
    }


}
