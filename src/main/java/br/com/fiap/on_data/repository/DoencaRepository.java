package br.com.fiap.on_data.repository;

import br.com.fiap.on_data.model.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Integer> {

}

