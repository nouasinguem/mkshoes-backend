package MKShoes.mkshoes_Backend.repository;

import MKShoes.mkshoes_Backend.entity.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface productRepository extends JpaRepository <products, Integer> {
    List<products> findByProductNameContainingIgnoreCase(String productName);

    //SQL query for product filtering
    @Query("""
    SELECT p FROM products p
    WHERE (:brand IS NULL OR LOWER(p.brand) = LOWER(:brand))
      AND (:category IS NULL OR LOWER(p.category) = LOWER(:category))
      AND (:gender IS NULL OR LOWER(p.gender) = LOWER(:gender))
      AND (:country IS NULL OR LOWER(p.country) LIKE LOWER(CONCAT('%', :country, '%')))
    """)


    List<products> filterProducts(
            @Param("brand") String brand,
            @Param("category") String category,
            @Param("gender") String gender,
            @Param("country") String country
    );
}
