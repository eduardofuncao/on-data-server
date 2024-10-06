package br.com.fiap.on_data.controller;

import br.com.fiap.on_data.controller.DTO.DoencaDTO;
import br.com.fiap.on_data.service.DoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DoencaController {

    @Autowired
    private DoencaService doencaService;

    @PostMapping("/doencas")
    public ResponseEntity<DoencaDTO> createDoenca(@RequestBody DoencaDTO doencaDTO) {
        return ResponseEntity.ok(doencaService.saveDoenca(doencaDTO));
    }

    @GetMapping("/doencas")
    public ResponseEntity<List<DoencaDTO>> getAllDoencas() {
        return ResponseEntity.ok(doencaService.getAllDoencas());
    }

    @GetMapping("/doencas/{id}")
    public ResponseEntity<DoencaDTO> getDoencaById(@PathVariable int id) {
        return ResponseEntity.ok(doencaService.getDoencaById(id));
    }

    @PutMapping("/doencas/{id}")
    public ResponseEntity<DoencaDTO> updateDoenca(@PathVariable int id, @RequestBody DoencaDTO doencaDTO) {
        return ResponseEntity.ok(doencaService.updateDoencaById(id, doencaDTO));
    }

    @DeleteMapping("/doencas/{id}")
    public ResponseEntity<Void> deleteDoenca(@PathVariable int id) {
        doencaService.deleteDoencaById(id);
        return ResponseEntity.noContent().build();
    }
}

