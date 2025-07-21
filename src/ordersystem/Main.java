package ordersystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("i1", "Laptop", 3000);
        Item item2 = new Item("i2", "Mouse", 100);
        List<Item> orderItems = List.of(item1, item2);

        Customer vipCustomer = new Customer("c1", "Alice", "Wonder", "alice@mail.com",
                "123 Fantasy St", CustomerType.VIP, 0.2);

        Customer regularCustomer = new Customer("c2", "Bob", "Builder", "bob@mail.com",
                "456 Tool Rd", CustomerType.REGULAR, null);

        Order vipOrder = new VIPOrder("o1", "Alice Order", vipCustomer.getAddress(),
                orderItems, vipCustomer, PaymentType.CREDIT_CARD, new Date());

        System.out.println("VIP Order Total Price: " + vipOrder.getTotalPrice());

        try {
            Order badOrder = new VIPOrder("o2", "Fake VIP Order", regularCustomer.getAddress(),
                    orderItems, regularCustomer, PaymentType.CASH, new Date());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        vipCustomer.takeGift(new BoxGift());
        vipCustomer.openGift();
    }
}