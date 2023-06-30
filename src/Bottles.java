import java.util.Scanner;

public class Bottles
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long total = in.nextLong();
        long bigBottle = in.nextLong();
        long smallBottle = in.nextLong();


        long bigCount = total/bigBottle;
        long filled = bigBottle * bigCount;

        while((total - filled) % smallBottle != 0)
        {
            filled -= bigBottle;
            bigCount--;
            if(filled < 0)
            {
                System.out.println("Impossible");
                return;
            }
        }

        long smallCount = (total - filled)/smallBottle;
        System.out.println(bigCount + " " + smallCount);
    }
}
