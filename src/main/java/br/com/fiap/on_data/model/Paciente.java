package br.com.fiap.on_data.model;

import br.com.fiap.on_data.controller.DTO.PacienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "fumante")
    private boolean fumante;

    // methods
    public PacienteDTO toDTO() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(this.id);
        pacienteDTO.setCpf(this.cpf);
        pacienteDTO.setNome(this.nome);
        pacienteDTO.setEmail(this.email);
        pacienteDTO.setTelefone(this.telefone);
        pacienteDTO.setEndereco(this.endereco);
        pacienteDTO.setFumante(this.fumante);
        return pacienteDTO;
    }
}
