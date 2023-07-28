import java.util.*;

public class InFragranteDelictoCombos
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String zeros = "000000000000000000000000000000";
        int N = in.nextInt();
        int[] prosEvents = new int[N];
        for(int i = 0; i < N; i++) prosEvents[i] = in.nextInt();
        int[] defsEvents = new int[N];
        for(int i = 0; i < N; i++) prosEvents[i] = in.nextInt();
        Map<Integer, Set<Set<Integer>>> subsetsPro = new HashMap<>();
        for(int i = 1; i <= N; i++)
        {
            subsetsPro.put(i, new HashSet<>());
        }
        Map<Integer, Set<Set<Integer>>> subsetsDef = new HashMap<>();
        for(int i = 1; i <= N; i++)
        {
            subsetsDef.put(i, new HashSet<>());
        }
        for(int i = 2; i < Math.pow(2, N); i++)
        {
            String binary = Integer.toBinaryString(i);
            binary = zeros.substring(0, (N - binary.length())) + binary;
            System.out.println(binary);
            Set<Integer> subPro = new HashSet<>();
            Set<Integer> subDef = new HashSet<>();
            for(int j = 0; j < binary.length(); j++)
            {
                if(binary.charAt(j) == '1')
                {
                    subPro.add(prosEvents[j]);
                    subDef.add(defsEvents[j]);
                }
            }
            subsetsPro.get(subPro.size()).add(subPro);
            subsetsDef.get(subPro.size()).add(subDef);
        }
        int kP = 0;
        int kR = 0;
        boolean rDone = true;
        boolean pDone = true;
        for(int i = 2; i < N; i++)
        {
            boolean r = rDone;
            boolean p = false;
            for(Set<Integer> set : subsetsPro.get(i))
            {
                System.out.println(set);
                if(subsetsDef.get(i).contains(set)) r = false;
                else p = pDone;
            }
            if(r) kR = i; rDone = false;
            if(p) kP = i; pDone = false;
        }
        System.out.print(kP + " " + kR);
    }
}
