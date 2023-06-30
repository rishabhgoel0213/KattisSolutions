import java.util.Arrays;
import java.util.Scanner;

public class MazeMaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] dims = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while(dims[0] != 0)
        {
            Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
    }
}
