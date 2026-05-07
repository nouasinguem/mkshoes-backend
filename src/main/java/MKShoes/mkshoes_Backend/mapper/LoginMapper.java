package MKShoes.mkshoes_Backend.mapper;

import MKShoes.mkshoes_Backend.dto.LoginDto;
import MKShoes.mkshoes_Backend.entity.Users;

public class LoginMapper {
    public static LoginDto MapToLoginDto (Users user){
        return new LoginDto(
                user.getEmail(),
                user.getPassword()
        );
    }

    public static Users MapToCredentials (LoginDto loginDto){
        return new Users(
                loginDto.getEmail(),
                "",
                loginDto.getPassword()
        );
    }
}
