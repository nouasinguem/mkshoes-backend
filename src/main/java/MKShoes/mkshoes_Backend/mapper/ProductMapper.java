package MKShoes.mkshoes_Backend.mapper;

import MKShoes.mkshoes_Backend.dto.ProductDto;
import MKShoes.mkshoes_Backend.entity.products;

public class ProductMapper {

    public static ProductDto MapToProductDto (products product){
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductStock(),
                product.getProductImage(),
                product.getCategory(),
                product.getBrand(),
                product.getGender(),
                product.getCountry()
        );
    }

    public static products MapToProduct (ProductDto productDto){
        return new products(
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getProductDescription(),
                productDto.getProductPrice(),
                productDto.getProductStock(),
                productDto.getProductImage(),
                productDto.getCategory(),
                productDto.getBrand(),
                productDto.getGender(),
                productDto.getCountry()
        );
    }
}
