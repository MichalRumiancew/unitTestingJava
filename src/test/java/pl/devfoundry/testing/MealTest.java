package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);
        //when
        int dicountedPrice = meal.getDiscountedPrice(7);
        //then
        assertEquals(28, dicountedPrice);
        assertThat(dicountedPrice, equalTo(28));
    }

    @Test
    void referencesToTheSameObjectShouldBeEquals() {

        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        assertSame(meal1, meal2);
        assertThat(meal1, sameInstance(meal2));

    }

    @Test
    void referencesToTheSameObjectShouldBeNotEquals() {

        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);
        //then
        assertNotSame(meal1, meal2);
        assertThat(meal1, not(sameInstance(meal2)));

    }

    @Test
    void twoMeatShouldBeEqualsWhenPriceAndNameAerTheSame() {
        //given
        Meal meal1 = new Meal(10, "Piiza");
        Meal meal2 = new Meal(10, "Piiza");
        //then
        assertEquals(meal1, meal2, "Checking if two meals are equal");

    }

    @Test
    void exceptionShouldBeThrownWhenDiscountIsHigherThanThePrice() {

        //given
        Meal meal = new Meal(8, "Soup");
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(40));

    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 18})
    void mealPricesShouldLowerThan20(int prices) {
        assertThat(prices, lessThan(20));

    }

    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgersShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));

    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheaseburger", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNamesShouldEndWithCake(String name) {
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));
    }

    private static Stream<String> createCakeNames() {
        List<String> cakeNames = Arrays.asList("Cheesecake", "Fruitcake", "Cupcake");
        return cakeNames.stream();
    }
}
