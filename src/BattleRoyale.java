import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BattleRoyale
{
    public static Map<Integer, Integer> findCosts(Map<Integer, Integer> costs, int[] L, int[] C, int N, int M)
    {
        Map<Integer, Integer> newCosts = new ConcurrentHashMap<>();
        for(Integer value : costs.keySet())
        {
            for(int i = 0; i < N; i++)
            {
                if(value + L[i] <= M)
                {
                    int currentCost = costs.getOrDefault(value + L[i], newCosts.getOrDefault(value + L[i], Integer.MAX_VALUE));
                    newCosts.put(value + L[i], Math.min(costs.get(value) + C[i], currentCost));
                }
            }
        }
        return newCosts;

    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();

        for(int j = 0; j < S; j++)
        {
            int M = in.nextInt();
            int N = in.nextInt();

            int[] L = new int[N];
            for (int i = 0; i < N; i++)
                L[i] = in.nextInt();

            int[] C = new int[N];
            for (int i = 0; i < N; i++)
                C[i] = in.nextInt();

            Map<Integer, Integer> costs = new ConcurrentHashMap<>();
            costs.put(0, 0);

            int minCost = Integer.MAX_VALUE;

            while(!costs.isEmpty())
            {
                costs = findCosts(costs, L, C, N, M);
                minCost = Math.min(costs.getOrDefault(M, Integer.MAX_VALUE), minCost);
            }

            System.out.println(minCost);
        }
    }
}

//2
//9
//3
//1 7 3
//6 1 3
//3
//2
//1 2
//2 1
//
