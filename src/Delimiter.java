import java.util.ArrayList;
import java.util.Scanner;

public class Delimiter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Character> openBrackets = new ArrayList<>();
        int length = in.nextInt();
        String brackets = in.next() + in.nextLine();
        for(int i = 0; i < length; i++)
        {
            if(brackets.charAt(i) == ' ')
            {
                continue;
            }
            else if(brackets.charAt(i) == '{')
            {
                openBrackets.add(0, '}');
            }
            else if(brackets.charAt(i) == '[')
            {
                openBrackets.add(0, ']');
            }
            else if(brackets.charAt(i) == '(')
            {
                openBrackets.add(0, ')');
            }
            else if(brackets.charAt(i) == '}' || brackets.charAt(i) == ']' || brackets.charAt(i) == ')')
            {
                if(openBrackets.isEmpty())
                {
                    System.out.println(brackets.charAt(i) + " " + i);
                    return;
                }
                else if(openBrackets.get(0) == brackets.charAt(i))
                {
                    openBrackets.remove(0);
                }
                else
                {
                    System.out.println(brackets.charAt(i) + " " + i);
                    return;
                }
            }
        }
        System.out.println("ok so far");
    }
}
