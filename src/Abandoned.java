import java.util.*;
import java.util.stream.Stream;

public class Abandoned
{
    static Map<Integer, Set<String>> availableItems = new HashMap<>();
    static String[] items;

    public static int isPathPossible(int startStore, int startItem)
    {
        if(startItem == items.length)
        {
            return 1;
        }
        else
        {
            ArrayList<Integer> all = new ArrayList<>();
            for(int i = startStore; i < availableItems.size(); i++)
            {
                if(availableItems.get(i).contains(items[startItem]))
                {
                    all.add(isPathPossible(i, startItem + 1));
                }
            }

            long count = all.stream().filter(n -> n == 1).count();
            if(count == 1)
            {
                return 1;
            }
            else if(count != 0)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        for(int i = 0; i < k; i++){availableItems.put(i, new HashSet<>());}

        //add available items at each store
        String[] line = (in.next() + in.nextLine()).split(" ");
        availableItems.get(Integer.parseInt(line[0])).add(line[1]);
        for(int i = 1; i < k; i++)
        {
            line = in.nextLine().split(" ");
            availableItems.get(Integer.parseInt(line[0])).add(line[1]);
        }

        //add items to shopping list
        int m = Integer.parseInt(in.nextLine());
        items = Arrays.stream(new String[m]).map(s -> in.nextLine()).toArray(String[]::new);

        //recursively test all possibilities to see if information is possiblly true
        int p = isPathPossible(0, 0);
        switch(p)
        {
            case 1:
                System.out.println("unique");
                break;
            case 0:
                System.out.println("ambiguous");
                break;
            case -1:
                System.out.println("impossible");
                break;
        }

    }
}
