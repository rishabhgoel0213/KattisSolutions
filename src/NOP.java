import java.util.Scanner;

public class NOP
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String instructions = in.nextLine();
        int letterPos = 0;
        int numNOP = 0;
        for(int i = 0; i < instructions.length(); i++)
        {
            if(Character.isUpperCase(instructions.charAt(i)))
            {
                while(letterPos % 4 != 0)
                {
                    letterPos++;
                    numNOP++;
                }
            }
            letterPos++;
        }
        System.out.print(numNOP);
    }
}
