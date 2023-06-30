import javafx.util.Pair;

import java.util.*;

public class Adventure2
{
    static int[] maxNumStones;
    static int totalPlaces;

    static Map<Integer, Integer> expectedValues;

    public static int calcNumStones(int[] distinct, int[] coeffs)
    {
        int sum = 0;
        for(int i = 0; i < distinct.length; i++)
        {
            sum += distinct[i] * coeffs[i];
        }
        return sum;
    }

    public static int calcExpectedValues(int[] distinct, int[] coeffs)
    {
        int sum = 0;
        for(int i = 0; i < distinct.length; i++)
        {
            sum += Math.pow(distinct[i], 2) * coeffs[i];
        }
        return sum;
    }
    public static void adjustProbabilites(int u, int v)
    {
        totalPlaces++;
        for(int i = u; i < v; i++)
        {
            maxNumStones[i]++;
        }
        int[] distinct = Arrays.stream(maxNumStones).distinct().toArray();
        Arrays.sort(distinct);
        int[] numDistinct = new int[distinct.length];
        for(int i = 0; i < distinct.length; i++)
        {
            int val = distinct[i];
            numDistinct[i] = (int)Arrays.stream(maxNumStones).filter(n -> n >= val).count();
        }
        int[] coeffs = new int[distinct.length];
        System.out.println(distinct.length);
        int i = 0;
        while(i < coeffs.length)
        {
            System.out.println(distinct[i] + " " + coeffs[i] + " " + numDistinct[i] + " " + totalPlaces);
            if(coeffs[i] < numDistinct[i] && distinct[i] != 0)
            {
                coeffs[i]++;
            }
            else
            {
                i++;
            }

            System.out.println("Progress: " + calcNumStones(distinct, coeffs));
            if(calcNumStones(distinct, coeffs) == totalPlaces)
            {
                int expectedValue = calcExpectedValues(distinct, coeffs);
                System.out.println(expectedValue);
                if(expectedValues.containsKey(expectedValue))
                {
                    expectedValues.replace(expectedValue, expectedValues.get(expectedValue) + 1);
                }
                else
                {
                    expectedValues.put(expectedValue, 1);
                }
                if(i != distinct.length - 1)
                    coeffs[i] -= distinct[i + 1];
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();
        int u;
        int v;

        maxNumStones = new int[n];
        Arrays.fill(maxNumStones, 0);

        totalPlaces = 0;

        expectedValues = new HashMap<>();

        for(int i = 0; i < q; i++)
        {
            int qType = in.nextInt();
            if(qType == 1)
            {
                u = in.nextInt() - 1;
                v = in.nextInt();
                adjustProbabilites(u, v);
                System.out.println(expectedValues);
            }
            else
            {

            }
        }
    }
}
