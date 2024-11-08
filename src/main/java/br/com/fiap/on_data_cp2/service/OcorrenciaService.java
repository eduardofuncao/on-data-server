package br.com.fiap.on_data_cp2.service;

import br.com.fiap.on_data_cp2.controller.dto.OcorrenciaDTO;
import br.com.fiap.on_data_cp2.entity.Dentista;
import br.com.fiap.on_data_cp2.entity.Doenca;
import br.com.fiap.on_data_cp2.entity.Ocorrencia;
import br.com.fiap.on_data_cp2.entity.Paciente;
import br.com.fiap.on_data_cp2.repository.DentistaRepository;
import br.com.fiap.on_data_cp2.repository.DoencaRepository;
import br.com.fiap.on_data_cp2.repository.OcorrenciaRepository;
import br.com.fiap.on_data_cp2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private DentistaRepository dentistaRepository;

    public OcorrenciaDTO criarOcorrencia(OcorrenciaDTO ocorrenciaDTO) {
        Ocorrencia ocorrencia = convertToEntity(ocorrenciaDTO);

        Paciente paciente = pacienteRepository.findById(ocorrenciaDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Doenca doenca = doencaRepository.findById(ocorrenciaDTO.getDoencaId())
                        .orElseThrow(() -> new RuntimeException("Doença não encontrada"));

        Dentista dentista = dentistaRepository.findById(ocorrenciaDTO.getDentistaId())
                        .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));

        ocorrencia.setPaciente(paciente);
        ocorrencia.setDoenca(doenca);
        ocorrencia.setDentista(dentista);

        Ocorrencia savedOcorrencia = ocorrenciaRepository.save(ocorrencia);
        ocorrenciaDTO.setId(savedOcorrencia.getId());
        return ocorrenciaDTO;
    }

    public List<OcorrenciaDTO> listarOcorrencias() {
        return ocorrenciaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<OcorrenciaDTO> listarOcorrenciasAprovadas() {
        return ocorrenciaRepository.findByAprovadoTrue()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<OcorrenciaDTO> listarOcorrenciasReprovadas() {
        return ocorrenciaRepository.findByAprovadoFalse()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OcorrenciaDTO buscarOcorrenciaPorId(Long id) {
        Ocorrencia foundOcorrencia = ocorrenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica não encontrada"));
        return convertToDTO(foundOcorrencia);
    }

    public void deletarOcorrencia(Long id) {ocorrenciaRepository.deleteById(id);}

    public OcorrenciaDTO aprovarOcorrencia(Long id) {
        Ocorrencia foundOcorrencia = ocorrenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ocorrencia não encontrada"));
        foundOcorrencia.setAprovado(true);
        return convertToDTO(ocorrenciaRepository.save(foundOcorrencia));
    }

    private OcorrenciaDTO convertToDTO(Ocorrencia ocorrencia) {
        OcorrenciaDTO ocorrenciaDTO = new OcorrenciaDTO();
        ocorrenciaDTO.setId(ocorrencia.getId());
        ocorrenciaDTO.setData(ocorrencia.getData());
        ocorrenciaDTO.setCodigoOcorrencia(ocorrencia.getCodigoOcorrencia());
        ocorrenciaDTO.setValor(ocorrencia.getValor());
        ocorrenciaDTO.setDuracaoHoras(ocorrencia.getDuracaoHoras());

        return ocorrenciaDTO;
    }

    private Ocorrencia convertToEntity(OcorrenciaDTO ocorrenciaDTO) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setData(ocorrenciaDTO.getData());
        ocorrencia.setCodigoOcorrencia(ocorrenciaDTO.getCodigoOcorrencia());
        ocorrencia.setValor(ocorrenciaDTO.getValor());
        ocorrenciaDTO.setDuracaoHoras(ocorrenciaDTO.getDuracaoHoras());

        return ocorrencia;
    }
}
