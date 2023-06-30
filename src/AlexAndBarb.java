import java.util.Scanner;

public class AlexAndBarb
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();

        int x = (m + n) * ((k) / (m + n + m)) + m;
        if(x < k && k < (x + n))
        {
            System.out.println("Alex");
        }
        else
        {
            System.out.println("Barb");
        }
    }
}
