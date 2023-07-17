import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Agario
{

    public static int[] size;
    public static int compare(Integer o1, Integer o2)
    {
        return size[o1 - 1] == size[o2 - 1] ? Integer.compare(o1, o2) : Integer.compare(size[o1 - 1], size[o2 - 1]);
    }
    public static void main(String[] args)
    {
        final long startTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        size = new int[n];
        for(int i = 0; i < n; i++) size[i] = in.nextInt();
//        int[] maxSizeArr = size.clone();
        Map<Integer, SortedSet<Integer>> adjacentPlayers = new HashMap<>();
//        Map<Integer, Set<Integer>> eatenPlayers = new HashMap<>();
        for(int i = 0; i < m; i++)
        {
            int u = in.nextInt();
            int v = in.nextInt();

            adjacentPlayers.putIfAbsent(u, new TreeSet<>(Agario::compare));
            adjacentPlayers.putIfAbsent(v, new TreeSet<>(Agario::compare));

            adjacentPlayers.get(v).add(u);
            adjacentPlayers.get(u).add(v);
//            eatenPlayers.putIfAbsent(u, new HashSet<>());
//            eatenPlayers.putIfAbsent(v, new HashSet<>());

//            if(size[u - 1] < size[v - 1])
//            {
//                eatenPlayers.get(v).add(u);
//                maxSizeArr[v - 1] += size[u - 1];
//                adjacentPlayers.get(u).add(v);
//            }
//            else if(size[u - 1] > size[v - 1])
//            {
//                eatenPlayers.get(u).add(v);
//                maxSizeArr[u - 1] += size[v - 1];
//                adjacentPlayers.get(v).add(u);
//            }
//            else
//            {
//                eatenPlayers.get(u).add(v);
//                maxSizeArr[u - 1] += size[v - 1];
//                eatenPlayers.get(v).add(u);
//                maxSizeArr[v - 1] += size[u - 1];
//            }
        }
//        System.out.println(adjacentPlayers);
//        System.out.println(Arrays.toString(size));
//        System.out.println(Arrays.toString(maxSizeArr));
        for(int i = 0; i < n; i++)
        {
            SortedSet<Integer> updatedPlayers = new TreeSet<>(Agario::compare);
            updatedPlayers.addAll(adjacentPlayers.get(i + 1));

//            Set<Integer> allEaten = eatenPlayers.get(i + 1);
            Set<Integer> allEaten = new HashSet<>();
            allEaten.add(i + 1);

            Iterator<Integer> it = updatedPlayers.iterator();
            int maxSize = size[i];
            while(it.hasNext())
            {
                int player = it.next();
                if(size[player - 1] <= maxSize)
                {
                    allEaten.add(player);
                    updatedPlayers.addAll(adjacentPlayers.get(player));
                    updatedPlayers.removeAll(allEaten);
                    maxSize = maxSize + size[player - 1];
                    it = updatedPlayers.iterator();
                }
                else break;
            }
//            System.out.print(maxSize + " ");
        }
        final long endTime = System.currentTimeMillis();
        System.out.print(endTime - startTime);
    }
}
