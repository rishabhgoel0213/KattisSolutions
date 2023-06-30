import java.util.*;
import java.util.stream.Collectors;

public class OneDFroggerHard
{


    static Map<Integer, Set<Integer>> paths = new HashMap<>();

    public static int test(int n, int[] values)
    {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int n = in.nextInt();
//        int[] values = new int[n];
//        for(int i = 0; i < n; i++)
//        {
//            values[i] = in.nextInt();
//        }

        for(int i = 0; i < n; i++)
        {
            if(paths.containsKey(i))
            {
                continue;
            }
            paths.put(i, new LinkedHashSet<>());

            int j = i;
            while (j >= 0 && j < values.length && !paths.get(i).contains(j))
            {
                for(Integer visited : paths.get(i))
                {
                    if(!paths.containsKey(visited))
                    {
                        paths.put(visited, new LinkedHashSet<>());
                        paths.get(visited).add(visited);
                        paths.get(visited).add(j);
                    }
                }
                paths.get(i).add(j);
                int increment = values[j];
                j += increment;
            }
        }


        int total = 0;
        for(Set<Integer> path : paths.values())
        {
            total += path.size();
        }
//        System.out.println(total);
        return total;
    }

    public static void main(String[] args)
    {}

}
