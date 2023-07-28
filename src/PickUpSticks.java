import java.util.*;
public class PickUpSticks
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> topoSort = new ArrayList<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> zeroDegree = new HashSet<>();
        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        for(int i = 1; i <= n; i++)
        {
            inDegree.put(i, 0);
            zeroDegree.add(i);
            neighbors.put(i, new HashSet<>());
        }
        for(int i = 0; i < m; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            inDegree.put(b, inDegree.get(b) + 1);
            zeroDegree.remove(b);
            neighbors.get(a).add(b);
        }
        Queue<Integer> queue = new LinkedList<>(zeroDegree);
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            inDegree.remove(node);
            topoSort.add(node);
            for(int neighbor : neighbors.get(node))
            {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                int degree = inDegree.get(neighbor);;
                if(degree == 0) queue.add(neighbor);
            }
            neighbors.remove(node);
        }
        if(inDegree.isEmpty()) topoSort.forEach(System.out::println);
        else System.out.println("IMPOSSIBLE");
    }
}
