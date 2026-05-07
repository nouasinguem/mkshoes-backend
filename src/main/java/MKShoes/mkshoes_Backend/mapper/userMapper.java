package MKShoes.mkshoes_Backend.mapper;

import MKShoes.mkshoes_Backend.dto.userDto;
import MKShoes.mkshoes_Backend.entity.Users;
import org.apache.catalina.User;
import org.springframework.web.servlet.tags.EscapeBodyTag;

// this is used to give more security over users' data so that they are not exposed
public class userMapper {
    public static userDto mapToUserDto(Users user) {
        return new userDto(
                user.getEmail(),
                user.getName(),
                user.getPassword()
        );

    }

    public static Users mapToUser (userDto userDto){
        return new Users(
                userDto.getEmail(),
                userDto.getName(),
                userDto.getPassword()
        );
    }
}


