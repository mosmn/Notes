// Group:
// Moahamed Ahmed Mohamed Osman (SW01082449)
// Abbas Mohammad Khaled Ali (SW01081578)

public class UseOrder {
    public static void main(String[] args) {
        ShippedOrder shippedOrder = new ShippedOrder();

        shippedOrder.setCustomerName();
        shippedOrder.setCustomerNumber();
        shippedOrder.setQuantityOrdered();
        shippedOrder.setUnitPrice();

        shippedOrder.computePrice();
        shippedOrder.display();
    }
}