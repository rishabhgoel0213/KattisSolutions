import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AgamemnonOdyssey
{
    public static int maxResources(int k, int currentIsland, Map<Integer, Map<Integer, int[]>> paths, Map<Integer, int[]> visitedPaths)
    {
        int max = 0;
        int maxIsland = currentIsland;
        for(Integer island : paths.get(currentIsland).keySet())
        {
            if(paths.get(currentIsland).get(island)[1] < k)
            {
                System.out.println(currentIsland + " " + island);
                paths.get(currentIsland).get(island)[1]++;
                paths.get(island).get(currentIsland)[1]++;

                int pathValue;
                if(visitedPaths.containsKey(island) && visitedPaths.get(island)[0] != currentIsland && paths.get(currentIsland).get(island)[1] - 1 == 0)
                {
                    pathValue = paths.get(currentIsland).get(island)[0] + visitedPaths.get(island)[1];
                    System.out.println("skipped search: " + pathValue);
                }
                else if(paths.get(currentIsland).get(island)[1] - 1 != 0)
                {
                    pathValue = maxResources(k, island, paths, visitedPaths);
                    System.out.println("path value: " + pathValue);
                }
                else
                {
                    pathValue = paths.get(currentIsland).get(island)[0] + maxResources(k, island, paths, visitedPaths);
                    System.out.println("path value: " + pathValue);
                }

//                visitedPaths.put(island, new int[]{currentIsland, pathValue});

                paths.get(currentIsland).get(island)[1]--;
                paths.get(island).get(currentIsland)[1]--;

                if(pathValue > max)
                {
                    maxIsland = island;
                    max = pathValue;
                }

            }

        }
        visitedPaths.put(currentIsland, new int[]{maxIsland, max});
        System.out.println();
        return max;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        Map<Integer, Map<Integer, int[]>> paths = new HashMap<>();

        for(int i = 0; i < n - 1; i++)
        {
            int u = in.nextInt();
            int v = in.nextInt();
            int c = in.nextInt();

            paths.putIfAbsent(u, new HashMap<>());
            paths.putIfAbsent(v, new HashMap<>());

            paths.get(u).put(v, new int[]{c, 0});
            paths.get(v).put(u, new int[]{c, 0});
        }

        int max = 0;
        Map<Integer, int[]> visitedPaths = new HashMap<>();
        for(Integer island : paths.keySet())
        {
            max = Math.max(max, maxResources(k, island, paths, visitedPaths));
        }

        System.out.println(max);
    }
}
