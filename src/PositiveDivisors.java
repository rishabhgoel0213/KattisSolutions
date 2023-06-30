import java.util.*;
import java.util.stream.Collectors;

public class PositiveDivisors
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        List<Long> divs = new ArrayList<>();

        if(n == 1)
        {
            System.out.println(1);
            return;
        }
        for(long i = 1; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
            {
                divs.add(i);
            }
        }


        for(int i = divs.size() - 1; i >= 0; i--)
        {
            if(n / divs.get(i) != divs.get(i))
                divs.add(n / divs.get(i));
        }

        for(Long i : divs)
        {
            System.out.println(i);
        }
    }
}
