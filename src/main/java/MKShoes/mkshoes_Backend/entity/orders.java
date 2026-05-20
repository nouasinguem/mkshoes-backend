package MKShoes.mkshoes_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter// Auto generation of getters
@Setter// Auto
@AllArgsConstructor// Generates a no-args constructor required by JPA
@NoArgsConstructor // Generates an all-args constructor for convenience

@Entity
@Table (name = "Orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Auto generation
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "email")//Defines the userID as foreign key
    private Users user;

    private float price;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<orderItem> orderItems;
}

