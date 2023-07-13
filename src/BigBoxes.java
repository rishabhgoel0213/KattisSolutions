import java.util.*;

public class BigBoxes
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        SortedMap<Integer, Set<Integer>> items = new TreeMap<>();
        int[] itemsArr = new int[n];
        for(int i = 0; i < n; i++)
        {
            int weight = in.nextInt();
            items.putIfAbsent(weight, new HashSet<>());
            items.get(weight).add(i);
            itemsArr[i] = weight;
        }

        Map<Set<Integer>, Integer> boxes = new HashMap<>();

        while(!items.isEmpty())
        {

        }

    }

}
