import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickingUpSticks
{
    public static Set<Integer> sticks;
    public static SortedSet<Integer> pickedUpOrder(Map<Integer, Set<Integer>> sticksOnTop, SortedSet<Integer> removedList)
    {
        if(removedList.containsAll(sticks))
        {
            return removedList;
        }
        boolean stickRemoved = false;
        for(Integer key : sticksOnTop.keySet())
        {
            if(!removedList.isEmpty())
                sticksOnTop.get(key).remove(removedList.last());
            if(sticksOnTop.get(key).isEmpty())
            {
                removedList.add(key);
//                sticksOnTop.remove(key);
                stickRemoved = true;
            }
        }
        if(!stickRemoved)
        {
            System.out.println("Impossible");
            return new TreeSet<>();
        }
        return pickedUpOrder(sticksOnTop, removedList);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Set<Integer>> sticksOnTop = new HashMap<>();
        sticks = IntStream.range(1, n).boxed().collect(Collectors.toSet());
        for(int i = 1; i <= n; i++)
        {
            sticksOnTop.put(i, new HashSet<>());
        }
        for(int i = 0; i < m; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            sticksOnTop.get(b).add(a);
        }

        SortedSet<Integer> order = pickedUpOrder(sticksOnTop, new TreeSet<>());
        order.forEach(System.out::println);

    }
}
