package br.com.fiap.on_data.service;

import br.com.fiap.on_data.controller.DTO.OcorrenciaDTO;
import br.com.fiap.on_data.mapper.OcorrenciaMapper;
import br.com.fiap.on_data.model.Doenca;
import br.com.fiap.on_data.model.Ocorrencia;
import br.com.fiap.on_data.model.Paciente;
import br.com.fiap.on_data.repository.DoencaRepository;
import br.com.fiap.on_data.repository.OcorrenciaRepository;
import br.com.fiap.on_data.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private DoencaRepository doencaRepository;

    private final OcorrenciaMapper ocorrenciaMapper = new OcorrenciaMapper();

    @Transactional
    public OcorrenciaDTO saveOcorrencia(OcorrenciaDTO ocorrenciaDTO) {

        Paciente paciente = pacienteRepository.findById(ocorrenciaDTO.getIdPaciente()).orElse(null);
        Doenca doenca = doencaRepository.findById(ocorrenciaDTO.getIdDoenca()).orElse(null);
        Ocorrencia ocorrencia = ocorrenciaMapper.ocorrenciaDtoToOcorrencia(ocorrenciaDTO, paciente, doenca);

        return ocorrenciaMapper.ocorrenciaToOcorrenciaDto(ocorrenciaRepository.save(ocorrencia));
    }

    public List<OcorrenciaDTO> getAllOcorrencias() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        return ocorrencias.stream()
                .map(ocorrencia -> ocorrenciaMapper.ocorrenciaToOcorrenciaDto(ocorrencia))
                .collect(Collectors.toList());
    }

    public OcorrenciaDTO getOcorrenciaById(Long id) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(id).orElse(null);
        return ocorrenciaMapper.ocorrenciaToOcorrenciaDto(ocorrencia);
    }

    public OcorrenciaDTO updateOcorrenciaById(long id, OcorrenciaDTO ocorrenciaDTO) {
        Ocorrencia ocorrenciaToUpdate = ocorrenciaRepository.findById(id).orElse(null);
        ocorrenciaToUpdate.setData(ocorrenciaDTO.getData());
        ocorrenciaToUpdate.setValor(ocorrenciaDTO.getValor());
        ocorrenciaToUpdate.setDuracao(ocorrenciaDTO.getDuracao());
        ocorrenciaToUpdate.setAprovado(ocorrenciaDTO.isAprovado());
        return ocorrenciaMapper.ocorrenciaToOcorrenciaDto(ocorrenciaRepository.save(ocorrenciaToUpdate));
    }

    public void deleteOcorrenciaById(long id) {
        ocorrenciaRepository.deleteById(id);
    }
}
