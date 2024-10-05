package br.com.fiap.on_data.controller;

import br.com.fiap.on_data.controller.DTO.OcorrenciaDTO;
import br.com.fiap.on_data.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping("/ocorrencias")
    public ResponseEntity<OcorrenciaDTO> createOcorrencia(@RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ResponseEntity.ok(ocorrenciaService.saveOcorrencia(ocorrenciaDTO));
    }

    @GetMapping("/ocorrencias")
    public ResponseEntity<List<OcorrenciaDTO>> getAllOcorrencias() {
        return ResponseEntity.ok(ocorrenciaService.getAllOcorrencias());
    }

    @GetMapping("/ocorrencias/{id}")
    public ResponseEntity<OcorrenciaDTO> getOcorrenciaById(@PathVariable Long id) {
        return ResponseEntity.ok(ocorrenciaService.getOcorrenciaById(id));
    }

    @PutMapping("/ocorrencias/{id}")
    public ResponseEntity<OcorrenciaDTO> updateOcorrencia(@PathVariable Long id, @RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ResponseEntity.ok(ocorrenciaService.updateOcorrenciaById(id, ocorrenciaDTO));
    }

    @DeleteMapping("/ocorrencias/{id}")
    public ResponseEntity<Void> deleteOcorrencia(@PathVariable Long id) {
        ocorrenciaService.deleteOcorrenciaById(id);
        return ResponseEntity.noContent().build();
    }
}

