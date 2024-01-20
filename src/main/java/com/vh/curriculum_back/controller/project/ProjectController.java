package com.vh.curriculum_back.controller.project;

import com.vh.curriculum_back.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity getProjects(@PageableDefault(size = 10,page = 0) Pageable pageable){
        return ResponseEntity.ok().body(projectService.getProjects(pageable));
    }




}
