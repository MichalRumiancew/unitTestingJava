package pl.devfoundry.testing;

public class Account {
    private boolean active;

    public Address getDefaultDeliveryAddres() {
        return defaultDeliveryAddres;
    }

    public Account(Address defaultDeliveryAddres) {
        this.defaultDeliveryAddres = defaultDeliveryAddres;
        if (defaultDeliveryAddres != null) {
            activate();
        } else {
            this.active = false;
        }

    }

    public void setDefaultDeliveryAddres(Address defaultDeliveryAddres) {
        this.defaultDeliveryAddres = defaultDeliveryAddres;
    }

    private Address defaultDeliveryAddres;

    public Account() {
        this.active = false;

    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }
}
