package br.com.fiap.on_data.model;

import br.com.fiap.on_data.controller.DTO.OcorrenciaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="ocorrencia")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoOcorrencia;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "valor")
    private double valor;

    @Column(name = "duracao")
    private int duracao;

    @Column(name = "aprovado")
    private boolean aprovado;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false) // Este é o campo que cria a foreign key
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_doenca", nullable = false)
    private Doenca doenca;

    // methods
    public OcorrenciaDTO toDTO() {
        OcorrenciaDTO ocorrenciaDTO = new OcorrenciaDTO();
        ocorrenciaDTO.setCodigoOcorrencia(this.codigoOcorrencia);
        ocorrenciaDTO.setData(this.data);
        ocorrenciaDTO.setValor(this.valor);
        ocorrenciaDTO.setDuracao(this.duracao);
        ocorrenciaDTO.setAprovado(this.aprovado);
        ocorrenciaDTO.setIdPaciente(this.paciente.getId());
        ocorrenciaDTO.setIdDoenca(this.doenca.getIdDoenca());
        return ocorrenciaDTO;
    }
}
