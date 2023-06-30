import java.util.*;

public class Airports
{
    public static boolean validSetup(SortedMap<Integer, Map<Integer, Integer>> flights, List<Integer> startingLocs, int[] inspectionTimes, int[][] flightTimes, int m)
    {
        List<Integer> planeLocations = new ArrayList<>();
        for(Integer t : startingLocs)
            planeLocations.addAll(flights.get(t).keySet());
        System.out.println(planeLocations);
        int t = startingLocs.get(0);
        int numRealized = 0;
        while(t <= flights.lastKey())
        {
            if(flights.containsKey(t))
            {
                for(Integer s : flights.get(t).keySet())
                {
                    if(planeLocations.contains(s))
                    {
                        planeLocations.remove(s);

                        int f = flights.get(t).get(s);
                        planeLocations.add(f);
                        System.out.println(planeLocations);

                        t += inspectionTimes[s - 1] + flightTimes[s - 1][f - 1] - 1;

                        System.out.println(t);
                        numRealized++;

                    }
                }
            }
            t++;
        }

        System.out.println(numRealized);
        return numRealized == m;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] inspectionTimes = new int[n];
        int[][] fightTimes = new int[n][n];


        for(int i = 0; i < n; i++)
            inspectionTimes[i] = in.nextInt();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                fightTimes[i][j] = in.nextInt();
            }
        }

        SortedMap<Integer, Map<Integer, Integer>> flights = new TreeMap<>();
        for(int i = 0; i < m; i++)
        {
            int s = in.nextInt();
            int f = in.nextInt();
            int t = in.nextInt();
            flights.putIfAbsent(t, new HashMap<>());
            flights.get(t).put(s, f);
        }

        List<Integer> startingLocs = new ArrayList<>();
        startingLocs.add(flights.firstKey());
        while(!validSetup(flights, startingLocs, inspectionTimes, fightTimes, m));
        System.out.println(startingLocs.size());

    }
}
