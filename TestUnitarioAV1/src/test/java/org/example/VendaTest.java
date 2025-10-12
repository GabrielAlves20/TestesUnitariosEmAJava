package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendaTest {

    private Produto produto;
    Venda venda;

    @BeforeEach
    void setUp() {
        produto = new Produto("cebola", 10.0, 5);

    }
    @Test
    void deveTestarVendaComQuantiaMenorQueEstoque(){

        venda = new Venda(produto, 3);
        assertTrue(venda.realizarVenda());

    }

    @Test
    void deveTestarVendaComQuantiaIgualAoEstoque(){

        venda = new Venda(produto, 5);
        assertTrue(venda.realizarVenda());

    }
    @Test
    void deveTestarVendaComQuantiaMaiorQueoEstoque(){

        venda = new Venda(produto, 6);
        assertFalse(venda.realizarVenda());

    }
    @Test
    void deveTestarCalculoTotalCorretamente(){

        venda = new Venda(produto, 3);
        venda.realizarVenda();
        assertEquals(30.0, venda.getTotalVenda());

    }

    @Test
    void deveTestarAumentoEstoqueAposVenda(){

        venda = new Venda(produto, 3);
        assertTrue(venda.realizarVenda());

        produto.aumentarEstoque(6);
        assertEquals(8, produto.getEstoque());
    }

    @Test
    void deveTestarDiminuicaoDoEstoqueAposVendaValida(){

        venda = new Venda(produto, 4);
        venda.realizarVenda();
        assertEquals(1, produto.getEstoque());
    }

    @Test
    void deveTestarVendaProdutoInexistente(){

        Produto inexistente = new Produto("Inexistente", 0.0, 0);
        venda = new Venda(inexistente, 4);

        assertFalse(venda.realizarVenda());
    }

    @Test
    void deveTestarVendaQuantidadeNegativa(){

        venda = new Venda(produto, -1);
        assertTrue(venda.realizarVenda());
    }

    @Test
    void deveTestarAlteracaoEstoqueAposTentativaComEstoqueInsuficiente(){

        venda = new Venda(produto, 6);
        venda.realizarVenda();

        assertEquals(5, produto.getEstoque());
    }

    @Test
    void deveTestarCriacaoVariosProdutosEVendasComEstoqueCompartilhado(){

        Produto prod1 = new Produto("Maçã", 9.0, 15);
        venda = new Venda(prod1, 5);
        venda.realizarVenda();
        venda = new Venda(prod1, 5);
        venda.realizarVenda();

        venda = new Venda(produto, 2);
        venda.realizarVenda();
        venda = new Venda(produto, 2);
        venda.realizarVenda();

        assertEquals(5, prod1.getEstoque());
        assertEquals(1, produto.getEstoque());
    }

    @Test
    void deveTestarCalcularTotalQuandoAlterarOPrecoAntesDaVenda(){

        double preco = 15.0;
        produto.setPreco(preco);
        venda = new Venda(produto, 3);
        venda.realizarVenda();
        assertEquals(venda.getQuantidadeVendida() * preco, venda.getTotalVenda());

    }

    @Test
    void deveTestarComportamentoVendaComEstoqueInicialZero(){

        Produto prod1 = new Produto("Maçã", 9.0, 0);
        prod1.setEstoque(5);
        venda = new Venda(prod1, 3);
        venda.realizarVenda();
        assertEquals(2, venda.getProduto().getEstoque());

    }

    @Test
    void deveTestarVendaAposAumentoNoEstoque(){

        produto.aumentarEstoque(10);
        venda = new Venda(produto, 14);
        venda.realizarVenda();
        assertEquals(1, venda.getProduto().getEstoque());

    }


}
