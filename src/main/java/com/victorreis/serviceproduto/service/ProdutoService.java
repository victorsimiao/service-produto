package com.victorreis.serviceproduto.service;

import com.victorreis.serviceproduto.model.Produto;

public interface ProdutoService {

    Produto inserir(Produto produto);

    Produto buscarPorId(Long id);
}
