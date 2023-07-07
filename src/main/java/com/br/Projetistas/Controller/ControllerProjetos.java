package com.br.Projetistas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.br.Projetistas.Model.Historico;
import com.br.Projetistas.Model.Projetos;
import com.br.Projetistas.Repository.RepositoryHistorico;
import com.br.Projetistas.Repository.RepositoryProjetos;

@RestController
@CrossOrigin("*")
public class ControllerProjetos {
    @Autowired
    private RepositoryProjetos projetos;
    @Autowired
    private RepositoryHistorico historico;

    @GetMapping("/tudoProjetos")
    public List<Projetos> obterProjetos() {
        return projetos.consultartudo();
    }

    @GetMapping("/Historico/{codigo}")
public ResponseEntity<?> findCode(@PathVariable String codigo) {
    List<Historico> list = historico.consultarNumero(codigo);
    
        return new ResponseEntity<>(list, HttpStatus.valueOf(202));

}

    @GetMapping("/tudoHistorico")
    public List<Historico> obterhistoricoProjetos() {
        return historico.consultartudo();
    }
}
