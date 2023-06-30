import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sequences
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        long numQs = s.chars().filter(c -> c == '?').count();
        int sum = 0;
        for(int i = 0; i < Math.pow(2, numQs); i++)
        {
            StringBuilder sequence = new StringBuilder(Integer.toBinaryString(i));
            while(sequence.length() != numQs && numQs > 0)
            {
                sequence.insert(0, "0");
            }
            String input = s;
            int j = 0;
            while(input.contains("?"))
            {
                input = input.replaceFirst("\\?", Character.toString(sequence.charAt(j)));
                j++;
            }
            sequence = new StringBuilder(input);

            System.out.println(sequence);

            long numOnes = sequence.chars().filter(c -> c == '1').count();
            int firstOne = sequence.toString().indexOf('1');


            for(int k = 0; k < numOnes; k++)
            {
                if(firstOne == sequence.length() - 1 || firstOne == -1)
                {
                    break;
                }
                sum += sequence.substring(firstOne).chars().filter(c -> c == '0').count();
                firstOne = sequence.toString().indexOf('1', firstOne + 1);
            }
        }
        System.out.println(sum);
    }
}
