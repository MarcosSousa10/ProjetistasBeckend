package com.br.Projetistas.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.Projetistas.Model.Historico;

public interface RepositoryHistorico extends CrudRepository<Historico,Long>{
    @Query(value = "select * from othon.othon_hist_projetos", nativeQuery = true)
    List<Historico> consultartudo();
    @Query(value = "select num_projeto,TO_CHAR(data_acao, 'DD/MM/YYYY') AS data_acao,descricao,responsavel from othon.othon_hist_projetos where num_projeto =?", nativeQuery = true)
    List<Historico> consultarNumero(String numero);
}
