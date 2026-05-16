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

    private CartItemDto findItem(List<CartItemDto> cart, Integer productId, Integer size) {
        for (CartItemDto item : cart) {
            if (item.getProductId() == productId && item.getSize() == size) {
                return item;
            }
        }
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartItemDto item, HttpSession session) {

        List<CartItemDto> cart = (List<CartItemDto>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        CartItemDto existing = findItem(cart, item.getProductId(), item.getSize());

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            cart.add(item);
        }

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

    @PutMapping("/update")
    public ResponseEntity<?> updateQuantity(
            @RequestParam Integer productId,
            @RequestParam Integer size,
            @RequestParam Integer quantity,
            HttpSession session) {

        List<CartItemDto> cart =
                (List<CartItemDto>) session.getAttribute("cart");

        if (cart == null) return ResponseEntity.ok().build();

        CartItemDto existing = findItem(cart, productId, size);

        if (existing != null) {
            if (quantity <= 0) {
                cart.remove(existing);
            } else {
                existing.setQuantity(quantity);
            }
        }

        session.setAttribute("cart", cart);

        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFromCart(
            @RequestParam Integer productId,
            @RequestParam Integer size,
            HttpSession session) {

        List<CartItemDto> cart =
                (List<CartItemDto>) session.getAttribute("cart");

        if (cart == null) return ResponseEntity.ok().build();

        cart.removeIf(item ->
                item.getProductId() == productId && item.getSize() == size
        );

        session.setAttribute("cart", cart);

        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/clear-cart")
    public void clearCart(HttpSession session) {
        session.removeAttribute("cart");
    }
}
