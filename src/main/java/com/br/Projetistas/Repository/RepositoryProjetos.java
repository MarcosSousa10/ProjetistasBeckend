package com.br.Projetistas.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.Projetistas.Model.Projetos;


public interface RepositoryProjetos extends CrudRepository<Projetos, Long>{
    @Query(value = "select * from othon.othon_projetos", nativeQuery = true)
    List<Projetos> consultartudo();
}
