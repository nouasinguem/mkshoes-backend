package MKShoes.mkshoes_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Data Transfer Object to send only the needed data to
//the client without exposing the full database model
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class userDto {
    private String email;
    private String name;
    private String password;

}
