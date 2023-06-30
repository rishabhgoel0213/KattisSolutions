import java.util.*;

public class AFavorableEnding
{
    static final long favourable = Long.MAX_VALUE;
    static final long catastrophic = Long.MIN_VALUE;

    public static void updateSolvable(final Map<Long, List<Long>> possibleMoves, Map<Long, Long> solutions, List<Long> toSolve)
    {
        long move = toSolve.get(toSolve.size() - 1);
        if(possibleMoves.get(move).get(0) == favourable)
        {
            toSolve.remove(move);
            solutions.put(move, 1L);
        }
        else if(possibleMoves.get(move).get(0) == catastrophic)
        {
            toSolve.remove(move);
            solutions.put(move, 0L);
        }
        else if(solutions.keySet().containsAll(possibleMoves.get(move)))
        {
            long sum = 0;
            for(long m : possibleMoves.get(move))
            {
                sum += solutions.get(m);
            }
            toSolve.remove(move);
            solutions.put(move, sum);
        }
        else
        {
            toSolve.addAll(possibleMoves.get(move));
        }
    }

    public static long toLong(String s)
    {
        if(s.equals("favourably"))
        {
            return favourable;
        }
        else if(s.equals("catastrophically"))
        {
            return catastrophic;
        }
        return Long.parseLong(s);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine());
        for(int i = 0; i < n; i++)
        {
            long s = Long.parseLong(in.nextLine());
            Map<Long, List<Long>> possibleMoves = new HashMap<>();
            for(int j = 0; j < s; j++)
            {
                String[] line = in.nextLine().split(" ");

                List<Long> choices = new ArrayList<>();
                for(String choice : line)
                    choices.add(toLong(choice));

                possibleMoves.put(choices.remove(0), choices);
            }

            //Dynamic Programming Solution
            Map<Long, Long> solutions = new HashMap<>();
            List<Long> toSolve = new ArrayList<>();
            toSolve.add(1L);

            while(!toSolve.isEmpty())
            {
                updateSolvable(possibleMoves, solutions, toSolve);
            }

            System.out.println(solutions.get(1L));
        }
    }
}
