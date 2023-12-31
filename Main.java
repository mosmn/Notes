// class Main {
//     public static void main(String[] args) {
//         double a,b;
//         a = 3/0.0;
//         b = 0/4.0;
//         System.out.println(a);
//         System.out.println(b);
//     }
//     public static void method1() {
//         double a = 3/0.0;
//         System.out.println(a + " " + b);
//     }
// }

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter an integer:");
            int num = scanner.nextInt();

            if (num > 100) {
                throw new Exception("Out of bound");
            }
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Not an integer");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner in the finally block to prevent resource leaks
        }
    }
}
