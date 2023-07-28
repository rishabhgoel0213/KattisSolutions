public class SticksTestCaseGenerator
{
    public static void main(String[] args)
    {
        int n = 10000;
        int m = 4999;
        System.out.println(n + " " + m);
        for(int i = 1; i < m; i++)
        {
            System.out.println(i + " " + (i + 1));
        }
        System.out.println("5000 1");
    }
}
