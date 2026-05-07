package MKShoes.mkshoes_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private int productId;
    private int size;
    private int quantity;
    private int productPrice;
    private String productName;
    private String productImage;
}
