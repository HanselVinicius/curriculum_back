package com.vh.curriculum_back.service.project;

import com.vh.curriculum_back.models.projects.Project;
import com.vh.curriculum_back.models.projects.ProjectRepository;
import com.vh.curriculum_back.models.projects.dto.ProjectCreateDto;
import com.vh.curriculum_back.models.projects.dto.ProjectListDto;
import com.vh.curriculum_back.models.projects.dto.ProjectUpdateDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Page<ProjectListDto> getProjects(Pageable pageable){
        return this.projectRepository.findAll(pageable).map(ProjectListDto::new);
    }

    public Project getProjectById(Long id){
        return this.projectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Project createProject(ProjectCreateDto projectCreateDto){
        return this.projectRepository.save(new Project(projectCreateDto));
    }


    public void deleteProject(Long id) {
        this.projectRepository.deleteById(id);
    }

    public Project updateProject(Long id, ProjectUpdateDto projectUpdateDto) {
        Project project = new Project(projectUpdateDto);
        project.setId(id);
        return this.projectRepository.save(project);
    }
}
