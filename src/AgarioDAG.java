import java.util.*;

public class AgarioDAG
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] size = new int[n];
        Map<Integer, Integer> sortedConnections = new TreeMap<>();
        Map<Integer, Map<Integer, Set<Integer>>> directedGraphs = new HashMap<>();
        for(int i = 0; i < n; i++) size[i] = in.nextInt();
        for(int i = 0; i < m; i++)
        {
            int u = in.nextInt();
            int v = in.nextInt();
            sortedConnections.put(u, v);
            sortedConnections.put(v, u);
        }
        Iterator<Integer> it = sortedConnections.keySet().iterator();
        for(int i = 1; i <= n; i++)
        {
            while(it.hasNext() && it.next() == i)
            {

            }
        }

    }

}
