package MKShoes.mkshoes_Backend.repository;

import MKShoes.mkshoes_Backend.entity.products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository <products, Integer> {
}
