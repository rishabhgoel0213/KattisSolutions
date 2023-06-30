import java.util.*;

public class AliceInTheDigitalWorld
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        for(int i = 0; i < d; i++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer> nums = new ArrayList<>();
            List<Integer> sumPrev = new ArrayList<>();
            sumPrev.add(0);
            List<Integer> mIndexes = new ArrayList<>();
            mIndexes.add(-1);
            for(int j = 0; j < n; j++)
            {

                int x = in.nextInt();
                if(x >= m)
                {
                    nums.add(x);
                    sumPrev.add(sumPrev.get(j) + nums.get(j));
                    if(nums.get(j) == m)
                    {
                        mIndexes.add(j);
                    }

                }
                else
                {
                    j--;
                    n--;
                }
            }
            mIndexes.add(sumPrev.size() - 1);

//            System.out.println(sumPrev);
//            System.out.println(mIndexes);
            int max = m;
            for(int j = 1; j < mIndexes.size() - 1; j++)
            {
                int sum = sumPrev.get(mIndexes.get(j + 1)) - sumPrev.get(mIndexes.get(j - 1) + 1);
//                System.out.println(sum);
                if(sum > max)
                {
                    max = sum;
                }
            }
            System.out.println(max);

        }
    }
}
