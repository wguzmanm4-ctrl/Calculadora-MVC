package com.example.carrito_compra.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.carrito_compra.entity.*;
import com.example.carrito_compra.repository.*;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    
    private final ProductRepository products;
    private final CartItemRepository cartRepo;

    public ShopServiceImpl(ProductRepository products, CartItemRepository cartRepo) {
        this.products = products;
        this.cartRepo = cartRepo;
    }

    @Override 
    public List<Product> findAllProducts() { 
        return products.findAll(); 
    }
    
    @Override 
    public Product createProduct(Product p) { 
        return products.save(p); 
    }
    
    @Override 
    public Product getProduct(Long id) { 
        return products.findById(id).orElseThrow(); 
    }

    @Override 
    public List<CartItem> getCart(String sessionId) {
        return cartRepo.findBySessionId(sessionId);
    }

    @Override 
    public void addToCart(String sessionId, Long productId, int qty) {
        Product p = getProduct(productId);
        Optional<CartItem> itemExistente = cartRepo.findBySessionIdAndProductId(sessionId, productId);

        if (itemExistente.isPresent()) {
            CartItem item = itemExistente.get();
            item.setQuantity(item.getQuantity() + qty);
            cartRepo.save(item);
        } else {
            CartItem nuevo = CartItem.builder()
                .sessionId(sessionId)
                .productId(productId)
                .name(p.getName())
                .price(p.getPrice())
                .quantity(qty)
                .build();
            cartRepo.save(nuevo);
        }
    }

    @Override 
    public void removeFromCart(String sessionId, Long productId) {
        cartRepo.deleteBySessionIdAndProductId(sessionId, productId);
    }

    @Override 
    public double total(String sessionId) {
        return getCart(sessionId).stream()
            .mapToDouble(ci -> ci.getPrice() * ci.getQuantity())
            .sum();
    }

    @Override 
    public void clearCart(String sessionId) {
        cartRepo.deleteBySessionId(sessionId);
    }
}
