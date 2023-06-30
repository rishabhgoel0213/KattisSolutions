import java.util.Arrays;
import java.util.Scanner;

public class Pokemon
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] pokenoms = new int[3][n];
        for (int i = 0; i < n; i++)
        {
            pokenoms[0][i] = in.nextInt();
            pokenoms[1][i] = in.nextInt();
            pokenoms[2][i] = in.nextInt();
        }
        int[] maxes = new int[3];
        for (int i = 0; i < 3; i++)
        {
            maxes[i] = Arrays.binarySearch(pokenoms[i], Arrays.stream(pokenoms[i]).max().getAsInt());
        }
        System.out.println(Arrays.stream(maxes).distinct().count());
    }
}
