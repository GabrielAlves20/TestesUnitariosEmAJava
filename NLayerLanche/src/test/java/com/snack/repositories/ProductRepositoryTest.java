package com.snack.repositories;

import com.snack.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;



import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository productRepository;
    private Product product1;

    @BeforeEach
    public void setup() {
        productRepository = new ProductRepository();
        product1 = new Product(1, "Hot Dog", 10.4f, "");
        productRepository.append(product1);
    }

    // 1. Verificar se um produto é adicionado corretamente ao repositório
    @Test
    public void verificarSeOProdutoEstaNoArray() {

        Product productId1 = productRepository.getById(1);
        assertNotNull(productId1);
    }

    // Verificar se é possível recuperar um produto usando seu ID
    @Test
    public void verificarRetornoPorId() {

        Product productVerificar = productRepository.getById(1);

        assertEquals(productVerificar.getId(), product1.getId());
        assertEquals(productVerificar.getDescription(), product1.getDescription());
        assertEquals(productVerificar.getPrice(), product1.getPrice());
        assertEquals(productVerificar.getImage(), product1.getImage());
    }

    // Confirmar se um produto existe no repositório (List)
    @Test
    public void verificarSeProdutoExiste() {

        assertTrue(productRepository.exists(1));
    }

    // Testar se um produto é removido corretamente do repositório (List)
    @Test
    public void testarRemoverProdutos() {

        productRepository.remove(1);
        assertFalse(productRepository.exists(1));
    }

    // Verificar se um produto é atualizado corretamente
    @Test
    public void verificarSeProdutoAtualizaCorretamente() {
        Product product2 = new Product(1, "Batata frita", 11.2f, "");
        productRepository.update(1, product2);

        assertEquals(product2.getDescription(),productRepository.getById(1).getDescription() );
        assertEquals( product2.getPrice(),productRepository.getById(1).getPrice());
        assertEquals( product2.getImage(),productRepository.getById(1).getImage());

    }

    // Testar se todos os produtos armazenados são recuperados corretamente
    @Test
    public void testarSeTodosOsProdutosRetornam() {

        Product product2 = new Product(2, "Batata frita", 11.2f, "");
        productRepository.append(product2);

        //Aqui eu to vendo se o produto um e dois estão contidos no arraylist products
        assertTrue(productRepository.getAll().contains(product1));
        assertTrue(productRepository.getAll().contains(product2));
    }


    // Verificar o comportamento ao tentar remover um produto que não existe
    @Test
    public void tentarRemoverProdutosInexistentes() {

        productRepository.remove(3);
        assertEquals(1, productRepository.getAll().size());

    }

    //Testar o que acontece ao tentar atualizar um produto que não está no repositório(List)
    @Test
    public void tentarAtualizarProdutosInexistentes() {

        Product produtoNaoExistente = new Product(3, "Batata frita", 11.2f, "");

        assertThrows(NoSuchElementException.class, () -> {
            productRepository.update(3, produtoNaoExistente);
        });

    }

    // Verificar se o repositório aceita a adição de produtos com IDs duplicados (espera-se que não)
    @Test
    public void tentarAdicionarProdutosComIdIguais() {

        Product product2 = new Product(1, "Batata frita", 11.2f, "");
        productRepository.append(product2);

        assertEquals(1, productRepository.getAll().size());

    }

    // Confirmar que o repositório retorna uma lista vazia ao ser inicializado(List)
    @Test
    public void testarQueListaRetornaVazia() {

    ProductRepository testeListaVazia = new ProductRepository();
        assertEquals(0, testeListaVazia.getAll().size());

    }

}
