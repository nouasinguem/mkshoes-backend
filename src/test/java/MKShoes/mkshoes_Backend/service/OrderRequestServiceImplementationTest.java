package MKShoes.mkshoes_Backend.service;

import MKShoes.mkshoes_Backend.dto.OrderItemDto;
import MKShoes.mkshoes_Backend.dto.OrderRequestDto;
import MKShoes.mkshoes_Backend.entity.Users;
import MKShoes.mkshoes_Backend.entity.orders;
import MKShoes.mkshoes_Backend.entity.products;
import MKShoes.mkshoes_Backend.repository.ordersRepository;
import MKShoes.mkshoes_Backend.repository.productRepository;
import MKShoes.mkshoes_Backend.repository.userRepository;
import MKShoes.mkshoes_Backend.service.Implementation.OrderRequestServiceImplementation;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderRequestServiceImplementationTest {

    @Mock
    private ordersRepository ordersRepository;
    @Mock
    private productRepository productRepository;
    @Mock
    private userRepository userRepository;

    @InjectMocks
    private OrderRequestServiceImplementation orderRequestServiceImplementation;

    private Users user;
    private products product;

    @BeforeEach
    void setUp() {
        //Setting up data
        user = new Users();
        user.setEmail("email@email.com");

        product = new products();
        product.setProductId(1);
        product.setProductName("Nike Air");
        product.setProductPrice(100);
        product.setProductStock(10);
    }

    @Test
    void SuccessfulOrderRequest() {
        OrderItemDto itemDto = new OrderItemDto();
        itemDto.setProductId(1);
        itemDto.setQuantity(2);
        OrderRequestDto request = new OrderRequestDto();
        request.setUserEmail("email@email.com");
        request.setItems(List.of(itemDto));
        when(userRepository.findById("email@email.com")).thenReturn(Optional.of(user));

        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(ordersRepository.save(any(orders.class))).thenAnswer(invocation -> invocation.getArgument(0));

        //Attempting to place the orders
        orders result = orderRequestServiceImplementation.createOrder(request);

        assertNotNull(result);
        //Check the price
        assertEquals(200, result.getPrice());
        //Checking the repositories
        verify(productRepository, times(1)).save(product);
        verify(ordersRepository, times(1)).save(any(orders.class));
    }
}
