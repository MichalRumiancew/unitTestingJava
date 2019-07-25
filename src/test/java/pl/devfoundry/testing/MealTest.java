package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
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
    void twoMeatShouldBeEqualsWhenPriceAndNameAerTheSame(){
        //given
        Meal meal1 = new Meal(10, "Piiza");
        Meal meal2 = new Meal(10, "Piiza");
        //then
        assertEquals(meal1,meal2,"Checking if two meals are equal");

    }

    @Test
    void exceptionShouldBeThrownWhenDiscountIsHigherThanThePrice (){

        //given
        Meal meal = new Meal(8, "Soup");
        //when
        //then
        assertThrows(IllegalArgumentException.class, ()-> meal.getDiscountedPrice(40));

    }
}
