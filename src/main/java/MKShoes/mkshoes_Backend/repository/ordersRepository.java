package MKShoes.mkshoes_Backend.repository;

import MKShoes.mkshoes_Backend.entity.orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ordersRepository extends JpaRepository<orders, Integer> {
    List<orders> findByUserEmail(String email);
}
