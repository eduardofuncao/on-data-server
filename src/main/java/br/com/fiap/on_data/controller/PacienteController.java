package br.com.fiap.on_data.controller;

import br.com.fiap.on_data.controller.DTO.PacienteDTO;
import br.com.fiap.on_data.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PacienteController {
    // TODO implementar pageable
    // TODO colocar validação no dto, e usar @valid no controller

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/pacientes")
    public ResponseEntity<PacienteDTO> createPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.savePaciente(pacienteDTO));
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.getPacienteById(id));
    }

    @PutMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.updatePacienteById(id, pacienteDTO));
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePacienteById(id);
        return ResponseEntity.noContent().build();
    }
}
