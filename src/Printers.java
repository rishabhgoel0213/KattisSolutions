import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Printers
{
    public static int minDays(int numPrinters, int statuesLeft, int numDays, int numStatues)
    {
        System.out.println(numPrinters + " " + statuesLeft + " " + numDays);
        if(statuesLeft <= 0 || numDays > numStatues)
        {
            return Math.min(numDays, numStatues);
        }
        else
        {
            int num = (int)(Math.log(numStatues)/Math.log(2));
            num += (numStatues - (int) Math.pow(2, num));

            return num;
//            return IntStream
//                    .range(0, numPrinters + 1)
//                    .map(i -> minDays(
//                            numPrinters + i,
//                            statuesLeft - numPrinters + i,
//                            numDays + 1,
//                            numStatues
//                        ))
//                    .min().orElse(-1);
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int numPrinterDays = (int)(Math.log(n)/Math.log(2));
        int numPrintersMax = (int)Math.pow(2, numPrinterDays);

        int days = 0;
        while(days * numPrintersMax < n)
        {
            days++;
        }

        System.out.println(numPrinterDays + days);


//        System.out.println(minDays(1, n, 0, n));
    }
}
