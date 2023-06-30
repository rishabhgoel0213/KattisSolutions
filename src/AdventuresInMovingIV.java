import java.util.*;

public class AdventuresInMovingIV
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int dist = in .nextInt();
        final int tankSize = 200;
        int amount = 100;
        SortedMap<Integer, Integer> gasStations = new TreeMap<>();
        while(in.hasNextInt())
        {
            int stationDist = in.nextInt();
            int cost = in.nextInt();
            gasStations.put(cost, stationDist);
        }


    }
}
