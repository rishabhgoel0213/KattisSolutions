import java.util.Arrays;
import java.util.Scanner;

public class Cryptography
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String cipher = in.nextLine();
        String key = in.nextLine();

        if(key.isEmpty())
        {
            System.out.println(cipher);
            return;
        }

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int[] cipherInts = new int[cipher.length()];
        int[] keyInts = new int[cipher.length()];
        int[] messageInt = new int[cipher.length()];
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < cipher.length(); i++)
        {
            cipherInts[i] = alphabet.indexOf(cipher.charAt(i));
            if(i < 3)
            {
                keyInts[i] = alphabet.indexOf(key.charAt(i));
            }
            else
            {
                if(cipherInts[i - 3] - keyInts[i - 3] >= 0)
                {
                    keyInts[i] = cipherInts[i - 3] - keyInts[i - 3];
                }
                else
                {
                    keyInts[i] = cipherInts[i - 3] - keyInts[i - 3] + 26;

                }
            }
        }
//        message.append(alphabet.charAt(keyInts[i]));

        for(int i = 0; i < cipher.length(); i++)
        {
            if(cipherInts[i] - keyInts[i] >= 0)
            {
                messageInt[i] = cipherInts[i] - keyInts[i];
            }
            else
            {
                messageInt[i] = cipherInts[i] - keyInts[i] + 26;

            }
            if(i >= key.length())
            {
                keyInts[i] = messageInt[i - 3];
            }
            message.append(alphabet.charAt(messageInt[i]));
        }

        System.out.println(message);

    }
}
