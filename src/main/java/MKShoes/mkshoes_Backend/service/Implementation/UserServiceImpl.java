package MKShoes.mkshoes_Backend.service.Implementation;

import MKShoes.mkshoes_Backend.dto.LoginDto;
import MKShoes.mkshoes_Backend.dto.userDto;
import MKShoes.mkshoes_Backend.entity.Users;
import MKShoes.mkshoes_Backend.exception.RessourceNotFoundException;
import MKShoes.mkshoes_Backend.mapper.userMapper;
import MKShoes.mkshoes_Backend.repository.userRepository;
import MKShoes.mkshoes_Backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private userRepository userRepository;
    @Override
    public userDto register(userDto userDto) {
        Users user = userMapper.mapToUser(userDto);
        Users savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public userDto login(LoginDto loginDto) {
        Users user = userRepository.findById(loginDto.getEmail())
                .orElseThrow(() -> new RessourceNotFoundException("Invalid user or password"));

        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new RessourceNotFoundException("Invalid user or password");
        }
        return userMapper.mapToUserDto(user);
    }

    @Override
    public userDto whoIsLoggedIn(userDto userDto) {
        Users user = userRepository.findById(userDto.getEmail())
                .orElseThrow(() -> new RessourceNotFoundException("Invalid user or password"));

        return userMapper.mapToUserDto(user);
    }

    @Override
    public userDto getUserByEmail(String email) {
        Users user = userRepository.findById(email)
                .orElseThrow(() -> new RessourceNotFoundException("No such user"));

        return userMapper.mapToUserDto(user);
    }
}
