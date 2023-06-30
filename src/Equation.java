import java.util.*;

public class Equation
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Map<Integer, String> solutions = new HashMap<>();
        solutions.put(16, "4 + 4 + 4 + 4");
        solutions.put(8, "4 - 4 + 4 + 4");
        solutions.put(0, "4 - 4 - 4 + 4");
        solutions.put(-8, "4 - 4 - 4 - 4");
        solutions.put(24, "4 * 4 + 4 + 4");
        solutions.put(68, "4 * 4 * 4 + 4");
        solutions.put(256, "4 * 4 * 4 * 4");
        solutions.put(60, "4 * 4 * 4 - 4");
        solutions.put(1, "4 / 4 * 4 / 4");
        solutions.put(-4, "4 / 4 / 4 - 4");
        solutions.put(-1, "4 - 4 / 4 - 4");
        solutions.put(9, "4 + 4 / 4 + 4");
        solutions.put(2, "4 / 4 + 4 / 4");
        solutions.put(4, "4 / 4 / 4 + 4");
        solutions.put(7, "4 + 4 - 4 / 4");
        solutions.put(-7, "4 / 4 - 4 - 4");
        solutions.put(17, "4 / 4 + 4 * 4");
        solutions.put(15, "4 * 4 - 4 / 4");
        solutions.put(32, "4 * 4 + 4 * 4");

        int n = in.nextInt();
        int[] cases = Arrays.stream(new int[n]).map(c -> in.nextInt()).toArray();
        for(int i = 0; i < n; i++)
        {
            if(solutions.containsKey(cases[i]))
            {
                System.out.println(solutions.get(cases[i]) + " = " + cases[i]);
            }
            else
            {
                System.out.println("no solution");
            }
        }


    }
}
