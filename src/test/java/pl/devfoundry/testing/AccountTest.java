package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;
import testing.Account;

import static org.junit.jupiter.api.Assertions.assertFalse;

class AccountTest {
    @Test
    void myTest() {
        Account newAccount = new Account();
        assertFalse(newAccount.isActive());
    }
}
