import java.util.Scanner;

public class TakeTwoStones
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int numStones = in.nextInt();
        int[] sequence = new int[numStones];
        for(int i = 0; i < numStones; i++)
        {
            sequence[i] = 1;
        }

    }
}
