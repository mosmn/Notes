
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
            scanner.close();
        }
    }
}
