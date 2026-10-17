package com.example.carrito_compra.controller;

import com.example.carrito_compra.service.ShopService;
import com.example.carrito_compra.entity.Product;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/")
public class ShopController {
  private final ShopService service;

  public ShopController(ShopService service) { this.service = service; }

  // Catálogo
  @GetMapping
  public String index(Model model) {
    model.addAttribute("products", service.findAllProducts());
    model.addAttribute("productForm", new Product());
    return "index";
  }

  // Alta producto (admin simple)
  @PostMapping("product")
  public String create(@Valid @ModelAttribute("productForm") Product form, BindingResult br) {
    if (br.hasErrors()) return "index";
    service.createProduct(form);
    return "redirect:/";
  }

  // Carrito
  @PostMapping("cart/add")
  public String addToCart(@RequestParam Long productId, @RequestParam(defaultValue = "1") int qty, HttpSession session) {
    service.addToCart(session.getId(), productId, qty);
    return "redirect:/cart";
  }

  @GetMapping("cart")
  public String cart(HttpSession session, Model model) {
    model.addAttribute("items", service.getCart(session.getId()));
    model.addAttribute("total", service.total(session.getId()));
    return "cart";
  }

  @PostMapping("cart/remove")
  public String remove(@RequestParam Long productId, HttpSession session) {
    service.removeFromCart(session.getId(), productId);
    return "redirect:/cart";
  }

  @PostMapping("cart/checkout")
  public String checkout(HttpSession session) {
    service.clearCart(session.getId());
    return "redirect:/?ok";
  }
}
