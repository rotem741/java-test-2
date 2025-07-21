package ordersystem;

import java.util.Date;
import java.util.List;

public class RegularOrder extends Order {
    public RegularOrder(String id, String name, String deliveryAddress, List<Item> items,
                        Customer customer, PaymentType paymentType, Date orderDate) {
        super(id, name, deliveryAddress, items, customer, paymentType, orderDate);
    }

    @Override
    protected void calculateTotalPrice() {
        totalPrice = items.stream().mapToDouble(Item::getPrice).sum();
    }
}