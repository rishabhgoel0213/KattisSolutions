
import java.util.*;

public class AFeastForCats2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int k = 0; k < t; k++)
        {
            String[] line = in.nextLine().split(" ");
            int m = Integer.parseInt(line[0]) - 1;
            int c = Integer.parseInt(line[1]);
            List<List<Integer>> distances = new ArrayList<>();
            Set<Integer> found = new HashSet<>();
            Set<Integer> goal = new HashSet<>();

            for(int i = 0; i < c; i++) goal.add(i);
            found.add(0);

            for (int l = 0; l < (c * (c - 1)) / 2; l++)
            {
                line = in.nextLine().split(" ");
                int i = Integer.parseInt(line[0]);
                int j = Integer.parseInt(line[1]);
                int d = Integer.parseInt(line[2]);
                distances.add(Arrays.asList(i, j, d));

            }
            distances.sort(Comparator.comparing(o -> o.get(2)));

            System.out.println(distances);
            while(!found.containsAll(goal))
            {
                for (List<Integer> d : distances)
                {
                    if (found.contains(d.get(0)) ^ found.contains(d.get(1)))
                    {
                        found.add(d.get(0));
                        found.add(d.get(1));
                        System.out.println(d);
                        m -= d.get(2) + 1;
                        if (m < 0)
                        {
                            System.out.println("no");
                            return;
                        }
                    }
                }
            }
            System.out.println("yes");
        }
    }
}
