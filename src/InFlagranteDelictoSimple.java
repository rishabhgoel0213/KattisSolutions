import java.util.Scanner;

public class InFlagranteDelictoSimple
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] prosEvents = new int[N];
        for(int i = 0; i < N; i++) prosEvents[i] = in.nextInt();
        int[] defsEvents = new int[N];
        int kR = 0;
        for(int i = 0; i < N; i++)
        {
            defsEvents[i] = in.nextInt();
            if(prosEvents[i] == defsEvents[i]);
        }

    }
}
