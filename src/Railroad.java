import java.util.Scanner;

public class Railroad
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if(y % 2 == 0)
        {
            System.out.println("possible");
        }
        else
        {
            System.out.println("impossible");
        }
    }
}
