package net.realitatea;

public class Main {

    public static void main(String[] args) {
//        Problema1.main();
//        Problema2.main();
//        Problema3.main();
//        Problema4.main();
//        System.out.println(Main.prim(1023));
//        System.out.println(Main.fibo(6));
//        System.out.println(Main.max_prime_factor(1977));
    }

    public static boolean prim(int x)
    {
        for (int i = 2; i*i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int fibo(int position)
    {
        int current_position = 2;
        int last_number = 1;
        int last_last_number = 1;
        int current_number = 1;
        if (position <= 2) {
            return 1;
        }

        while (current_position != position) {
            current_number = last_number + last_last_number;
            last_last_number = last_number;
            last_number = current_number;
            current_position++;
        }

        return current_number;
    }

    public static int max_prime_factor(int number)
    {
        for (int i = number/2; i >=1; i--) {
            if (Main.prim(i) && number % i == 0) {
                return i;
            }
        }

        return 0;
    }
}
