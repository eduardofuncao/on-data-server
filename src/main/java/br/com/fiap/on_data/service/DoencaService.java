package br.com.fiap.on_data.service;

import br.com.fiap.on_data.controller.DTO.DoencaDTO;
import br.com.fiap.on_data.mapper.DoencaMapper;
import br.com.fiap.on_data.model.Doenca;
import br.com.fiap.on_data.repository.DoencaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoencaService {
    @Autowired
    private DoencaRepository doencaRepository;


    @Autowired
    private DoencaMapper doencaMapper;

    @Transactional
    public DoencaDTO saveDoenca(DoencaDTO doencaDTO) {
        Doenca doenca = doencaMapper.DoencaFromDTO(doencaDTO);
        return doencaMapper.DoencaToDTO(doencaRepository.save(doenca));
    }

    public List<DoencaDTO> getAllDoencas() {
        List<Doenca> doencas = doencaRepository.findAll();
        return doencas.stream()
                .map(doenca -> doencaMapper.DoencaToDTO(doenca))
                .collect(Collectors.toList());
    }

    public DoencaDTO getDoencaById(int id) {
        Doenca doenca = doencaRepository.findById(id).orElse(null);
        return doencaMapper.DoencaToDTO(doenca);
    }

    public DoencaDTO updateDoencaById(int id, DoencaDTO doencaDTO) {
        Doenca doencaToUpdate = doencaRepository.findById(id).orElse(null);
        doencaToUpdate.setNomeDoenca(doencaDTO.getNomeDoenca());
        return doencaMapper.DoencaToDTO(doencaRepository.save(doencaToUpdate));
    }

    public void deleteDoencaById(int id) {
        doencaRepository.deleteById(id);
    }
}

