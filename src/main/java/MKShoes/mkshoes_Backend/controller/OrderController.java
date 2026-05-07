package MKShoes.mkshoes_Backend.controller;

import MKShoes.mkshoes_Backend.dto.OrderDto;
import MKShoes.mkshoes_Backend.dto.OrderRequestDto;
import MKShoes.mkshoes_Backend.entity.orders;
import MKShoes.mkshoes_Backend.service.OrderRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRequestService orderRequestService;
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderRequestService.getOrderById(id));
    }

    @PostMapping("/")
    public ResponseEntity<orders> createOrder(@RequestBody OrderRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderRequestService.createOrder(request));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<OrderDto>> getOrdersByUser(@PathVariable String email) {
        return ResponseEntity.ok(orderRequestService.getOrderByEmail(email));
    }



}
