package MKShoes.mkshoes_Backend.repository;

import MKShoes.mkshoes_Backend.entity.orderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderItemRepository extends JpaRepository<orderItem, Integer> {
}
