package net.realitatea;

import java.util.Scanner;

public class Problema2 {
    public static void main()
    {
        System.out.println("Introduceti primul numar: ");
        Scanner input1 = new Scanner(System.in);
        int x = input1.nextInt();

        System.out.println("Introduceti al doilea numar: ");
        Scanner input2 = new Scanner(System.in);
        int y = input2.nextInt();

        if (x == y) {
            System.out.println(x + " == " + y);
        } else {
            System.out.println(x + " != " + y);
        }

        if (x > y) {
            System.out.println(x + " > " + y);
        } else {
            System.out.println(x + " < " + y);
        }

        if (x >= y) {
            System.out.println(x + " >= " + y);
        }
        if (x <= y) {
            System.out.println(x + " <= " + y);
        }
    }
}
