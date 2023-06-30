import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KMPImplementation
{

    public static int[] preprocess(String pattern)
    {
        int[] numSkip = new int[pattern.length()];
        char c = pattern.charAt(0);
        numSkip[0] = 0;
        int pos = 0;

        for(int i = 1; i < pattern.length();)
        {
            if(pattern.charAt(i) == c)
            {
                numSkip[i] = ++pos;
                i++;
            }
            else if(pos != 0)
            {
                pos = numSkip[pos - 1];
            }
            else
            {
                numSkip[i] = 0;
                i++;
            }
            c = pattern.charAt(pos);
        }

        return numSkip;
    }
    public static int[] KMP(String txt, String pattern)
    {
        ArrayList<Integer> indexes = new ArrayList<>();

        return indexes.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String txt = in.nextLine();
        String pattern = in.nextLine().substring(8);
        int[] indexes = KMP(txt, pattern);
        int[] numSkip = preprocess(pattern);

//        numSkip.stream
//


        System.out.println(Arrays.toString(numSkip));
    }
}
