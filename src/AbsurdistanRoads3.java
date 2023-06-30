import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AbsurdistanRoads3
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Map<Integer, List<Integer>> connections = new ConcurrentHashMap<>();
        int n = in.nextInt();

        for(int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();

            connections.putIfAbsent(a, new ArrayList<>());
            connections.putIfAbsent(b, new ArrayList<>());

            connections.get(a).add(b);
            connections.get(b).add(a);
        }


        while(!connections.isEmpty())
        {
            for(Integer key : connections.keySet())
            {
                if (connections.get(key).size() == 1)
                {
                    if(connections.get(key).isEmpty())
                    {
                        System.out.println("error");
                        return;
                    }
                    int value = connections.get(key).get(0);
                    connections.getOrDefault(value, new ArrayList<>()).remove(key);
                    connections.remove(key);
                    System.out.println(key + " " + value);
                }
            }


            if(connections.isEmpty())
                break;

            Integer key = connections.keySet().iterator().next();

            if(connections.get(key).isEmpty())
            {
                System.out.println("error");
                return;
            }

            Integer value = connections.get(key).get(0);

            connections.getOrDefault(value, new ArrayList<>()).remove(key);
            connections.remove(key);
            System.out.println(key + " " + value);
        }


    }
}
