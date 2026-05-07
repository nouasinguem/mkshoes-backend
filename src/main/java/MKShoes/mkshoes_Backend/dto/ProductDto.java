package MKShoes.mkshoes_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private float productStock;
    private String productImage;
}
