package MKShoes.mkshoes_Backend.service;

import MKShoes.mkshoes_Backend.dto.LoginDto;
import MKShoes.mkshoes_Backend.dto.userDto;
import MKShoes.mkshoes_Backend.entity.Users;

public interface UserService {

    userDto register(userDto userDto);

    userDto login(LoginDto loginDto);

    userDto whoIsLoggedIn(userDto userDto);

    userDto getUserByEmail(String email);
}

