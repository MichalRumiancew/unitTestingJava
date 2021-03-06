package pl.devfoundry.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

//TDD given->then->then
class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActivate() {

        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
//        if (!newAccount.isActive()) {
//            return "Ok";
//        } else {
//            throw new IllegalStateException();

            assertThat(newAccount.isActive(), equalTo(false));
            assertThat(newAccount.isActive(), is(false));
        }

        @Test
        void newAccountShouldNotBeActiveAfterCreation () {
            //given
            //when
            Account newAccount = new Account();
            //then
            assertFalse(newAccount.isActive(), " Check if new account in not active");
        }

        @Test
        void accountShouldBeActiveAfterActivation () {
            //given
            Account newAccount = new Account();
            //when
            newAccount.activate();
            //then
            assertTrue(newAccount.isActive());
        }

        @Test
        void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet () {

            //given
            Account account = new Account();
            //when
            Address address = account.getDefaultDeliveryAddres();
            //then
            assertNull(address);

        }

        @Test
        void defaultDeliveryAddressShouldNotBeNullAfterBeingSet () {
            //given
            Address address = new Address("Krakowska", "67c");
            Account account = new Account();
            account.setDefaultDeliveryAddres(address);

            //when
            Address defaultAddress = account.getDefaultDeliveryAddres();

            // then
            assertNotNull(defaultAddress);

            //assertThat()

        }

        @RepeatedTest(5)
        void newAccountWithNotNullAddressShouldBeActive () {

            //given
            Address address = new Address("Puławska", "46/6");

            //when
            Account account = new Account(address);

            //then
            assumingThat(address != null, () -> {
                assertTrue(account.isActive());
            });
        }
    }
