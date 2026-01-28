package git.task;

import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("The number you entered is even");
        } else {
            System.out.println("The number you entered is odd");
        }

        scanner.close();
    }
}
