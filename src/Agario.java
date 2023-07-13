import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Agario
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] size = new int[n];
        for(int i = 0; i < n; i++) size[i] = in.nextInt();
        Map<Integer, Set<Integer>> adjacentPlayers = new HashMap<>();
        for(int i = 0; i < m; i++)
        {
            int u = in.nextInt();
            int v = in.nextInt();
            adjacentPlayers.putIfAbsent(u, new HashSet<>());
            adjacentPlayers.putIfAbsent(v, new HashSet<>());
            adjacentPlayers.get(u).add(v);
            adjacentPlayers.get(v).add(u);
        }

        for(int i = 0; i < n; i++)
        {
            Map<Set<Integer>, Integer> eatingOrder;
            Map<Set<Integer>, Integer> newEatingOrder = new HashMap<>();
            newEatingOrder.put(new HashSet<>(Arrays.asList(i + 1)), size[i]);
            int maxSize = size[i];
            while(!newEatingOrder.isEmpty())
            {
                eatingOrder = newEatingOrder;
                System.out.println(newEatingOrder);
                newEatingOrder = new HashMap<>();
                for (Set<Integer> path : eatingOrder.keySet())
                {
                    Set<Integer> allAdjacentPlayers = new HashSet<>();
                    for(int key : path)
                    {
                        allAdjacentPlayers.addAll(adjacentPlayers.get(key));
                    }
                    path.forEach(allAdjacentPlayers::remove);
                    for (int player : allAdjacentPlayers)
                    {
                        if (size[player - 1] <= eatingOrder.get(path))
                        {
                            Set<Integer> newPath = new HashSet<>(path);
                            newPath.add(player);
                            int newSize = eatingOrder.get(path) + size[player - 1];
                            if(newSize > maxSize) maxSize = newSize;
                            newEatingOrder.put(newPath, newSize);

                        }
                    }
                }
            }
            System.out.println(maxSize + " ");
        }

    }
}
