package MKShoes.mkshoes_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter//Automatic
@Setter//Automatic
@AllArgsConstructor//Param constructors
@NoArgsConstructor
@Entity//specifies the class as JPA entity
@Table(name = "Products")
public class products {
    //Defining the columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Automatically generates the PK
    private int productId;//PK

    private String productName;
    private String productDescription;
    private int productPrice;
    private float productStock;
    private String productImage;
    private String category;
    private String brand;
    private String gender;
    private String country;
}
