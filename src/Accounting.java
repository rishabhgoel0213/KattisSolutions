import java.util.Arrays;
import java.util.Scanner;

public class Accounting
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] wealth = new int[nums[0]];
        Arrays.fill(wealth, 0);


        for(int i = 0; i < nums[1]; i++)
        {
            String[] line = in.nextLine().split(" ");

            if(line[0].equals("SET"))
            {
                int person = Integer.parseInt(line[1]) - 1;
                int value = Integer.parseInt(line[2]);
                wealth[person] = value;
            }
            else if(line[0].equals("PRINT"))
            {
                int person = Integer.parseInt(line[1]) - 1;
                System.out.println(wealth[person]);
            }
            else if(line[0].equals("RESTART"))
            {
                int value = Integer.parseInt(line[1]);
                Arrays.fill(wealth, value);
            }
        }
    }
}
