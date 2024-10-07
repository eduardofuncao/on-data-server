package br.com.fiap.on_data.controller.DTO;

import br.com.fiap.on_data.model.Doenca;
import br.com.fiap.on_data.model.Ocorrencia;
import br.com.fiap.on_data.repository.DoencaRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OcorrenciaDTO {

    private int codigoOcorrencia;
    private LocalDate data;
    private double valor;
    private int duracao;
    private boolean aprovado;
    private long idPaciente;
    private int idDoenca;

    // methods

}

