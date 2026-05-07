package MKShoes.mkshoes_Backend.service.Implementation;

import MKShoes.mkshoes_Backend.dto.ProductDto;
import MKShoes.mkshoes_Backend.entity.products;
import MKShoes.mkshoes_Backend.exception.RessourceNotFoundException;
import MKShoes.mkshoes_Backend.mapper.ProductMapper;
import MKShoes.mkshoes_Backend.repository.productRepository;
import MKShoes.mkshoes_Backend.repository.userRepository;
import MKShoes.mkshoes_Backend.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@AllArgsConstructor
public class ProductImplementation implements ProductService {

    private productRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        List <products> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.MapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(int id) {
        products product = productRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("No such user"));
        return ProductMapper.MapToProductDto(product) ;
    }
}
