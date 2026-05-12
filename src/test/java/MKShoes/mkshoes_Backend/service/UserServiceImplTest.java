package MKShoes.mkshoes_Backend.service;

import MKShoes.mkshoes_Backend.dto.LoginDto;
import MKShoes.mkshoes_Backend.dto.userDto;
import MKShoes.mkshoes_Backend.entity.Users;
import MKShoes.mkshoes_Backend.exception.RessourceNotFoundException;
import MKShoes.mkshoes_Backend.repository.userRepository;
import MKShoes.mkshoes_Backend.service.Implementation.UserServiceImpl;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private userRepository repository;
    @InjectMocks
    private UserServiceImpl service;
    private Users user;

    @BeforeEach
    void setUp() {

        //Setting test data
        user = new Users();
        user.setEmail("test@springBoot");
        user.setPassword("I_will_get_myBsc");
    }

    @Test
    void successfulLogin() {
        //testing when correct credentials are passed in the login form
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("test@springBoot");
        loginDto.setPassword("I_will_get_myBsc");

        when(repository.findById("test@springBoot"))
                .thenReturn(Optional.of(user));

        // Act
        userDto result = service.login(loginDto);

        // Assert
        assertNotNull(result);
        assertEquals("test@springBoot", result.getEmail());

        verify(repository, times(1))
                .findById("test@springBoot");
    }

    @Test
    void incorrectCredentialsFalseTest() {
        //False test
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("wrong@credentials");
        loginDto.setPassword("wrongpassword");

        when(repository.findById("wrong@credentials"))
                .thenReturn(Optional.of(user));
        RessourceNotFoundException result = assertThrows(
                RessourceNotFoundException.class,
                () -> service.login(loginDto));

        assertEquals("Login Successful", result.getMessage());

    }

    @Test
    void incorrectCredentials() {
        //False test
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("wrong@credentials");
        loginDto.setPassword("wrongpassword");

        when(repository.findById("wrong@credentials"))
                .thenReturn(Optional.of(user));
        RessourceNotFoundException result = assertThrows(
                RessourceNotFoundException.class,
                () -> service.login(loginDto));

        assertEquals("Invalid user or password", result.getMessage());
    }
}
