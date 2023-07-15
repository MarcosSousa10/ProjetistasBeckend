package com.br.Projetistas.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.Projetistas.Model.Historico;
import com.br.Projetistas.Model.Projetos;
import com.br.Projetistas.Repository.RepositoryHistorico;
import com.br.Projetistas.Repository.RepositoryProjetos;
import com.br.Projetistas.services.RelatorioVendasService;

@RestController
@CrossOrigin("*")
public class ControllerProjetos {
    @Autowired
    private RepositoryProjetos projetos;
    @Autowired
    private RepositoryHistorico historico;
@Autowired
	private RelatorioVendasService relatorioVendasService;
    	@GetMapping("/relatorio")
	public ResponseEntity<byte[]> relatorioVendas(
			@RequestParam(value = "NumOrcamento", required = false, defaultValue = "") Long NumOrcamento
	){
		var relatorioGerado = relatorioVendasService.gerarRelatorio(NumOrcamento);
		var headers = new HttpHeaders();
		var fileName = "relatorio-vendas.pdf";
		headers.setContentDispositionFormData("inline; filename=\"" +fileName+ "\"", fileName);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		var responseEntity = new ResponseEntity<>(relatorioGerado, headers, HttpStatus.OK);
        
		return responseEntity ;
	}
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
