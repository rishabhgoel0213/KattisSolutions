import java.util.Scanner;

public class QuickBrownFox
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++)
        {
            String word = in.nextLine();
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int j = 0; j < word.length(); j++)
            {
                char c = word.charAt(j);
                c = Character.toLowerCase(c);
                alphabet = alphabet.replace(c, ' ');
            }
            alphabet = alphabet.replace(" ", "");
            if (alphabet.length() == 0)
            {
                System.out.println("pangram");
            }
            else
            {
                System.out.println("missing " + alphabet);
            }
        }
    }
}
