package br.com.fiap.on_data.service;

import br.com.fiap.on_data.controller.DTO.PacienteDTO;
import br.com.fiap.on_data.exception.DuplicatePacienteException;
import br.com.fiap.on_data.exception.PacienteNotFoundException;
import br.com.fiap.on_data.mapper.PacienteMapper;
import br.com.fiap.on_data.model.Paciente;
import br.com.fiap.on_data.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//TODO implementar a anotação @Trasactional e considerar DTO

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;


    @Autowired
    private PacienteMapper pacienteMapper;

    @Transactional
    public PacienteDTO savePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.PacienteFromDTO(pacienteDTO);
        long idp = paciente.getId();
        if(pacienteRepository.existsById(idp)){
            throw new DuplicatePacienteException("Paciente com id " + idp + " já existe");
        }
        return pacienteMapper.PacienteToDTO(pacienteRepository.save(paciente));
    }

    public List<PacienteDTO> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> pacienteMapper.PacienteToDTO(paciente))
                .toList();
    }

    public PacienteDTO getPacienteById(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException("Paciente com o id " + id + " não encontrado"));
        return pacienteMapper.PacienteToDTO(paciente);
    }

    public PacienteDTO updatePacienteById(long id, PacienteDTO pacienteDTO) {
        Paciente pacienteToUpdate = pacienteRepository.findById(id).orElse(null);
        pacienteToUpdate.setNome(pacienteDTO.getNome());
        pacienteToUpdate.setEmail(pacienteDTO.getEmail());
        pacienteToUpdate.setTelefone(pacienteDTO.getTelefone());
        pacienteToUpdate.setEndereco(pacienteDTO.getEndereco());
        pacienteToUpdate.setFumante(pacienteDTO.isFumante());
        return pacienteMapper.PacienteToDTO(pacienteRepository.save(pacienteToUpdate));
    }

    public void deletePacienteById(long id) {
        pacienteRepository.deleteById(id);
    }
}
