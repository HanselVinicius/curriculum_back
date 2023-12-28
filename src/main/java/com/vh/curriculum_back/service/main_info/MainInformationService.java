package com.vh.curriculum_back.service.main_info;

import com.vh.curriculum_back.models.main_info.MainInformation;
import com.vh.curriculum_back.models.main_info.MainInformationRepository;
import com.vh.curriculum_back.models.main_info.dto.DetailMainInfoDto;
import com.vh.curriculum_back.models.main_info.dto.MainInfoDto;
import com.vh.curriculum_back.models.main_info.dto.ListagemMainInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class MainInformationService implements Serializable {

    @Autowired
    private MainInformationRepository mainInformationRepository;


    public Page<ListagemMainInfoDto> getAllPaginated(Pageable pageable) {
        return mainInformationRepository.findAll(pageable).map(ListagemMainInfoDto::new);
    }


    public MainInformation getOneById(Long id) {
        return this.mainInformationRepository.findById(id).get();
    }

    public MainInformation create(MainInfoDto createMainInfoDto) {
        MainInformation mainInformation = new MainInformation(createMainInfoDto);
        return this.mainInformationRepository.save(mainInformation);
    }

    public DetailMainInfoDto update(Long id, MainInfoDto createMainInfoDto) {
        MainInformation referenceById = this.mainInformationRepository.getReferenceById(id);
        referenceById.update(createMainInfoDto);
        return new DetailMainInfoDto(referenceById);
    }

    public void delete(Long id) {
        this.mainInformationRepository.deleteById(id);
    }
}
