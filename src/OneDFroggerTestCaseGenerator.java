public class OneDFroggerTestCaseGenerator
{
    public static void main(String[] args)
    {
        int n = (int)(Math.random() * 200000) + 1;
        System.out.println(n);
        for(int i = 0; i < n; i++)
        {
            System.out.print((int)(Math.random() * 2) - 1 + " ");
        }
    }
}
