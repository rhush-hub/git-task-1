package git.task;

import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year (e.g., 2024): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number year.");
            sc.close();
            return;
        }

        int year = sc.nextInt();

        if (isLeap(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is NOT a leap year.");
        }

        int next = nextLeapYearAfter(year);
        System.out.println("Next leap year after " + year + " is " + next + ".");

        sc.close();
    }

    static boolean isLeap(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    static int nextLeapYearAfter(int y) {
        int candidate = y + 1;
        while (!isLeap(candidate))
            candidate++;
        return candidate;
    }
}