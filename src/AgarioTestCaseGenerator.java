public class AgarioTestCaseGenerator
{
    public static void main(String[] args)
    {
        int n = 100;
        int m = (n * n - n) / 2;
        System.out.println(n + " " + m);
        for(int i = 0; i < n; i++) System.out.print(((int) (Math.random() * 1000 + 1)) + " ");
        System.out.println();
        int x = 0;
        for(int i = 1; i <= n; i++)
            for(int j = i + 1; j <= n; j++) {
                System.out.println(i + " " + j);
                x++;
            }

        System.out.println(x);

    }

}
