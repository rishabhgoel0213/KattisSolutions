import java.util.Scanner;

public class PebbleSolitare
{
    public static void main(String[] args)
    {
        //Sample Input 1
        //5
        //---oo----------oo------
        //-o--o-oo-----o--o-oo---
        //-o----ooo----o----ooo--
        //ooooooooooooooooooooooo
        //oooooooooo-ooooooooooo-

        //Sample Output 1
        //2
        //4
        //6
        //23
        //4
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
        {
            //determine minimum number of pebbles left on the board after the game
            //A move consists of moving the pebble from  to , and removing the pebble in  from the board. You may continue to make moves until no more moves are possible.
            String s = in.next();
            int count = 0;
            for (int j = 0; j < s.length(); j++)
            {
                if (s.charAt(j) == 'o')
                {
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
