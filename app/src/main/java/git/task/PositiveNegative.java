package git.task;

import java.util.Scanner;

public class PositiveNegative {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            if (n > 0) {
                System.out.println("The number is positive.");
            } else if (n < 0) {
                System.out.println("The number is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        } else {
            System.out.println("Invalid input. Please enter an integer next time.");
        }

        scanner.close();
    }
}
