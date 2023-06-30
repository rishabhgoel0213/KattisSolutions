import java.util.*;

public class NinetyNineProblems
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if(n <= 99)
        {
            System.out.println(99);
            return;
        }
        else if(n >= 9949)
        {
            System.out.println(9999);
            return;
        }
        else if(n >= 9899)
        {
            System.out.println(9899);
            return;
        }
        List<Integer> options = new ArrayList<>();
        for(int i = 99; i <= 10000; i += 100)
        {
            options.add(i);
        }

        boolean found = false;
        int mid = 0;
        int lower = 0;
        int upper = options.size() - 1;
        while(!found)
        {
            mid = (upper  + lower) / 2;

            if(options.get(mid) >= n && options.get(mid - 1) <= n)
            {
                found = true;
            }
            else if(options.get(mid) > n)
            {
                upper = mid;
            }
            else if(options.get(mid) < n)
            {
                lower = mid;
            }
        }

        if(options.get(mid) - n > 50)
        {
            System.out.println(options.get(mid - 1));
        }
        else
        {
            System.out.println(options.get(mid));
        }
    }
}
