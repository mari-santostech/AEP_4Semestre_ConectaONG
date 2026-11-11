package com.conectaong.repository;

import com.conectaong.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

    // histórico por doador
    List<Doacao> findByDoadorId(Integer idDoador);

    // histórico por ONG
    List<Doacao> findByEntidadeBeneficenteId(Integer idEntidade);

}