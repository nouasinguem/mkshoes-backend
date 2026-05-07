package MKShoes.mkshoes_Backend.repository;

import MKShoes.mkshoes_Backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository <Users, String> {
}
