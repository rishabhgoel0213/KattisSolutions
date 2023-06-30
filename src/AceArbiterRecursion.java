import java.util.Arrays;
import java.util.Scanner;

public class AceArbiterRecursion
{
    public static boolean isPossible(int[] currentScore, int[][] scores, int i)
    {

        if(i == scores.length || currentScore[0] == 11 || currentScore[1] == 11)
        {
            return false;
        }
        if(currentScore[0] + currentScore[1] % 2 == 1)
        {
            int temp = currentScore[0];
            currentScore[0] = currentScore[1];
            currentScore[1] = temp;
        }

        if(scores[i][0] != currentScore[0])
        {
            currentScore[0]++;
            return isPossible(currentScore, scores, i);
        }
        else if(scores[i][1] != currentScore[1])
        {
            currentScore[1]++;
            return isPossible(currentScore, scores, i);
        }
        else
        {
        }

        return true;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] scores = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            scores[i] = Arrays.stream(in.nextLine().split("-")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
