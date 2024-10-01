package br.com.fiap.on_data.repository;

import br.com.fiap.on_data.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findById(long id);
    List<Paciente> findByFumante(boolean fumante);
    List<Paciente> findByNomeContaining(String nome);
}
