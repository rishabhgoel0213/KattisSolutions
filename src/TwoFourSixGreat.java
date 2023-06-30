import java.util.*;
import java.util.function.Predicate;

public class TwoFourSixGreat
{
    static int rT;
    public static int compareCheers(List<Integer> o1, List<Integer> o2)
    {
        double ratio = ((double)o2.get(0))/o1.get(0) * o1.get(1);
        if(o2.get(0) < 0 && o1.get(0) > 0)
        {
            return -1;
        }
        else if(o1.get(0) < 0 && o2.get(0) > 0)
        {
            return 1;
        }
        return Double.compare(ratio, (double) o2.get(1));
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();

        Map<List<Integer>, List<Integer>> cheerNums = new TreeMap<>(TwoFourSixGreat::compareCheers);
        Map<Integer, Integer> difficulty = new TreeMap<>();
        Map<Integer, Integer> enthusiasm = new TreeMap<>();

        Map<List<Integer>, Integer> negatives = new HashMap<>();

        cheerNums.put(Arrays.asList(1, 1), Collections.singletonList(1));
        difficulty.put(1, 1);
        enthusiasm.put(1, 1);
        for(int i = 0; i < n; i++)
        {
            int s = in.nextInt();
            int d = in.nextInt();

            if(s > 0)
            {
                cheerNums.put(Arrays.asList(s, d), Collections.singletonList(i + 2));
                difficulty.put(s, d);
                enthusiasm.put(d, s);
            }
            else
            {
                negatives.put(Arrays.asList(s, d), i + 2);
            }
        }

        for(List<Integer> neg : negatives.keySet())
        {
            for(List<Integer> pos : cheerNums.keySet())
            {

                int s = pos.get(0) + neg.get(0);
                int d = pos.get(1) + neg.get(1);

                if(s > 0)
                {
                    cheerNums.put(Arrays.asList(s, d), Arrays.asList(cheerNums.get(pos).get(0), negatives.get(neg)));
                    difficulty.put(s, d);
                    enthusiasm.put(d, s);
                }
                else
                {
                    negatives.put(Arrays.asList(s, d), d);
                }
            }
        }

        int rT = t - 1;
        ArrayList<Integer> cheerOrder = new ArrayList<>();
        cheerOrder.add(1);

        int maxEnthusiasm = cheerNums.keySet().stream().max(Comparator.comparingInt(o -> o.get(0))).get().get(0);
        int bestCheer = cheerNums.keySet().iterator().next().get(0);
        while(maxEnthusiasm > bestCheer)
        {
            cheerNums.remove(Arrays.asList(maxEnthusiasm, difficulty.get(maxEnthusiasm)));
            maxEnthusiasm = cheerNums.keySet().stream().max(Comparator.comparingInt(o -> o.get(0))).get().get(0);
        }


        int numBestCheer = ((rT - maxEnthusiasm) / bestCheer);
        if(maxEnthusiasm == bestCheer)
        {
            numBestCheer++;
        }

        rT -=  numBestCheer * bestCheer;
//        cheerOrder.addAll(Collections.nCopies(numBestCheer, cheerNums.get(Arrays.asList(bestCheer, difficulty.get(bestCheer)))));

        System.out.println(rT);


        System.out.println(cheerOrder.size());
        for(int i = 0; i < cheerOrder.size(); i++)
        {
            System.out.print(cheerOrder.get(i) + " ");
        }
    }
}
