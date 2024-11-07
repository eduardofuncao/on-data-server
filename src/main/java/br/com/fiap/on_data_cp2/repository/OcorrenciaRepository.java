package br.com.fiap.on_data_cp2.repository;

import br.com.fiap.on_data_cp2.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}
