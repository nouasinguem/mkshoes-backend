package MKShoes.mkshoes_Backend.mapper;

import MKShoes.mkshoes_Backend.dto.OrderDto;
import MKShoes.mkshoes_Backend.dto.OrderItemDto;
import MKShoes.mkshoes_Backend.entity.orders;

import java.util.List;
import java.util.stream.Collectors;


// This is used to give more security over orders' data as they could be exposed

public class OrdersMapper {
    public static OrderDto MapToOrderDto (orders orders){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(orders.getOrderId());
        orderDto.setUser(orders.getUser()); // assuming user is an object with email
        orderDto.setPrice(orders.getPrice());
        List<OrderItemDto> orderItemDtos = orders.getOrderItems().stream()
                .map(OrderItemMapper::MapToOrderItemDto)
                .collect(Collectors.toList());
        orderDto.setOrderItemsDto(orderItemDtos);
        orderDto.setCreatedAt(orders.getCreatedAt());

        return orderDto;
    }

}
