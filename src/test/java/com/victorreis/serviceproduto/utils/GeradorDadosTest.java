package com.victorreis.serviceproduto.utils;

import com.victorreis.serviceproduto.model.Produto;

import static com.victorreis.serviceproduto.utils.ConstantsTest.*;

public final class GeradorDadosTest {

    private GeradorDadosTest() {}


    public static Produto novoProduto(){
        return new Produto(DEFAULT_DESCRICAO, DEFAULT_PRECO);
    }
}
