package net.realitatea;

import java.util.Scanner;

public class Problema3 {
    public static void main()
    {
        System.out.println("Introduceti n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int suma = 0;

        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                suma += i;
            }
        }

        System.out.println("Suma este: " + suma);
    }
}
