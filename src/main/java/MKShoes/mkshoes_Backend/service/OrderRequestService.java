package MKShoes.mkshoes_Backend.service;

import MKShoes.mkshoes_Backend.dto.OrderDto;
import MKShoes.mkshoes_Backend.dto.OrderRequestDto;
import MKShoes.mkshoes_Backend.entity.orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderRequestService {
    orders createOrder(OrderRequestDto orderRequestDto);

    List<OrderDto> getOrderByEmail(String email);

    OrderDto getOrderById(int orderId);
}
