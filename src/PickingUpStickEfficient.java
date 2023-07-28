import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickingUpStickEfficient
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> topoSort = new ArrayList<>();
        Map<Integer, Integer> edges = new HashMap<>();
        Map<Integer, Integer> altEdges = new HashMap<>();

        for(int i = 0; i < m; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            if(altEdges.containsKey(a))
            {
                topoSort.add(topoSort.indexOf(altEdges.get(a)), a);
            }
        }

    }
}
