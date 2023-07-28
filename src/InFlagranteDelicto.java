import java.util.*;

public class InFlagranteDelicto
{
    static Map<Integer, Set<Integer>> prosEvents = new HashMap<>();
    static Map<Integer, Set<Integer>> defsEvents = new HashMap<>();
    public static int findMinLen(int len, int E)
    {
//        System.out.print(E + " ");
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
            }
        }
        return min;
    }
    public static int findMinLenDef(int len, int E)
    {
//        System.out.print(E + " ");
        int min = Integer.MAX_VALUE;
        for(int D : defsEvents.get(E))
        {
            if(!prosEvents.get(E).contains(D)) return len;
        }
        for(int D : defsEvents.get(E))
        {
            int newLen = findMinLenDef(1 + len, D);
            if(newLen < min)
            {
                min = newLen;
            }
        }
        return min;
    }
    public static int findMinLenAll(int len, int E)
    {
//        System.out.print(E + " ");
        int max = 2;
        boolean done = true;
        Set<Integer> invalid = new LinkedHashSet<>();
        for(int P : prosEvents.get(E))
        {
            if(defsEvents.get(E).contains(P)) invalid.add(P); done = false;
        }
        if(done) return len;
        for(int P : invalid)
        {
            int newLen = findMinLenAll(1 + len, P);
            if(newLen > max)
            {
                max = newLen;
            }
        }
        return max;
    }
    public static int findMinLenAllDef(int len, int E)
    {
//        System.out.print(E + " ");
        int max = 2;
        boolean done = true;
        Set<Integer> invalid = new LinkedHashSet<>();
        for(int D : defsEvents.get(E))
        {
            if(prosEvents.get(E).contains(D)) invalid.add(D); done = false;
        }
        if(done) return len;
        for(int D : invalid)
        {
            int newLen = findMinLenAllDef(1 + len, D);
            if(newLen > max)
            {
                max = newLen;
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++)
        {
            int P = in.nextInt();
            prosEvents.put(P, new LinkedHashSet<>());
            for(int E : prosEvents.keySet())
            {
                prosEvents.get(E).add(P);
                prosEvents.get(E).remove(E);
            }
        }

        for(int i = 0; i < N; i++)
        {
            int D = in.nextInt();
            defsEvents.put(D, new LinkedHashSet<>());
            for(int E : defsEvents.keySet())
            {
                defsEvents.get(E).add(D);
                defsEvents.get(E).remove(E);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = 2;
        for(int E : prosEvents.keySet())
        {
            int len = findMinLen(2, E);
//            System.out.println();
            if(len < min) min = len;
            int lenAll = findMinLenAll(2, E);
//            System.out.println();
            if(lenAll > max) max = lenAll;
        }
        for(int E : defsEvents.keySet())
        {
            int len = findMinLenDef(2, E);
//            System.out.println();
            if(len < min) min = len;
            int lenAll = findMinLenAllDef(2, E);
//            System.out.println();
            if(lenAll > max) max = lenAll;
        }
        System.out.println(2 + " " + max);
    }

}
