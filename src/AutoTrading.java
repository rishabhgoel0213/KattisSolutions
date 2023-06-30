import java.util.*;

public class AutoTrading
{

    public static int[] preprocess(String pattern)
    {
        int[] numSkip = new int[pattern.length()];
        char c = pattern.charAt(0);
        numSkip[0] = 0;
        int pos = 0;

        for(int i = 1; i < pattern.length();)
        {
            if(pattern.charAt(i) == c)
            {
                numSkip[i] = ++pos;
                i++;
            }
            else if(pos != 0)
            {
                pos = numSkip[pos - 1];
            }
            else
            {
                numSkip[i] = 0;
                i++;
            }
            c = pattern.charAt(pos);
        }

        return numSkip;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String trades = in.nextLine();
        int n = Integer.parseInt(in.nextLine());
        int[][] testCases = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            testCases[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] preprocess = preprocess(trades.substring(testCases[i][0]));

            int answer = preprocess[testCases[i][1] - testCases[i][0]];
            for(int j = testCases[i][1] - testCases[i][0] + 1; j < preprocess.length - 1; j++)
            {
                if(answer >= preprocess[j])
                {
                    break;
                }
                answer = preprocess[j];

            }

            System.out.println(answer);

        }

    }
}
