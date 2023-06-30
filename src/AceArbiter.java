import java.util.Arrays;
import java.util.Scanner;

public class AceArbiter
{
    public static boolean sameServer(int[][] scores, int i)
    {
        return (scores[i][0] + scores[i][1] + 1) / 2 % 2 == (scores[i - 1][0] + scores[i - 1][1] + 1) / 2 % 2;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] scores = new int[n][2];
        boolean error = false;
        for(int i = 0; i < n && !error; i++)
        {
            scores[i] = Arrays.stream(in.nextLine().split("-")).mapToInt(Integer::parseInt).toArray();
            if(scores[i][0] == 11 && scores[i][1] > 0)
            {
                System.out.println("error " + (i + 1));
                error = true;
            }
            else if(scores[i][1] == 11 && scores[i][0] > 0)
            {
                System.out.println("error " + (i + 1));
                error = true;
            }
            else if(i > 0)
            {
                if(sameServer(scores, i))
                {
                    if(scores[i][0] < scores[i - 1][0] || scores[i][1] < scores[i - 1][1])
                    {
                        System.out.println("error " + (i + 1));
                        error = true;
                    }
                }
                else
                {
                    if(scores[i][0] < scores[i - 1][1] || scores[i][1] < scores[i - 1][0])
                    {
                        System.out.println("error " + (i + 1));
                        error = true;
                    }
                }
            }

        }
        if(!error)
        {
            System.out.println("ok");
        }
    }
}
