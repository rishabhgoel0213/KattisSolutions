import java.util.*;

public class UsingDigits3
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
        for(int i = 0; i < h; i++)
        {
            String[] line = in.next().split("");
            for(int j = 0; j < w; j++)
            {
                sumTrap[j][i] = Integer.parseInt(line[j]);
            }
        }
        Map<List<Integer>, Set<List<Object>>> positions = new HashMap<>();
        positions.put(Arrays.asList(0, h - 1), new HashSet<>());
        positions.get(Arrays.asList(0, h - 1)).add(Arrays.asList(sumTrap[0][h - 1], codeKey));
        int min = Integer.MAX_VALUE;
        while(!positions.isEmpty())
        {
            Map<List<Integer>, Set<List<Object>>> newPositions = new HashMap<>();
            for(List<Integer> coords : positions.keySet())
            {
                for(List<Object> uniqueMove : positions.get(coords))
                {
                    int x = coords.get(0);
                    int y = coords.get(1);
                    int sum = (Integer) uniqueMove.get(0);
                    Queue<Integer> key = (Queue<Integer>) uniqueMove.get(3);
                    int codeKeyDigit = key.isEmpty() ? 101 : key.peek() + 1;
                    if(x == sumTrap.length - 1 && y == 0 && sum < min)
                    {
                        min = sum;
                    }
                    if(x + 1 < sumTrap.length)
                    {
                        newPositions.putIfAbsent(Arrays.asList(x + 1, y), new HashSet<>());
                        newPositions.get(Arrays.asList(x + 1, y)).add(Arrays.asList(sum + sumTrap[x + 1][y], key));
                    }
                }
            }
        }
    }
}
