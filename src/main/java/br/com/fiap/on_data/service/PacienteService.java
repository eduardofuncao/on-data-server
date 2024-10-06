package br.com.fiap.on_data.service;

import br.com.fiap.on_data.controller.DTO.PacienteDTO;
import br.com.fiap.on_data.exception.DuplicatePacienteException;
import br.com.fiap.on_data.exception.PacienteNotFoundException;
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

    @Transactional
    public PacienteDTO savePaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteDTO.toEntity();
        long idp = paciente.getId();
        if(pacienteRepository.existsById(idp)){
            throw new DuplicatePacienteException("Paciente com id " + idp + " já existe");
        }
        return pacienteRepository.save(paciente).toDTO();
    }

    public List<PacienteDTO> getAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> paciente.toDTO())
                .toList();
    }

    public PacienteDTO getPacienteById(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException("Paciente com o id " + id + " não encontrado"));
        return paciente.toDTO();
    }

    public PacienteDTO updatePacienteById(long id, PacienteDTO pacienteDTO) {
        Paciente pacienteToUpdate = pacienteRepository.findById(id);
        pacienteToUpdate.setNome(pacienteDTO.getNome());
        pacienteToUpdate.setEmail(pacienteDTO.getEmail());
        pacienteToUpdate.setTelefone(pacienteDTO.getTelefone());
        pacienteToUpdate.setEndereco(pacienteDTO.getEndereco());
        pacienteToUpdate.setFumante(pacienteDTO.isFumante());
        return pacienteRepository.save(pacienteToUpdate).toDTO();
    }

    public void deletePacienteById(long id) {
        pacienteRepository.deleteById(id);
    }
}
