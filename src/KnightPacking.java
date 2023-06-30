import java.util.Scanner;

public class KnightPacking
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n % 2 == 0)
        {
            System.out.println("second");
        }
        else
        {
            System.out.println("first");
        }
    }
}
