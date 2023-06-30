import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlternatingCurrent
{
    public static Set<Integer> swapOrientation(Map<Integer, Set<Integer>> wires, List<Integer> clockwise, List<Integer> counterClockwise, Set<Integer> positions)
    {
        Set<Integer> clockCounter = new HashSet<>();
        for(Integer i : clockwise)
        {
            clockCounter.addAll(wires.get(i));
        }
        if(!clockCounter.containsAll(positions))
        {
            Set<Integer> left = new HashSet<>(positions);
            left.removeAll(clockCounter);
            left.add(Integer.MAX_VALUE);
            return left;
        }
        Set<Integer> counterClockCounter = new HashSet<>();
        for(Integer i : counterClockwise)
        {
            counterClockCounter.addAll(wires.get(i));
        }
        if(!counterClockCounter.containsAll(positions))
        {
            Set<Integer> left = new HashSet<>(positions);
            left.removeAll(counterClockCounter);
            left.add(Integer.MIN_VALUE);
        }
        return new HashSet<>();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Set<Integer>> wires = new HashMap<>();
        List<Integer> clockwise = new ArrayList<>();
        List<Integer> counterClockwise = new ArrayList<>();
        Set<Integer> positions = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        for(int i = 0; i < m; i++)
        {
            clockwise.add(i);
            wires.put(i, new HashSet<>());
            int a = in.nextInt();
            int b = in.nextInt();
            if(a <= b)
            {
                for(int j = a; j <= b; j++)
                {
                    wires.get(i).add(j);
                }
            }
            else
            {
                for(int j = a; j <= n; j++)
                {
                    wires.get(i).add(j);
                }
                for(int j = 1; j <= b; j++)
                {
                    wires.get(i).add(j);
                }
            }

            boolean complete = false;
            while(!complete)
            {
                Set<Integer> left = swapOrientation(wires, clockwise, counterClockwise, positions);
                complete = left.isEmpty();

                if(!complete)
                {
                    if(left.contains(Integer.MAX_VALUE))
                    {

                    }
                }

            }
        }




    }
}
