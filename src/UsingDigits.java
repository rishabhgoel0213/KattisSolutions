import java.lang.reflect.Array;
import java.util.*;

public class UsingDigits
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
        Set<List<Object>> minValues = new HashSet<>();
        Map<List<Integer>, Set<List<Object>>> positions = new HashMap<>();
        positions.put(Arrays.asList(0, h - 1), new HashSet<>());
        positions.get(Arrays.asList(0, h - 1)).add(Arrays.asList(sumTrap[0][sumTrap[0].length - 1], codeKey));
        int min = Integer.MAX_VALUE;
        minValues.add(Arrays.asList(0, sumTrap[0].length - 1, sumTrap[0][sumTrap[0].length - 1], codeKey));
        while(!minValues.isEmpty())
        {
            System.out.println(minValues);
            Set<List<Object>> newMinValues = new HashSet<>();
            for(List<Object> val : minValues)
            {
                int x = (Integer) val.get(0);
                int y = (Integer) val.get(1);
                int sum = (Integer) val.get(2);
                Queue<Integer> key = (Queue<Integer>) val.get(3);
                int codeKeyDigit = key.isEmpty() ? 101 : key.peek() + 1;
                if(x == sumTrap.length - 1 && y == 0)
                {
                    int num = (Integer) val.get(2);
                    if(min > num) min = num;
                }
                if(x + 1 < sumTrap.length)
                {
                    newMinValues.add(Arrays.asList(x + 1, y, sum + sumTrap[x + 1][y], key));
                }
                if(y > 0)
                {
                    newMinValues.add(Arrays.asList(x, y - 1, sum + sumTrap[x][y - 1], key));
                }
                if(x + codeKeyDigit < sumTrap.length)
                {
                    Queue<Integer> newKey = new LinkedList<>(key);
                    newKey.poll();
                    newMinValues.add(Arrays.asList(x + codeKeyDigit, y, sum + sumTrap[x + codeKeyDigit][y], newKey));
                }
                if(y - codeKeyDigit >= 0)
                {
                    Queue<Integer> newKey = new LinkedList<>(key);
                    newKey.poll();
                    newMinValues.add(Arrays.asList(x, y - codeKeyDigit, sum + sumTrap[x][y - codeKeyDigit], newKey));
                }

            }
//            for(List<Object> val : newMinValues)
//            {
//                for(List<Object> val2 : newMinValues)
//                {
//                    if(val.get(0).equals(val2.get(0)) && val.get(1).equals(val2.get(1)) && val.get(3).equals(val2.get(3)) && !val.get(2).equals(val2.get(2)))
//                    {
//                        if((Integer)val.get(2) > (Integer)val2.get(2))
//                        {
//
//                        }
//                    }
//                }
//            }
            minValues = newMinValues;
        }
        System.out.print(min);
    }
}
