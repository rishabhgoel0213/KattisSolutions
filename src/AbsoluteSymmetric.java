import java.util.Arrays;
import java.util.Scanner;

public class AbsoluteSymmetric
{
    static long[][][] matricies;
    static long[][] zeros;
    public static void printMatrix(long[][] matrix, long n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void makeSymmetric(long[][] matrix, int n, int iteration)
    {
        long[][] newMatrix = new long[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
//                long subValue1 = 0;
//                long subValue2 = 0;
                if(Math.abs(matrix[i][j]) != Math.abs(matrix[j][i]))
                {
                    long diff = matrix[i][j] - matrix[j][i];
//                long direction = (long) Math.signum(diff) * diff;
                    if (diff / 2.0 != (int) (diff / 2.0))
                    {
                        System.out.println(-1);
                        matricies = new long[0][n][n];
                        return;
                    }
                    else
                    {
                        matrix[i][j] -= diff / 2;
                        matrix[j][i] += diff / 2;
                        newMatrix[i][j] = diff / 2;
                        newMatrix[j][i] = -diff / 2;
//                    System.out.println(newMatrix[i][j] + " " + newMatrix[j][i]);
//                    subValue1 += diff;
//                    subValue2 -= diff;
                    }
                }
                else
                {
                    newMatrix[i][j] = 0;
                    newMatrix[j][i] = 0;
                }
//                long newDirection = direction;
//                while(Math.abs(matrix[i][j]) != Math.abs(matrix[j][i]))
//                {
//                    if(newDirection != direction)
//                    {
//                        System.out.println(-1);
//                        matricies = new long[0][n][n];
//                        return;
//                    }
//                    matrix[i][j] -= direction;
//                    subValue1 += direction;
//                    matrix[j][i] += direction;
//                    subValue2 -= direction;
//
//                    newDirection = (long) Math.signum(matrix[i][j] - matrix[j][i]);
//                }
//                newMatrix[i][j] = subValue1;
//                newMatrix[j][i] = subValue2;
            }
        }

        if(Arrays.deepEquals(matrix, zeros) && iteration != 0)
        {
            matricies = new long[iteration][n][n];
            return;
        }


        if(!Arrays.deepEquals(matrix, newMatrix) || Arrays.deepEquals(matrix, zeros))
        {
            makeSymmetric(newMatrix, n, iteration + 1);
        }

        matricies[iteration] = matrix;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        long[][] matrix = Arrays.stream(new long[n][n]).map(i -> Arrays.stream(in.nextLine().split(" ")).mapToLong(Long::parseLong).toArray()).toArray(long[][]::new);
        zeros = Arrays.stream(new long[n][n]).map(i -> Arrays.stream(new long[n]).map(j -> 0).toArray()).toArray(long[][]::new);

        makeSymmetric(matrix, n, 0);
        if(matricies.length != 0)
            System.out.println(matricies.length);

        if(matricies.length <= 50)
        {
            for (int i = 0; i < matricies.length; i++)
            {
                printMatrix(matricies[i], n);
            }
        }

    }
}
