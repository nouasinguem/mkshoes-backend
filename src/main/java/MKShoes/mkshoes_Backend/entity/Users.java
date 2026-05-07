package MKShoes.mkshoes_Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter//for default getters
@Setter//For default setters
@NoArgsConstructor
@AllArgsConstructor
@Entity//Defines the entity
@Table(name = "Users")
public class Users {
    @Id//primary key
    private String email;
    @Column(nullable = false)
    private String name;
    private String password;

}
