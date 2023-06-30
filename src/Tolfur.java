import java.util.Arrays;
import java.util.Scanner;

public class Tolfur
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        long score = 0;
        for(int i = 1; i < nums.length; i++)
        {
            score += Math.pow(nums[i] - nums[i-1], 2);
        }
        System.out.println(score);
    }
}
