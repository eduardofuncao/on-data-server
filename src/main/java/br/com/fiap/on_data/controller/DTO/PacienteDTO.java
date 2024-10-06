package br.com.fiap.on_data.controller.DTO;

import br.com.fiap.on_data.model.Paciente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteDTO {

    private int id;

    @Size(min = 11, max = 11, message = "CPF precisa ter exatamente 11 dígitos")
    @NotBlank(message = "CPF não pode estar vazio")
    private String cpf;

    @Size(min = 3, max = 100, message = "Nome precisa ter de 3 a 100 caracteres")
    @NotBlank(message = "Nome não pode estar vazio")
    private String nome;

    @Email(message = "Email com formato inválido")
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
