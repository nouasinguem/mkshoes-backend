package MKShoes.mkshoes_Backend.service.Implementation;

import MKShoes.mkshoes_Backend.dto.OrderDto;
import MKShoes.mkshoes_Backend.dto.OrderItemDto;
import MKShoes.mkshoes_Backend.dto.OrderRequestDto;
import MKShoes.mkshoes_Backend.entity.Users;
import MKShoes.mkshoes_Backend.entity.orderItem;
import MKShoes.mkshoes_Backend.entity.orders;
import MKShoes.mkshoes_Backend.entity.products;
import MKShoes.mkshoes_Backend.exception.RessourceNotFoundException;
import MKShoes.mkshoes_Backend.mapper.OrdersMapper;
import MKShoes.mkshoes_Backend.repository.ordersRepository;
import MKShoes.mkshoes_Backend.repository.productRepository;
import MKShoes.mkshoes_Backend.repository.userRepository;
import MKShoes.mkshoes_Backend.service.OrderRequestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@AllArgsConstructor
public class OrderRequestServiceImplementation implements OrderRequestService {

    private ordersRepository ordersRepository;
    private productRepository productRepository;
    private userRepository userRepository;

    @Override
    public orders createOrder(OrderRequestDto request) {

        //Verifying the existing user
        Users user = userRepository.findById(request.getUserEmail())
                .orElseThrow(() -> new RessourceNotFoundException("No such user"));

        //creating the order
        orders order = new orders();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());

        List<orderItem> orderItems = new ArrayList<>();
        float totalPrice = 0;//Initialising the total price

        //Setting orders
        for (int i = 0; i < request.getItems().size(); i++) {

            OrderItemDto itemDto = request.getItems().get(i);

            int productId = itemDto.getProductId();
            int quantity = itemDto.getQuantity();

            products product = productRepository.findById(productId)
                    .orElseThrow(() -> new RessourceNotFoundException(
                            "Product " + productId + " not found"
                    ));

            // Check stock
            if (product.getProductStock() < quantity) {
                throw new RuntimeException(
                        "Not enough stock for " + product.getProductName()
                );
            }

            // Reduce stock
            product.setProductStock(product.getProductStock() - quantity);
            productRepository.save(product);

            // Create order item
            orderItem orderItem = new orderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setOrder(order);

            orderItems.add(orderItem);

            totalPrice += product.getProductPrice() * quantity;
        }

        order.setPrice(totalPrice);
        order.setOrderItems(orderItems);

        return ordersRepository.save(order);
    }

    @Override
    public List <OrderDto> getOrderByEmail(String email) {
        List<orders> ordersList = ordersRepository.findByUserEmail(email);
        return ordersList.stream()
                .map(order -> OrdersMapper.MapToOrderDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(int orderId) {
        orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new RessourceNotFoundException("No such order"));//Check the existence of the order
        return OrdersMapper.MapToOrderDto(order);
    }

    @Override
    public void cancelOrder(int orderId) {
        orders order = ordersRepository.findById(orderId)
                .orElseThrow(() -> new RessourceNotFoundException("Order not found"));

        for (orderItem item : order.getOrderItems()) {
            products product = item.getProduct();
            product.setProductStock(product.getProductStock() + item.getQuantity());
            productRepository.save(product);
        }

        ordersRepository.delete(order);
    }
}
