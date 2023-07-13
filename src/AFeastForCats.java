import java.util.*;

public class AFeastForCats
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
            int[][] distances = new int[c][c];
            for(int l = 0; l < (c * (c - 1)) / 2; l++)
            {
                line = in.nextLine().split(" ");
                int i = Integer.parseInt(line[0]);
                int j = Integer.parseInt(line[1]);
                int d = Integer.parseInt(line[2]);
                distances[i][j] = d;
                distances[j][i] = d;
            }
            Map<List<Integer>, Set<Integer>> paths = new HashMap<>();

            Set<Integer> notFinished = new HashSet<>();
            for(int i = 0; i < c; i++) notFinished.add(i);

            paths.put(Arrays.asList(0, m), new HashSet<>());
            paths.get(Arrays.asList(0, m)).add(0);

            boolean exit = false;
            while(!paths.keySet().isEmpty() && !exit)
            {
                Map<List<Integer>, Set<Integer>> add = new HashMap<>();
                for(List<Integer> option : paths.keySet())
                {
                    Set<Integer> copy = new HashSet<>(notFinished);
                    notFinished.remove(option.get(0));
                    for(int i : notFinished)
                    {
                        int milkRemaining = option.get(1);
                        if(!paths.get(option).contains(i)) milkRemaining -= distances[option.get(0)][i] + 1;
                        if(milkRemaining >= 0)
                        {

                            List<Integer> newOption = Arrays.asList(i, milkRemaining);
                            add.put(newOption, new HashSet<>(paths.get(option)));
                            add.get(newOption).add(i);

                            if(add.get(newOption).containsAll(copy) && !exit)
                            {
                                System.out.println("yes");
                                exit = true;
                            }
                        }
                    }
                    notFinished = new HashSet<>(copy);
                }
                paths = add;
//                System.out.println(add.values());
            }
//            System.out.println(notFinished);
            if(!exit)
            {
                System.out.println("no");
            }

        }
    }
}
