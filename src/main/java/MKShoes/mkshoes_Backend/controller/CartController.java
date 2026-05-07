package MKShoes.mkshoes_Backend.controller;

import MKShoes.mkshoes_Backend.dto.CartItemDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = {
        "https://mkshoes.netlify.app",
        "http://localhost:5176",
        "http://localhost:5173",
        "http://localhost:5174",
        "http://localhost:5175"},
        allowCredentials = "true")
public class CartController {
    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartItemDto item, HttpSession session) {

        List<CartItemDto> cart = (List<CartItemDto>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(item);

        session.setAttribute("cart", cart);

        return ResponseEntity.ok("Item added to cart");
    }

    @GetMapping
    public List<CartItemDto> getCart(HttpSession session) {
        List<CartItemDto> cart = (List<CartItemDto>) session.getAttribute("cart");

        if (cart == null) {
            return new ArrayList<>();
        }

        return cart;
    }

    @DeleteMapping("/clear-cart")
    public void clearCart(HttpSession session) {
        session.removeAttribute("cart");
    }
}
