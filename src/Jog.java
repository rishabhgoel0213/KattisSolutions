import java.util.Scanner;

public class Jog
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] vals = in.nextLine().split(" ");
        int[] intVals = new int[vals.length];
        for(int i = 0; i < vals.length; i++)
        {
            intVals[i] = Integer.parseInt(vals[i]);
        }
        double distanceK = Math.sqrt(Math.pow(intVals[0] - intVals[2], 2) + Math.pow(intVals[1] - intVals[3], 2));
        double distanceO = Math.sqrt(Math.pow(intVals[4] - intVals[6], 2) + Math.pow(intVals[5] - intVals[7], 2));
        double max = distanceK;
        if(distanceO > distanceK)
        {
            max = distanceO;
        }
        System.out.print(max);
    }
}
