package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto("Maçã", 10.0, 1);
    }

    @Test
    void deveTestarCriacaoDeProdutos(){

        assertEquals("Maçã", produto.getNome());
        assertEquals(10.0, produto.getPreco());
        assertEquals(1, produto.getEstoque());

    }
    @Test
    void deveTestarCriacaoDeProdutoComPrecoNegativo() {
        Produto produtoNegativo = new Produto("Maçã", -10.0, 1);

        assertEquals("Maçã", produtoNegativo.getNome());
        assertEquals(-10.0, produtoNegativo.getPreco());
        assertEquals(1, produtoNegativo.getEstoque());
    }
    @Test
    void deveTestarCriacaoDeProdutoComEstoqueNegativo() {
        Produto produtoNegativo = new Produto("Maçã", 10.0, -1);

        assertEquals("Maçã", produtoNegativo.getNome());
        assertEquals(10.0, produtoNegativo.getPreco());
        assertEquals(-1, produtoNegativo.getEstoque());
    }
    @Test
    void deveTestarTrocaDeNomeValido(){

        String nome = "Banana";
        produto.setNome(nome);
        assertEquals(nome, produto.getNome());
    }
    @Test
    void deveTestarTrocaDePrecoValido(){

        double preco = 11.0;
        produto.setPreco(preco);
        assertEquals(preco, produto.getPreco());

    }
    @Test
    void deveTestarTrocaDeEstoqueValido(){

        int estoque = 5;
        produto.setEstoque(estoque);

        assertEquals(estoque, produto.getEstoque());

    }
    @Test
    void deveTestarTrocaDePrecoNegativo(){

        double preco = -11.0;
        produto.setPreco(preco);
        assertEquals(preco, produto.getPreco());

    }

}
