import java.util.Scanner;

public class CombinationLock
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] positions = new int[4];
        while(true)
        {
            positions[0] = in.nextInt();
            positions[1] = in.nextInt();
            positions[2] = in.nextInt();
            positions[3] = in.nextInt();
            if(positions[0] == 0 && positions[1] == 0 && positions[2] == 0 && positions[3] == 0)
            {
                break;
            }
            int total = 1080;
            total += (positions[0] - positions[1] + 40) % 40 * 9;
            total += (positions[2] - positions[1] + 40) % 40 * 9;
            total += (positions[2] - positions[3] + 40) % 40 * 9;
            System.out.println(total);
        }
    }
}
