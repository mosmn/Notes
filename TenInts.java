import java.util.Scanner;

public class TenInts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers: ");
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Enter a number to search: ");
        int searchNumber = scanner.nextInt();
        boolean found = false;
        int smallest = numbers[0], largest = numbers[0], oddCount = 0, negativeCount = 0;
        for (int number : numbers) {
            if (number == searchNumber) {
                found = true;
            }
            if (number < smallest) {
                smallest = number;
            }
            if (number > largest) {
                largest = number;
            }
            if (number % 2 != 0) {
                oddCount++;
            }
            if (number < 0) {
                negativeCount++;
            }
        }
        System.out.println("Number " + searchNumber + " is " + (found ? "" : "not ") + "present in the array.");
        System.out.println("Smallest number: " + smallest);
        System.out.println("Largest number: " + largest);
        System.out.println("Odd numbers count: " + oddCount);
        System.out.println("Negative numbers count: " + negativeCount);
    }
}
