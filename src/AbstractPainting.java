import java.util.Arrays;
import java.util.Scanner;

public class AbstractPainting
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int[][] testCases = new int[t][2];

        int fourChoices = 18;
        int threeChoices = 6;
        int twoChoices = 3;
        for(int i = 0; i < t; i++)
        {
            testCases[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int numSquares = testCases[i][0] * testCases[i][1];
            int numTopEdges = testCases[i][0] + testCases[i][1] - 2;
            int numInsideSquares = numSquares - numTopEdges - 1;

            long answer = fourChoices;
            for(int j = 0; j < numTopEdges; j++)
            {
                answer *= threeChoices;
                answer = (long)(answer % (1e9 + 7));
            }
            for(int j = 0; j < numInsideSquares; j++)
            {
                answer *= 2;
                answer = (long)(answer % (1e9 + 7));
            }
            System.out.println(answer);

        }


    }
}
