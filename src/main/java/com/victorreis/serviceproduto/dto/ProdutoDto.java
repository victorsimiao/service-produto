package com.victorreis.serviceproduto.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProdutoDto {

    private Long id;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
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
