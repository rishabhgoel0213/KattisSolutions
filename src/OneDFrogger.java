import java.util.Arrays;
import java.util.Scanner;

public class OneDFrogger
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = in.nextInt() - 1;
        int m = in.nextInt();

        int[] values = Arrays.stream(new int[n]).map(v -> in.nextInt()).toArray();

        int h = 0;
        while(true)
        {
//            System.out.println(i);
            if(i < 0)
            {
                System.out.println("left");
                break;
            }
            else if(i >= values.length)
            {
                System.out.println("right");
                break;
            }
            else if(values[i] == m)
            {
                System.out.println("magic");
                break;
            }
            else if(values[i] == 201)
            {
                System.out.println("cycle");
                break;
            }

            int increment = values[i];
            values[i] = 201;
            i += increment;

            h++;
        }

        System.out.println(h);

    }
}
