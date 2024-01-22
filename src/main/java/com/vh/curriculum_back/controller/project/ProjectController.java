package com.vh.curriculum_back.controller.project;

import com.vh.curriculum_back.models.projects.Project;
import com.vh.curriculum_back.models.projects.dto.ProjectCreateDto;
import com.vh.curriculum_back.models.projects.dto.ProjectUpdateDto;
import com.vh.curriculum_back.service.project.ProjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity getProjects(@PageableDefault(size = 10,page = 0) Pageable pageable){
        return ResponseEntity.ok().body(this.projectService.getProjects(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity getProjectById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.projectService.getProjectById(id));
    }

    @PostMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity createProject(@RequestBody ProjectCreateDto projectCreateDto, UriComponentsBuilder uriComponentsBuilder){
        Project project = this.projectService.createProject(projectCreateDto);
        URI uri = uriComponentsBuilder.path("/v1/projects/{id}").buildAndExpand(project.getId()).toUri();
        return ResponseEntity.created(uri).body(project);
    }

    @PutMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity updateProject(@PathVariable Long id, @RequestBody ProjectUpdateDto projectTransactionDto){
        return ResponseEntity.ok().body(this.projectService.updateProject(id, projectTransactionDto));
    }



    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public void deleteProject(@PathVariable Long id){
        this.projectService.deleteProject(id);
    }



}
