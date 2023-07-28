import java.util.*;

public class PickingUpSticksTopological
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Set<Integer> currSticks = new HashSet<>();
        Map<Integer, Set<Integer>> sticksUnderneath = new HashMap<>();
        Map<Integer, Set<Integer>> sticksAbove = new HashMap<>();

        for(int i = 1; i <= n; i++)
        {
            currSticks.add(i);
            sticksUnderneath.put(i, new HashSet<>());
            sticksAbove.put(i, new HashSet<>());
        }

        for(int i = 0; i < m; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            sticksUnderneath.get(a).add(b);
            sticksAbove.get(b).add(a);
            currSticks.remove(b);
        }

        List<Integer> topoSort = new ArrayList<>();
        while(!currSticks.isEmpty())
        {
            int stick = currSticks.iterator().next();
            currSticks.remove(stick);
            topoSort.add(stick);
            for(int underneath : sticksUnderneath.get(stick))
            {
                if(sticksAbove.get(underneath).size() == 1)
                    currSticks.add(underneath);
                sticksAbove.get(underneath).remove(stick);
            }
            sticksUnderneath.remove(stick);
        }
        if(!sticksUnderneath.isEmpty())
        {
            System.out.println("IMPOSSIBLE");
        }
        else topoSort.forEach(System.out::println);
    }

}
