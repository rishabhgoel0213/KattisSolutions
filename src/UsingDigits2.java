import java.util.*;

public class UsingDigits2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();

        Queue<Integer> codeKey = new LinkedList<>();
        String[] codeKeyVal = in.next().split("");
        for(int i = 0; i < codeKeyVal.length; i++)
        {
            codeKey.add(Integer.parseInt(codeKeyVal[i]));
        }

        int[][] sumTrap = new int[w][h];

        Map<Integer, List<Integer>> distances = new TreeMap<>();
        Map<List<Integer>, Integer> distancesInvert = new HashMap<>();
        int startX = 0;
        int startY = h - 1;
        int delta = 0;
        for(int i = 0; i < h; i++)
        {
            String[] line = in.next().split("");
            for(int j = 0; j < w; j++)
            {
                sumTrap[j][i] = Integer.parseInt(line[j]);
                if(j == startX && i == startY)
                {
                    distances.put(0, Arrays.asList(j, i));
                    distancesInvert.put(Arrays.asList(j, i), 0);
                }
                else
                {
                    distances.put(1000 + delta, Arrays.asList(j, i));
                    distancesInvert.put(Arrays.asList(j, i), 1000 + delta);
                    delta++;
                }
            }
        }
        System.out.println(distances);

        Iterator<Integer> it = distances.keySet().iterator();
        while(it.hasNext())
        {
            int minDist = it.next();
            List<Integer> vertex = distances.get(minDist);
            int x = vertex.get(0);
            int y = vertex.get(1);
            System.out.println(x + " " + y);
            if(x + 1 < w)
            {
                int alt = minDist + sumTrap[x + 1][y];
                int curr = distancesInvert.get(Arrays.asList(x + 1, y));
                if(alt < curr)
                {
                    distances.remove(curr);
                    distances.put(alt, Arrays.asList(x + 1, y));
                    distancesInvert.put(Arrays.asList(x + 1, y), alt);
                    it = distances.keySet().iterator();
                }
            }
            if(y > 0)
            {
                int alt = minDist + sumTrap[x][y - 1];
                int curr = distancesInvert.get(Arrays.asList(x, y - 1));
                if(alt < curr)
                {
                    distances.remove(curr);
                    distances.put(alt, Arrays.asList(x, y - 1));
                    distancesInvert.put(Arrays.asList(x, y - 1), alt);
                    it = distances.keySet().iterator();
                }
            }
        }
        System.out.println(distances);
        System.out.println(distancesInvert);
        System.out.println(distancesInvert.get(Arrays.asList(w - 1, 0)));
    }
}
