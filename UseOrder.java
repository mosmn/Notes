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