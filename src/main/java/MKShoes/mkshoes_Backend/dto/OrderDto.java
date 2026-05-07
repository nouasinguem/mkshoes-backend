package MKShoes.mkshoes_Backend.dto;

import MKShoes.mkshoes_Backend.entity.Users;
import MKShoes.mkshoes_Backend.entity.orderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto {
    private int orderId;
    private Users user;
    private float price;
    private LocalDateTime createdAt;
    private List<OrderItemDto> orderItemsDto;
}
