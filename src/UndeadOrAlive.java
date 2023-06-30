import java.util.Scanner;

public class UndeadOrAlive
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        boolean containsSmile = false;
        boolean containsFrown = false;
        for(int i = 0; i < line.length() - 1; i++)
        {
            if(line.charAt(i) == ':' && line.charAt(i + 1) == ')')
            {
                containsSmile = true;
            }
            else if(line.charAt(i) == ':' && line.charAt(i + 1) == '(')
            {
                containsFrown = true;
            }
        }

        if(containsSmile && containsFrown)
        {
            System.out.println("double agent");
        }
        else if(containsSmile)
        {
            System.out.println("alive");
        }
        else if(containsFrown)
        {
            System.out.println("undead");
        }
        else
        {
            System.out.println("machine");
        }
    }
}
