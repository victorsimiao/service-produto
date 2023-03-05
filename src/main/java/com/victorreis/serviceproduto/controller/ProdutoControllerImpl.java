package com.victorreis.serviceproduto.controller;

import com.victorreis.serviceproduto.dto.ProdutoDto;
import com.victorreis.serviceproduto.model.Produto;
import com.victorreis.serviceproduto.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoControllerImpl implements ProdutoController {

    private final ProdutoService produtoService;
    private final ModelMapper modelMapper;

    public ProdutoControllerImpl(ProdutoService produtoService, ModelMapper modelMapper) {
        this.produtoService = produtoService;
        this.modelMapper = modelMapper;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProdutoDto> inserir(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = produtoService.inserir(modelMapper.map(produtoDto, Produto.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(produto, ProdutoDto.class));
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable("id") Long id) {
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(modelMapper.map(produto, ProdutoDto.class));
    }
}
