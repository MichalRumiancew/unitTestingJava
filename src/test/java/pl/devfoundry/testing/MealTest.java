package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void referencesToTheSameObjectShouldBeEquals() {

        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        assertSame(meal1, meal2);

    }

    @Test
    void referencesToTheSameObjectShouldBeNotEquals() {

        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);
        //then
        assertNotSame(meal1, meal2);

    }

    @Test
    void twoMeatShouldBeEqualsWhenPriceAndNameAerTheSame(){
        //given
        Meal meal1 = new Meal(10, "Piiza");
        Meal meal2 = new Meal(10, "Piiza");
        //then
        assertEquals(meal1,meal2,"Checking if two meals are equal");

    }
}
