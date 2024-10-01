package br.com.fiap.on_data.controller;

import br.com.fiap.on_data.model.Paciente;
import br.com.fiap.on_data.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PacienteController {
    // TODO implementar com dto
    // TODO implementar pageable

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/pacientes")
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.savePaciente(paciente));
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }
}
