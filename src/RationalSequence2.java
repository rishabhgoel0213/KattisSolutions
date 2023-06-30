import java.util.Scanner;

public class RationalSequence2
{

    public static int tree(int n, int d)
    {
        if (n == 1 && d == 1)
        {
            return 1;
        }
        else if (n > d)
        {
            return 2 * tree(n - d, d) + 1;
        }
        else
        {
            return 2 * tree(n, d - n);
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            int k = in.nextInt();
            String s = in.next();
            int n1 = Integer.parseInt(s.split("/")[0]);
            int d1 = Integer.parseInt(s.split("/")[1]);
            System.out.println(k + " " + tree(n1, d1));
        }
    }


}
