package br.com.fiap.on_data_cp2.repository;

import br.com.fiap.on_data_cp2.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
