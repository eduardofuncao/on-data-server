package br.com.fiap.on_data.controller.DTO;

import br.com.fiap.on_data.model.Ocorrencia;
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
    private int idPaciente;
    private int idDoenca;

    // methods
    public Ocorrencia toEntity() {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setCodigoOcorrencia(this.codigoOcorrencia);
        ocorrencia.setData(this.data);
        ocorrencia.setValor(this.valor);
        ocorrencia.setDuracao(this.duracao);
        ocorrencia.setAprovado(this.aprovado);
        return ocorrencia;
    }
}

