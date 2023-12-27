package com.vh.curriculum_back.controller.main_info;

import com.vh.curriculum_back.service.main_info.MainInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/main-info")
public class MainInformationController {

    @Autowired
    private MainInformationService mainInformationService;

    @GetMapping()
    public ResponseEntity getAll(@PageableDefault(size = 10, page = 0) Pageable pageable){
        return ResponseEntity.ok(mainInformationService.getAllPaginated(pageable));
    }



}
