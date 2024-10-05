package br.com.fiap.on_data.model;

import br.com.fiap.on_data.controller.DTO.DoencaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="doenca")
public class Doenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoenca;

    @Column(name = "nome_doenca")
    private String nomeDoenca;

    // methods
    public DoencaDTO toDTO() {
        DoencaDTO doencaDTO = new DoencaDTO();
        doencaDTO.setIdDoenca(this.idDoenca);
        doencaDTO.setNomeDoenca(this.nomeDoenca);
        return doencaDTO;
    }
}
