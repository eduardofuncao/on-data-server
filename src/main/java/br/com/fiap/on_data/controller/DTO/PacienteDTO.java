package br.com.fiap.on_data.controller.DTO;

import br.com.fiap.on_data.model.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteDTO {

    private int id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private boolean fumante;

    // methods
    public Paciente toEntity() {
        Paciente paciente = new Paciente();
        paciente.setId(this.id);
        paciente.setCpf(this.cpf);
        paciente.setNome(this.nome);
        paciente.setEmail(this.email);
        paciente.setTelefone(this.telefone);
        paciente.setEndereco(this.endereco);
        paciente.setFumante(this.fumante);
        return paciente;
    }
}
