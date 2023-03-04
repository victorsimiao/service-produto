package com.victorreis.serviceproduto.unit;

import com.victorreis.serviceproduto.model.Produto;
import com.victorreis.serviceproduto.repository.ProdutoRepository;
import com.victorreis.serviceproduto.service.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.victorreis.serviceproduto.utils.GeradorDadosTest.novoProduto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest extends BaseUnitTest {

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setupEach() {
        produtoService = new ProdutoServiceImpl(produtoRepository);
    }

    @Test
    @DisplayName("Cadastra produto com  sucesso")
    void deveCadastrarProdutoComSucesso(){
        Produto produto = novoProduto();
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto victim = produtoService.inserir(produto);

        assertEquals(produto.getDescricao(),victim.getDescricao());
        assertEquals(produto.getValor(),victim.getValor());
    }


}
