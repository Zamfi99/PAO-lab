package net.realitatea;

import java.util.Scanner;

public class Problema4 {
    public static void main()
    {
        System.out.println("Introduceti numarul: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Factorialul este: " + factorial);
    }
}
