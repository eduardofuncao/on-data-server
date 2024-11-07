package br.com.fiap.on_data_cp2.controller;

import br.com.fiap.on_data_cp2.controller.dto.OcorrenciaDTO;
import br.com.fiap.on_data_cp2.repository.OcorrenciaRepository;
import br.com.fiap.on_data_cp2.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
    @Autowired
    private OcorrenciaService ocorrenciaService;
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @PostMapping
    ResponseEntity<OcorrenciaDTO> criarOcorrencia(@RequestBody OcorrenciaDTO ocorrenciaDTO){
        return ResponseEntity.ok(ocorrenciaService.criarOcorrencia(ocorrenciaDTO));
    }

    @GetMapping
    ResponseEntity<Page<OcorrenciaDTO>> listarOcorrencias(Pageable pageable){
        return ResponseEntity.ok(ocorrenciaService.listarOcorrencias(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaDTO> buscarOcorrenciaPorId(@PathVariable Long id){
        return ResponseEntity.ok(ocorrenciaService.buscarOcorrenciaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OcorrenciaDTO> atualizarOcorrencia(@PathVariable Long id, @RequestBody OcorrenciaDTO ocorrenciaAtualizada){
        OcorrenciaDTO ocorrenciaEncontrada = ocorrenciaService.buscarOcorrenciaPorId(id);
        ocorrenciaEncontrada.setCodigoOcorrencia(ocorrenciaAtualizada.getCodigoOcorrencia());
        ocorrenciaEncontrada.setData(ocorrenciaAtualizada.getData());
        ocorrenciaEncontrada.setValor(ocorrenciaAtualizada.getValor());
        ocorrenciaEncontrada.setDuracaoHoras(ocorrenciaAtualizada.getDuracaoHoras());
        ocorrenciaEncontrada.setDoencaId(ocorrenciaAtualizada.getDoencaId());
        ocorrenciaEncontrada.setDentistaId(ocorrenciaAtualizada.getDentistaId());
        ocorrenciaEncontrada.setPacienteId(ocorrenciaAtualizada.getPacienteId());
        return ResponseEntity.ok(ocorrenciaService.criarOcorrencia(ocorrenciaEncontrada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOcorrencia(@PathVariable Long id){
        ocorrenciaService.deletarOcorrencia(id);
        return ResponseEntity.noContent().build();
    }
}
