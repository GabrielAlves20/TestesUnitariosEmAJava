package com.snack.repositories;

import com.snack.entities.Product;
import com.snack.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {
    private ProductService productService;
    private Product product1;

    @BeforeEach
    public void setup() {
        productService = new ProductService();

    }


    //Salvar um produto com imagem válida
    @Test
    public void testarSalvarUmProdutoComImagemValida(){
        product1 = new Product(1, "Hot Dog", 10.4f, "/home/gaab/Downloads/wp15177339-simple-clean-wallpapers.webp");

       assertTrue(productService.save(product1));

    }
    //Salvar um produto com imagem inexistente
    @Test
    public void testarSalvarUmProdutoComImagemInvalida(){
        product1 = new Product(1, "Hot Dog", 10.4f, "teste");

        assertFalse(productService.save(product1));

    }



}
