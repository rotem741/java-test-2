package ordersystem;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final CustomerType type;
    private final Double discount;
    private final Set<String> favoriteItems = new HashSet<>();
    private Gift gift;

    public Customer(String id, String firstName, String lastName, String email,
                    String address, CustomerType type, Double discount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.type = type;
        this.discount = discount;
    }

    public void addToFavorites(Item item) {
        favoriteItems.add(item.getName());
    }

    public void removeFromFavorites(Item item) {
        favoriteItems.remove(item.getName());
    }

    public void takeGift(Gift gift) {
        this.gift = gift;
    }

    public void openGift() {
        if (gift != null) {
            gift.openGift();
        } else {
            System.out.println("No gift to open.");
        }
    }
}