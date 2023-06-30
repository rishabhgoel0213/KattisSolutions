import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathHomework
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int l = in.nextInt();


        boolean possible = false;
        for(int i = 0; i <= l / b; i++)
        {
            for(int j = 0; j <= l / c; j++)
            {
                for(int k = 0; k <= l / d; k++)
                {
                    if(i * b + j * c + k * d == l)
                    {
                        System.out.println(i + " " + j + " " + k);
                        possible = true;
                    }
                }
            }
        }

        if(!possible)
        {
            System.out.println("impossible");
        }
    }
}
