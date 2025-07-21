package ordersystem;

public interface Gift {
    void openGift();
}

class BoxGift implements Gift {
    public void openGift() {
        System.out.println("Congratulations! you got a new gift! Enjoy!");
    }
}