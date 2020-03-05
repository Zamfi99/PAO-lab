package laborator2;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problema1 | Laborator 2
 */
public class Problema1
{
    private int limit = 20;
    private int sum = 0;
    private int no = 0;

    /**
     * @return float
     */
    public static float run()
    {
        Problema1 problema1 = new Problema1();
        problema1.readNumbers();
        return problema1.calculateMedian();
    }

    /**
     * read max @limit numbers
     */
    private void readNumbers()
    {
        int number;

        for (int i = 0; i < this.limit; i++) {
            System.out.println("Citeste un numar: ");
            Scanner input = new Scanner(System.in);
            number = input.nextInt();
            if (number == -1) {
                return;
            }
            this.no++;
            this.sum = this.sum + number;
        }
    }

    /**
     * @return float
     */
    private float calculateMedian()
    {
        return (float)this.sum / this.no;
    }
}
