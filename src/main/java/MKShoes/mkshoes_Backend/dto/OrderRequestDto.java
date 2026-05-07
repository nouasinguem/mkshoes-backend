package MKShoes.mkshoes_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// DTO used during checkout to carry user identity
// and the list of items the user wants to order
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private String userEmail; // identifies the user placing the order

    private List<OrderItemDto> items; // list of products + quantities
}
