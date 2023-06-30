import java.util.*;

public class Winnable
{

    public static boolean isWinnable(ArrayList<ArrayList<Integer>> alliances, Set<Integer> prevUndefeated, int rival)
    {

        if(alliances.get(rival).size() < 2)
        {
            return true;
        }
        else
        {
            prevUndefeated.add(rival);
            int numWinnable = 0;
            for(int i = 0; i < alliances.get(rival).size(); i++)
            {
                int winnable = 0;
                if(!prevUndefeated.contains(alliances.get(rival).get(i)))
                {
                    if(isWinnable(alliances, prevUndefeated, alliances.get(rival).get(i)))
                    {
                        winnable = 1;
                    }
                }
                numWinnable += winnable;
            }
            return alliances.get(rival).size() - numWinnable < 2;
        }
    }
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String[] strNums = in.nextLine().split(" ");
        int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
        ArrayList<ArrayList<Integer>> alliances = new ArrayList<>();
        for(int i = 0; i < nums[0]; i++)
        {
            alliances.add(new ArrayList<>());
        }
        for(int i = 0; i < nums[2]; i++)
        {
            String[] line = in.nextLine().split(" ");
            int[] alliance = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            alliances.get(alliance[0] - 1).add(alliance[1] - 1);
            alliances.get(alliance[1] - 1).add(alliance[0] - 1);
        }

        if(isWinnable(alliances, new HashSet<Integer>(), nums[1] - 1))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }

    }
}
