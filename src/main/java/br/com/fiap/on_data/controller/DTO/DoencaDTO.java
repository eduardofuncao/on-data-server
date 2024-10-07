package br.com.fiap.on_data.controller.DTO;

import br.com.fiap.on_data.model.Doenca;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoencaDTO {

    private int idDoenca;
    private String nomeDoenca;

}
