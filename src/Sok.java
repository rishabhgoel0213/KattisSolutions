import java.util.Arrays;
import java.util.Scanner;

public class Sok
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split("");
        for(int i = 0; i < s.length; i++)
        {
            s[i] = Integer.toBinaryString(Integer.parseInt(s[i]));
            while(s[i].length() != 4)
            {
                s[i] = "0" + s[i];
            }
        }

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(s[j].charAt(i) == '0')
                {
                    System.out.print(".");
                }
                else
                {
                    System.out.print("*");
                }

                if(j == 1)
                {
                    System.out.print("   ");
                }
                else if(j != 3)
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }

}
