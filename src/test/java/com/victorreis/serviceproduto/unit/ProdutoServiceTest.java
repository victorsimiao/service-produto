package com.victorreis.serviceproduto.unit;

import com.victorreis.serviceproduto.model.Produto;
import com.victorreis.serviceproduto.repository.ProdutoRepository;
import com.victorreis.serviceproduto.service.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.NoResultException;
import java.util.Optional;

import static com.victorreis.serviceproduto.utils.GeradorDadosTest.novoProduto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
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
    void deveCadastrarProdutoComSucesso() {
        Produto produto = novoProduto();
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto victim = produtoService.inserir(produto);

        assertEquals(produto.getDescricao(), victim.getDescricao());
        assertEquals(produto.getValor(), victim.getValor());
    }


    @Test
    @DisplayName("Buscar por um Produto")
    void deveBuscarPorUmProduto() {
        Produto produto = novoProduto();
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Produto victim = produtoService.buscarPorId(1L);

        verify(produtoRepository, times(1)).findById(1l);
        assertEquals(produto.getDescricao(), victim.getDescricao());
        assertEquals(produto.getValor(), victim.getValor());

    }


    @Test
    @DisplayName("Lanca Exception ao buscar por produto inexistente")
    void deveLancaExceptionNaBuscaProdutoInexistente(){
        when(produtoRepository.findById(anyLong())).thenReturn(Optional.empty());

        NoResultException exception = assertThrows(NoResultException.class, () -> produtoService.buscarPorId(anyLong()));

    }


}
