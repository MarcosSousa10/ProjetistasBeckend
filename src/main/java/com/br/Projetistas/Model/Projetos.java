package com.br.Projetistas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "othon_projetos")
public class Projetos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long num_projeto;
    private Integer num_orcamento;
    private String cliente;
    private String status;
    private String data;
    private String projetista_responsavel;
  
    
}
