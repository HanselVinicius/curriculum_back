package com.vh.curriculum_back.service.main_info;

import com.vh.curriculum_back.models.main_info.MainInformationRepository;
import com.vh.curriculum_back.models.main_info.dto.ListagemMainInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MainInformationService {

    @Autowired
    private MainInformationRepository mainInformationRepository;


    public Page<ListagemMainInfoDto> getAllPaginated(Pageable pageable) {
        return mainInformationRepository.findAll(pageable).map(ListagemMainInfoDto::new);
    }
}
