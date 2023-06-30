import java.util.ArrayList;
import java.util.Scanner;

public class Complexity
{
    static Integer[] answers = new Integer[100000];
    public static int breakup(int n)
    {
        if(answers[n - 1] != null)
        {
            return answers[n - 1];
        }
        if(n == 1)
        {
            answers[0] = 1;
            return 1;
        }
        else
        {
            ArrayList<Integer> splitPoss = new ArrayList<>();
            for(int i = 2; i <= Math.sqrt(n); i++)
            {
                if(n % i == 0)
                {
                    splitPoss.add(n / i);
                    splitPoss.add(i);
                }
            }

            for(int i = 10; n / i != 0; i *= 10)
            {
                if(n % i != 0 && String.valueOf(n % i).length() + 1 == String.valueOf(i).length())
                {
                    splitPoss.add(n / i);
                    splitPoss.add(n % i);
                }
            }

            for(int i = (int)Math.sqrt(n); i > 0; i--)
            {
                splitPoss.add(n - i);
                splitPoss.add(i);
            }

////            if(splitPoss.size() == 0)
////            {
//                splitPoss.add(1);
//                splitPoss.add(n - 1);
////            }

            int min = (int) 1e99;
//            int[] minSplit = new int[2];
            for(int i = 0; i < splitPoss.size(); i+=2)
            {
                int test = breakup(splitPoss.get(i)) + breakup(splitPoss.get(i + 1));
                if(test < min)
                {
                    min = test;
//                    minSplit[0] = splitPoss.get(i);
//                    minSplit[1] = splitPoss.get(i + 1);
                }

            }
//            System.out.println(minSplit[0] + " " + minSplit[1]);
            answers[n - 1] = min;
            return min;
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min = breakup(n);
//        for(int i = n/2; i > 0; i--)
//        {
//            int test = breakup(n - i) + breakup(i);
//            if(test < min)
//            {
//                min = test;
//            }
//        }
        System.out.print(min);
    }
}
