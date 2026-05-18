package MKShoes.mkshoes_Backend.controller;

import MKShoes.mkshoes_Backend.dto.ProductDto;
import MKShoes.mkshoes_Backend.entity.products;
import MKShoes.mkshoes_Backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final MKShoes.mkshoes_Backend.repository.productRepository productRepository;

    //Build Get all users Rest API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts (){
        List <ProductDto> productDtoList = productService.findAll();
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String name) {
        List<ProductDto> products = productService.searchProducts(name);
        return ResponseEntity.ok(products);
    }

    //API to get a single product
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int productId){
        ProductDto productDto = productService.findById(productId);
        if(productDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDto);
    }


    @GetMapping("/filter") public ResponseEntity<List> filterProducts( @RequestParam(required = false) String brand,
                                                                       @RequestParam(required = false) String category,
                                                                       @RequestParam(required = false) String gender,
                                                                       @RequestParam(required = false) String country ) {
        return ResponseEntity.ok(productService.filterProducts(brand, category, gender, country));
    }
}