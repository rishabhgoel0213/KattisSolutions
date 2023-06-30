import java.util.*;

public class OneDFroggerHardTwo
{

    public static int triangleNum(int n)
    {
        return (n * (n + 1)) / 2;
    }
//    public static int partialTriangleNum(int n, int m)
//    {
//        return triangleNum(n) - triangleNum(m);
//    }
//    public static int loopNum(int n)
//    {
//        return n * n;
//    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        int[] pathLen = new int[n];
        for(int i = 0; i < n; i++)
        {
            values[i] = in.nextInt();
        }

        Set<Integer> visited = new HashSet<>();

        long total = 0;
        for(int i = 0; i < n; i++)
        {
            if(!visited.contains(i))
            {
//                System.out.println(i);

                Map<Integer, Integer> path = new HashMap<>();

                int j = i + values[i];
                int reiterateLen = 0;

                boolean outOfBounds = j < 0 || j >= values.length;
                boolean loop = false;

                int k = 0;
                int len = 0;
                while(!loop && !outOfBounds)
                {
                    path.put(j, k);
                    visited.add(j);

                    j += values[j];

                    outOfBounds = j < 0 || j >= n;
                    len = path.size() + 1;
                    if(j == i)
                    {
                        total += (long) len * (len - reiterateLen);
                        loop = true;
                    }
                    else if(path.containsKey(j))
                    {
                        if(reiterateLen == 0)
                        {
                            int loopLen = len - path.get(j) - 1;

//                            System.out.println(beforeLoopLen + " " + loopLen);

//                            total += partialTriangleNum(len, loopLen);
                            total += (((long) len * (len + 1)) / 2) - (((long) loopLen * (loopLen + 1)) / 2);
                            total += (long) loopLen * loopLen;
                            loop = true;
                        }
                        else
                        {
//                            total += partialTriangleNum(len, reiterateLen);
                            System.out.println(triangleNum(len) + " " + triangleNum(++reiterateLen));
                            total += (((long) len * (len + 1)) / 2) - (((long) reiterateLen * (reiterateLen + 1)) / 2);
                            loop = true;
                        }
                    }
                    else if(visited.contains(j))
                    {
                        reiterateLen++;
                    }

                    k++;
                }

                if(outOfBounds)
                {
//                    total += triangleNum(path.size() + 1);
                    total += ((long) (len) * ((len) + 1)) / 2;
                }



            }

        }


        System.out.println(total);

        int testVal = OneDFroggerHard.test(n, values);
        if(testVal == total)
        {
            System.out.println("Works");
        }
        else
        {
            System.out.println(testVal);
        }
    }
}
