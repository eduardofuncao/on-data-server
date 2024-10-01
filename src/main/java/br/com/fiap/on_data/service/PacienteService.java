package br.com.fiap.on_data.service;

import br.com.fiap.on_data.model.Paciente;
import br.com.fiap.on_data.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//TODO implementar a anotação @Trasactional e considerar DTO

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public Paciente updatePacienteById(long id, Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletePacienteById(long id) {
        pacienteRepository.deleteById(id);
    }
}
