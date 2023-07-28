import java.util.Scanner;

public class UnreadMessages
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long unreadCount = 0;
        long[] history = new long[m];
        for(int i = 0; i < m; i++)
        {
            history[i] = in.nextInt();
            unreadCount += (n - 1);
            int j = i;
            while(j > 0 && history[j - 1] != history[i])
            {
                unreadCount--;
                j--;
            }
            System.out.println(unreadCount);
        }
    }

}
