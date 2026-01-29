package git.task;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression (e.g., 5 * 3): ");
        // This expects three tokens: number operator number
        // Example: 5 * 3
        if (!sc.hasNextDouble()) {
            System.out.println("First value is not a number. Please try again.");
            sc.close();
            return;
        }
        double a = sc.nextDouble();

        if (!sc.hasNext()) {
            System.out.println("Missing operator. Please try again.");
            sc.close();
            return;
        }
        String op = sc.next();

        if (!sc.hasNextDouble()) {
            System.out.println("Second value is not a number. Please try again.");
            sc.close();
            return;
        }
        double b = sc.nextDouble();

        // Calculate using switch
        switch (op) {
            case "+":
                System.out.println("Result: " + (a + b));
                break;
            case "-":
                System.out.println("Result: " + (a - b));
                break;
            case "*":
                System.out.println("Result: " + (a * b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    // show as double
                    System.out.println("Result: " + (a / b));
                }
                break;
            case "%":
                // Modulo is most meaningful with integers; we’ll cast and warn if non-integers
                // were provided
                if (b == 0) {
                    System.out.println("Error: Modulo by zero is not allowed.");
                } else {
                    if (a % 1 != 0 || b % 1 != 0) {
                        System.out.println("Note: Modulo is applied to integer parts only.");
                    }
                    long ai = (long) a;
                    long bi = (long) b;
                    System.out.println("Result: " + (ai % bi));
                }
                break;
            default:
                System.out.println("Unsupported operator '" + op + "'. Use one of: +  -  *  /  %");
        }

        sc.close();
    }
}
