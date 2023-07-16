import java.util.*;

public class AgarioRecurisive
{
    public static int[] size;
    public static int[] maxSize;
    public static Map<Integer, SortedSet<Integer>> adjacentPlayers;
    public static Map<Integer, Set<Integer>> eaten;
    public static int compare(Integer o1, Integer o2)
    {
        return size[o1 - 1] == size[o2 - 1] ? Integer.compare(o1, o2) : Integer.compare(size[o1 - 1], size[o2 - 1]);
    }
    public static int findMaxSize(int start, int currSize, Set<Integer> visited)
    {
        visited.add(start);
        System.out.println("Solving for " + start + " (" + maxSize[start - 1] + ")");
        for(int adjacent : adjacentPlayers.get(start))
        {
            if(!eaten.get(start).contains(adjacent))
            {
                if (size[adjacent - 1] <= maxSize[start - 1])
                {
                    System.out.print(" Subproblem of " + start + " (" + maxSize[start - 1] + ")" + ": ");
                    eaten.get(start).add(adjacent);
                    maxSize[start - 1] = findMaxSize(adjacent, maxSize[start - 1] + size[adjacent - 1], new HashSet<>(Arrays.asList(start)));
                }
            }
            if (size[adjacent - 1] <= currSize && !visited.contains(adjacent))
            {
                System.out.print(" Subproblem: ");
                currSize = findMaxSize(adjacent, currSize + maxSize[adjacent - 1], new HashSet<>(visited));
            }
        }
        return currSize;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        size = new int[n];
        adjacentPlayers = new HashMap<>();
        eaten = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            size[i] = in.nextInt();
            adjacentPlayers.put(i + 1, new TreeSet<>(AgarioRecurisive::compare));
            eaten.put(i + 1, new HashSet<>());
        }
        maxSize = size.clone();

        for(int i = 0; i < m; i++)
        {
            int u = in.nextInt();
            int v = in.nextInt();

            adjacentPlayers.get(v).add(u);
            adjacentPlayers.get(u).add(v);
        }

        System.out.println(adjacentPlayers);
        for(int i = 1; i <= n; i++)
        {
            findMaxSize(i, maxSize[i - 1], new HashSet<>());
            System.out.println(eaten.get(i) + " " + maxSize[i - 1] + " ");
        }
    }
}
