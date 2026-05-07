package MKShoes.mkshoes_Backend.mapper;

import MKShoes.mkshoes_Backend.dto.OrderItemDto;
import MKShoes.mkshoes_Backend.entity.orderItem;

public class OrderItemMapper {
    public static OrderItemDto MapToOrderItemDto (orderItem orderItem){
        return new OrderItemDto(
                orderItem.getOrderItemId(),
                orderItem.getQuantity()
        );
    }

    // This class doesn't map orderItemDto to an OrderItem.
}
