package com.example.carrito_compra.service;

import java.util.List;
import com.example.carrito_compra.entity.*;

public interface ShopService {
  // Products
  List<Product> findAllProducts();
  Product createProduct(Product p);
  Product getProduct(Long id);

  // Cart
  List<CartItem> getCart(String sessionId);
  void addToCart(String sessionId, Long productId, int qty);
  void removeFromCart(String sessionId, Long productId);
  double total(String sessionId);
  void clearCart(String sessionId);
}
