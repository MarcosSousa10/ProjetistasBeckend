package com.br.Projetistas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="othon_hist_projetos")
public class Historico {
    @Id
      private String descricao;

  private Long num_projeto;
  private String data_acao;
  private String responsavel;


}
