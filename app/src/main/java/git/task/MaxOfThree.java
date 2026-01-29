package git.task;

import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int a = sc.nextInt();

        System.out.print("Enter second integer: ");
        int b = sc.nextInt();

        System.out.print("Enter third integer: ");
        int c = sc.nextInt();

        int max = Math.max(a, Math.max(b, c));
        System.out.println("Largest: " + max);

        // Stretch: print all in descending order
        int x = a, y = b, z = c;

        // simple swaps to order x >= y >= z
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        if (x < z) {
            int t = x;
            x = z;
            z = t;
        }
        if (y < z) {
            int t = y;
            y = z;
            z = t;
        }

        System.out.println("Descending: " + x + " " + y + " " + z);

        sc.close();
    }

}
