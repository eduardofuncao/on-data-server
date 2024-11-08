package br.com.fiap.on_data_cp2.repository;

import br.com.fiap.on_data_cp2.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {
    Optional<Dentista> findByRegistro(String registro);
}