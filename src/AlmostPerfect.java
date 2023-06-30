import java.util.Scanner;

public class AlmostPerfect
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt())
        {
            int p = in.nextInt();
            int sum = 1;
            for(int d = 2; d <= Math.sqrt(p); d++)
            {
                if(p % d == 0)
                {
                    sum += d;
                    if (p / d != d)
                        sum += (p / d);
                }
            }
            System.out.println(sum);
            if(sum == p)
            {
                System.out.println(p + " perfect");
            }
            else if(Math.abs(sum - p) <= 2)
            {
                System.out.println(p + " almost perfect");
            }
            else
            {
                System.out.println(p + " not perfect");
            }
        }
    }
}
