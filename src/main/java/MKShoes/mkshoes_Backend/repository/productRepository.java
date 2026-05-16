package MKShoes.mkshoes_Backend.repository;

import MKShoes.mkshoes_Backend.entity.products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepository extends JpaRepository <products, Integer> {
    List<products> findByProductNameContainingIgnoreCase(String productName);

}
