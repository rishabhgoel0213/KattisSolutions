import java.util.*;

public class InFlagranteDelicto
{
    static Map<Integer, Set<Integer>> prosEvents = new HashMap<>();
    static Map<Integer, Set<Integer>> defsEvents = new HashMap<>();
    public static int findMinLen(int len, int E)
    {
        int min = Integer.MAX_VALUE;
        for(int P : prosEvents.get(E))
        {
            if(!defsEvents.get(E).contains(P)) return len;
        }
        for(int P : prosEvents.get(E))
        {
            int newLen = findMinLen(1 + len, P);
            if(newLen < min)
            {
                min = newLen;
                System.out.println(E + ", " + P);
            }
        }
        return min;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++)
        {
            int P = in.nextInt();
            prosEvents.put(P, new HashSet<>());
            for(int E : prosEvents.keySet())
            {
                prosEvents.get(E).add(P);
                prosEvents.get(E).remove(E);
            }
        }

        for(int i = 0; i < N; i++)
        {
            int D = in.nextInt();
            defsEvents.put(D, new HashSet<>());
            for(int E : defsEvents.keySet())
            {
                defsEvents.get(E).add(D);
                defsEvents.get(E).remove(E);
            }
        }

        System.out.println(prosEvents);
        System.out.println(defsEvents);
        for(int E : prosEvents.keySet())
        {
            System.out.println(findMinLen(2, E) + " ");
        }



    }

}
