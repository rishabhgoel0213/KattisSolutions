import java.util.ArrayList;
import java.util.Scanner;

public class Julmust
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String output = "";
        int numRounds = 1;
        int max = in.nextInt();
        ArrayList<Integer> notPossible = new ArrayList<Integer>();
        while(!output.equals("exact"))
        {
            int guess = 1;
            while(notPossible.contains(guess))
            {
                guess++;
            }
            System.out.println(guess*numRounds);
            System.out.flush();

            output = in.nextLine();
            if(output.equals("less"))
            {
                for(int i = (int)(guess/numRounds + 0.5); i <= max; i++)
                {
                    notPossible.add(i);
                }
            }
            else if(output.equals("more"))
            {
                for(int i = 1; i <= guess/numRounds; i++)
                {
                    notPossible.add(i);
                }
            }

            numRounds++;
        }
    }
}
