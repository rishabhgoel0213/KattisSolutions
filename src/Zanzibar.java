import java.util.Scanner;

public class Zanzibar
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++)
        {
            int sum = 0;
            int prevNumTurtles = 1;
            int numTurtles = 1;
            while(numTurtles != 0)
            {
                if(prevNumTurtles * 2 < numTurtles)
                {
                    sum += numTurtles - prevNumTurtles * 2;
                }
                prevNumTurtles = numTurtles;
                numTurtles = in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
