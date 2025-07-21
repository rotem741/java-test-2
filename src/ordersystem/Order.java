package ordersystem;

import java.util.Date;
import java.util.List;

public abstract class Order {
    protected final String id;
    protected final String name;
    protected final String deliveryAddress;
    protected final List<Item> items;
    protected final Customer customer;
    protected final PaymentType paymentType;
    protected final Date orderDate;
    protected double totalPrice;

    public Order(String id, String name, String deliveryAddress, List<Item> items,
                 Customer customer, PaymentType paymentType, Date orderDate) {
        this.id = id;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.customer = customer;
        this.paymentType = paymentType;
        this.orderDate = orderDate;

        for (Item item : items) {
            customer.addToFavorites(item);
        }

        calculateTotalPrice();
    }

    protected abstract void calculateTotalPrice();

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public List<Item> getItems() { return items; }
    public Customer getCustomer() { return customer; }
    public double getTotalPrice() { return totalPrice; }
    public PaymentType getPaymentType() { return paymentType; }
    public Date getOrderDate() { return orderDate; }
}