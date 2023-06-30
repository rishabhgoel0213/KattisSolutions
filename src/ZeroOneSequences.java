import java.util.ArrayList;
import java.util.Scanner;

public class ZeroOneSequences
{
    public static int triangleNum(int n)
    {
        return (n * (n + 1)) / 2;
    }
    public static int partialTriangleNum(int n, int m)
    {
        return triangleNum(n) - triangleNum(m);
    }

    public static int numSequences(int j, int lastOne, int nonPossiblities, int numQs)
    {
        int total = 0;
        int n = j;
        for(int i = n; i < lastOne; i++)
        {
            total += (j * Math.pow(numQs, j));
            j--;
        }
        return total - nonPossiblities;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String sequence = in.nextLine();
        ArrayList<Integer> maxSwaps = new ArrayList<>();
        int lastOne = 0;

        int j = 0;
        int total = 0;
        int nonPossibilities = 0;
        int numQs = 0;
        for(int i = sequence.length() - 1; i >= 0; i--)
        {
            switch(sequence.charAt(i))
            {
                case '?':
                    total += numSequences(j, lastOne, nonPossibilities, numQs);
                    numQs++;
                    break;
                case '1':
                    total += partialTriangleNum(j, lastOne) - nonPossibilities;
                    lastOne = j;
                    break;

            }
            if(i != sequence.length() - 1)
            {
                if(sequence.charAt(i + 1) == '0')
                {
                    System.out.println(j);
                    nonPossibilities += numSequences(j - 2, lastOne, nonPossibilities, numQs);
                }
            }
            j++;
        }

        System.out.println(total);
    }
}
