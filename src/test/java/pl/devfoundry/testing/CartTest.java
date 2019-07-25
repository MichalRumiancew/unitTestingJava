package pl.devfoundry.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(" Test casec for Cart")
class CartTest {

    @Test
    @DisplayName("Cart is able to process 1000 orders in 100 ms")
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();
        //when
        //then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);

    }
}