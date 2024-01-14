// Group:
// Moahamed Ahmed Mohamed Osman (SW01082449)
// Abbas Mohammad Khaled Ali (SW01081578)

public class ShippedOrder extends Order {
    private final double SHIPPING_CHARGE = 12.00;

    public double computePrice() {
        this.totalPrice = (this.unitPrice * this.quantityOrdered) + SHIPPING_CHARGE;
        return this.totalPrice;
    }
}