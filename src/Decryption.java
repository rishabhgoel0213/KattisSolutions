import java.util.Scanner;

public class Decryption
{
    public static int calcB(int[] digits, int[] exponents)
    {
        int sum = 0;
        for(int i = 0; i < digits.length; i++)
        {
            sum += Math.pow(digits[i], exponents[i]);
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        String strDigits = Integer.toString(a);
        int[] digits = new int[strDigits.length()];
        int[] exponents = new int[Integer.toString(a).length()];

        for(int i = 0; i < strDigits.length(); i++)
        {
            digits[i] = Integer.parseInt(strDigits.substring(i, i + 1));
            exponents[i] = 1;
        }

        int testB = calcB(digits, exponents);



    }
}
