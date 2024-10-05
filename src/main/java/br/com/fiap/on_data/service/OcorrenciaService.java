package br.com.fiap.on_data.service;

import br.com.fiap.on_data.controller.DTO.OcorrenciaDTO;
import br.com.fiap.on_data.model.Ocorrencia;
import br.com.fiap.on_data.repository.OcorrenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Transactional
    public OcorrenciaDTO saveOcorrencia(OcorrenciaDTO ocorrenciaDTO) {
        Ocorrencia ocorrencia = ocorrenciaDTO.toEntity();
        return ocorrenciaRepository.save(ocorrencia).toDTO();
    }

    public List<OcorrenciaDTO> getAllOcorrencias() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        return ocorrencias.stream()
                .map(Ocorrencia::toDTO)
                .collect(Collectors.toList());
    }

    public OcorrenciaDTO getOcorrenciaById(Long id) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).orElse(null);
        return ocorrencia.toDTO();
    }

    public OcorrenciaDTO updateOcorrenciaById(long id, OcorrenciaDTO ocorrenciaDTO) {
        Ocorrencia ocorrenciaToUpdate = ocorrenciaRepository.findById(id).orElse(null);
        ocorrenciaToUpdate.setData(ocorrenciaDTO.getData());
        ocorrenciaToUpdate.setValor(ocorrenciaDTO.getValor());
        ocorrenciaToUpdate.setDuracao(ocorrenciaDTO.getDuracao());
        ocorrenciaToUpdate.setAprovado(ocorrenciaDTO.isAprovado());
        return ocorrenciaRepository.save(ocorrenciaToUpdate).toDTO();
    }

    public void deleteOcorrenciaById(long id) {
        ocorrenciaRepository.deleteById(id);
    }
}
