import java.util.Arrays;
import java.util.Scanner;

public class InternationalDates
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] date = Arrays.stream(in.nextLine().split("/")).mapToInt(Integer::parseInt).toArray();
        if(date[0] > 12)
        {
            System.out.println("EU");
        }
        else if(date[1] > 12)
        {
            System.out.println("US");
        }
        else
        {
            System.out.println("either");
        }
    }
}
