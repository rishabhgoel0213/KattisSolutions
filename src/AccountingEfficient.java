import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountingEfficient
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] lines = new String[nums[1]][];

        Map<Integer, Integer> setIndexes = new HashMap<>();
        int restartIndex = -1;

        for(int i = 0; i < nums[1]; i++)
        {
            lines[i] = in.nextLine().split(" ");

            if(lines[i][0].equals("RESTART"))
            {
                restartIndex = i;
            }
            else if(lines[i][0].equals("SET"))
            {
                setIndexes.put(Integer.parseInt(lines[i][1]), i);
            }

            else if(lines[i][0].equals("PRINT"))
            {
                int person = Integer.parseInt(lines[i][1]);
                int wealth = 0;

                if(restartIndex != -1)
                {
                    wealth = Integer.parseInt(lines[restartIndex][1]);
                }
                if(setIndexes.containsKey(person))
                {
                    int j = setIndexes.get(person);
                    if(j > restartIndex)
                    {
                        wealth = Integer.parseInt(lines[j][2]);
                    }
                }

                System.out.println(wealth);
            }
        }
    }
}
