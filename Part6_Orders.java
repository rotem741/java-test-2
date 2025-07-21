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

class VIPOrder extends Order {
    public VIPOrder(String id, String name, String deliveryAddress, List<Item> items,
                    Customer customer, PaymentType paymentType, Date orderDate) {
        super(id, name, deliveryAddress, items, customer, paymentType, orderDate);
    }

    @Override
    protected void calculateTotalPrice() {
        if (customer.getType() != CustomerType.VIP) {
            throw new IllegalArgumentException("Cannot create VIP order for non-VIP customer.");
        }
        double sum = items.stream().mapToDouble(Item::getPrice).sum();
        totalPrice = sum - (customer.getDiscount() != null ? sum * customer.getDiscount() : 0);
    }
}