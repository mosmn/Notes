// Group:
// Moahamed Ahmed Mohamed Osman (SW01082449)
// Abbas Mohammad Khaled Ali (SW01081578)

import java.util.Scanner;

public class Order {
    protected String customerName;
    protected int customerNumber;
    protected int quantityOrdered;
    protected double unitPrice;
    protected double totalPrice;

    public void setCustomerName() {
        System.out.println("Enter customer name: ");
        Scanner scanner = new Scanner(System.in);
        this.customerName = scanner.nextLine();
    }

    public void setCustomerNumber() {
        System.out.println("Enter customer number: ");
        Scanner scanner = new Scanner(System.in);
        this.customerNumber = scanner.nextInt();
    }

    public void setQuantityOrdered() {
        System.out.println("Enter quantity ordered: ");
        Scanner scanner = new Scanner(System.in);
        this.quantityOrdered = scanner.nextInt();
    }

    public void setUnitPrice() {
        System.out.println("Enter unit price: ");
        Scanner scanner = new Scanner(System.in);
        this.unitPrice = scanner.nextDouble();
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public int getQuantityOrdered() {
        return this.quantityOrdered;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public double computePrice() {
        this.totalPrice = this.unitPrice * this.quantityOrdered;
        return this.totalPrice;
    }

    public void display() {
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Customer Number: " + this.customerNumber);
        System.out.println("Quantity Ordered: " + this.quantityOrdered);
        System.out.println("Unit Price: " + this.unitPrice);
        System.out.println("Total Price: " + this.totalPrice);
    }
}