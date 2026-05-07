package MKShoes.mkshoes_Backend.controller;

import MKShoes.mkshoes_Backend.dto.LoginDto;
import MKShoes.mkshoes_Backend.dto.userDto;
import MKShoes.mkshoes_Backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class UserController {

    private UserService userService;
    
    //Build Add User API
    @PostMapping("/signup")
    public ResponseEntity <userDto> register (@RequestBody userDto userDto) {
        return new ResponseEntity<>(userService.register(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<userDto> login (@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<userDto> getUser (@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
