public class PathFinderTestCase
{
    public static void main(String[] args)
    {
        for(int i = 0; i < 1000; i++)
        {
            for(int j = 0; j < 1000; j++)
            {
                if((j == 998 && i == 998) || (j == 998 && i == 999) || (j == 999 && i == 998))
                {
                    System.out.print(0);
                }
                else
                {
                    System.out.print(1);
                }
            }
            System.out.println();
        }
    }
}
