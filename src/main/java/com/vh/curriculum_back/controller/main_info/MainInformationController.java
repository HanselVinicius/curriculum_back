package com.vh.curriculum_back.controller.main_info;

import com.vh.curriculum_back.models.main_info.MainInformation;
import com.vh.curriculum_back.models.main_info.dto.MainInfoDto;
import com.vh.curriculum_back.service.main_info.MainInformationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/main-info")
public class MainInformationController {

    @Autowired
    private MainInformationService mainInformationService;

    @GetMapping
    @Description("Pega todas as informações principais paginadas sobre mim.")
    public ResponseEntity getAll(@PageableDefault(size = 10, page = 0) Pageable pageable){
        return ResponseEntity.ok(mainInformationService.getAllPaginated(pageable));
    }

    @GetMapping("/{id}")
    @Description("Pega uma informação principal sobre mim.")
    public ResponseEntity get(@PathVariable Long id){
        return ResponseEntity.ok(mainInformationService.getOneById(id));
    }

    @PostMapping
    @Description("Cria uma nova informação principal sobre mim.")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity create(@RequestBody MainInfoDto createMainInfoDto, UriComponentsBuilder uriComponentsBuilder){
        MainInformation mainInformation = this.mainInformationService.create(createMainInfoDto);
        URI endereco = uriComponentsBuilder.path("/v1/main-info/{id}").buildAndExpand(mainInformation.getId()).toUri();
        return ResponseEntity.created(endereco).body(mainInformation);
    }


    @PutMapping("/{id}")
    @Description("Atualiza uma informação principal sobre mim.")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity update(@PathVariable Long id, @RequestBody MainInfoDto createMainInfoDto){
        return ResponseEntity.ok(this.mainInformationService.update(id, createMainInfoDto));
    }

    @DeleteMapping("/{id}")
    @Description("Deleta uma informação principal sobre mim.")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity delete(@PathVariable Long id){
        this.mainInformationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
