package pl.devfoundry.testing;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBeckupTest {

    private static OrderBeckup orderBeckup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBeckup = new OrderBeckup();
        orderBeckup.createFile();
    }
    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException{
        orderBeckup.getWriter().append("New order: ");
    }
    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException {
        orderBeckup.getWriter().append(" backed up.");
    }

    @Test
    void backOrderWithOneMeal() throws IOException {

        //given
        Meal meal = new Meal(7, "Fries");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBeckup.beckupOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " becked up.");


    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBeckup.closeFile();
    }
}
