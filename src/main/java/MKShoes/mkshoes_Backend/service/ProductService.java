package MKShoes.mkshoes_Backend.service;

import MKShoes.mkshoes_Backend.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(int id);

    List<ProductDto> searchProducts(String name);

    List<ProductDto> filterProducts(String brand, String category, String gender, String country);
}
