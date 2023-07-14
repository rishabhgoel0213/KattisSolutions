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
            Set<Integer> updatedPlayers = new HashSet<>(adjacentPlayers.get(i + 1));
            Iterator<Integer> it = updatedPlayers.iterator();
            Set<Integer> allEaten = new HashSet<>();
            allEaten.add(i + 1);
            int maxSize = size[i];
            int player;
            while(it.hasNext())
            {
                player = it.next();
                if (size[player - 1] <= maxSize)
                {
                    allEaten.add(player);
                    updatedPlayers.addAll(adjacentPlayers.get(player));
                    updatedPlayers.removeAll(allEaten);
                    maxSize = maxSize + size[player - 1];
                    it = updatedPlayers.iterator();
                }
            }
            System.out.print(maxSize + " ");
        }

    }
}
