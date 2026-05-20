package MKShoes.mkshoes_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private int productId;
    private int quantity;
    private String productName;
    private String productImage;
    private float productPrice;
    private int id;
}
