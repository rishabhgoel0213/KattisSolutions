import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ads
{
    public static char[][] toWhitespace(char[][] board, List<Integer> startLoc, List<Integer> endLoc)
    {
        for(int i = startLoc.get(0) - 1; i <= endLoc.get(0); i++)
        {
            for (int j = startLoc.get(1) - 1; j <= endLoc.get(1); j++)
            {
                board[i][j] = ' ';
            }
        }
        return board;
    }
    public static char[][] removeAds(char[][] board, List<Integer> startLoc, List<Integer> endLoc, boolean imgFound)
    {
        for(int i = startLoc.get(0); i < endLoc.get(0); i++)
        {
            for(int j = startLoc.get(1); j < endLoc.get(1); j++)
            {
                if(board[i][j] == '+')
                {
                    int iB = i;
                    int jB = j;
                    List<Integer> start = Arrays.asList(i + 1, j + 1);

                    while(i + 1 < endLoc.get(0) && board[i + 1][j] == '+')
                    {
                        i++;
                    }
                    while(j + 1 < endLoc.get(1) && board[i][j + 1] == '+')
                    {
                        j++;
                    }

                    List<Integer> end = Arrays.asList(i, j);
                    removeAds(board, start, end, true);

                    i = iB;
                    j = jB;
                }
                else if(imgFound && !Character.isAlphabetic(board[i][j]) && !Character.isDigit(board[i][j]) && board[i][j] != '?' && board[i][j] != '!' && board[i][j] != ',' && board[i][j] != '.' && board[i][j] != ' ')
                {
                    board = toWhitespace(board, startLoc, endLoc);
                }
            }
        }
        return board;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int dims[] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] board = new char[dims[0]][dims[1]];
        for(int i = 0; i < dims[0]; i++)
        {
            board[i] = in.nextLine().toCharArray();
        }

        board = removeAds(board, Arrays.asList(0, 0), Arrays.asList(dims[0], dims[1]), false);

        for(int i = 0; i < dims[0]; i++)
        {
            for(int j = 0; j < dims[1]; j++)
            {
                System.out.print(board[i][j]);
            }
            if(i != dims[0] - 1)
                System.out.println();
        }

    }
}
