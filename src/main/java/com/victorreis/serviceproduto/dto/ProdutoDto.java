package com.victorreis.serviceproduto.dto;

import java.math.BigDecimal;

public class ProdutoDto {

    private Long id;

    private String descricao;

    private BigDecimal valor;


    public ProdutoDto() {
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
