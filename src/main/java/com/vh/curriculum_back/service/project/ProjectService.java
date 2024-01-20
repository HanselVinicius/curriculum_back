package com.vh.curriculum_back.service.project;

import com.vh.curriculum_back.models.projects.ProjectRepository;
import com.vh.curriculum_back.models.projects.dto.ProjectListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Page<ProjectListDto> getProjects(Pageable pageable){
        return projectRepository.findAll(pageable).map(ProjectListDto::new);
    }


}
