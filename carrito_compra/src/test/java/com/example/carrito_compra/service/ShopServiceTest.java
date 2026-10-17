package com.example.carrito_compra.service;

import com.example.carrito_compra.entity.Product;
import com.example.carrito_compra.entity.CartItem;
import com.example.carrito_compra.repository.ProductRepository;
import com.example.carrito_compra.repository.CartItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShopServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private ShopServiceImpl shopService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product productoFalso = Product.builder()
                .id(1L)
                .name("Tasa de prueba")
                .price(50.0)
                .build();

        when(productRepository.save(any(Product.class))).thenReturn(productoFalso);

        Product resultado = shopService.createProduct(productoFalso);

        assertNotNull(resultado);
        assertEquals("Tasa de prueba", resultado.getName());
        verify(productRepository, times(1)).save(productoFalso);
    }

    @Test
    void testFindAllProducts() {
        Product p1 = Product.builder().id(1L).name("Producto 1").price(10.0).build();
        Product p2 = Product.builder().id(2L).name("Producto 2").price(20.0).build();

        when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> lista = shopService.findAllProducts();

        assertEquals(2, lista.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testAddToCart() {
        Product p1 = Product.builder().id(1L).name("Producto 1").price(10.0).build();
        when(productRepository.findById(1L)).thenReturn(Optional.of(p1));
        
        when(cartItemRepository.findBySessionIdAndProductId("sesion123", 1L)).thenReturn(Optional.empty());

        shopService.addToCart("sesion123", 1L, 2);

        verify(cartItemRepository, times(1)).save(any(CartItem.class));
    }
}
