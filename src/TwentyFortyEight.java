import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TwentyFortyEight
{
    public static ArrayList transpose(ArrayList<ArrayList<Integer>> board)
    {
        ArrayList<ArrayList<Integer>> transposed = new ArrayList<>();
        for(int i = 0; i < board.get(0).size(); i++)
        {
            transposed.add(new ArrayList<>());
            for(int j = 0; j < board.size(); j++)
            {
                transposed.get(i).add(board.get(j).get(i));
            }
        }
        return transposed;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for(int i = 0; i < 4; i++)
        {
            String[] s = in.nextLine().split(" ");
            board.add(new ArrayList<>(Arrays.stream(s).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList())));
        }
        int direction = in.nextInt();

        switch(direction)
        {
            case 1:
                board = transpose(board);
                break;
            case 2:
                board.forEach(Collections::reverse);
                break;
            case 3:
                board = transpose(board);
                board.forEach(Collections::reverse);
                break;
            default:
                break;
        }

        for(int i = 0; i < board.size(); i++)
        {
            for(int j = 0; j < board.get(i).size() - 1; j++)
            {
                if(board.get(i).get(j) == 0 && board.get(i).subList(j, board.get(i).size()).stream().filter(n -> n == 0).count() != board.get(i).subList(j, board.get(i).size()).size())
                {
                    int hold = board.get(i).remove(j);
                    board.get(i).add(hold);
                    j--;
                }
                if(j == -1)
                    continue;
                if(board.get(i).get(j).equals(board.get(i).get(j + 1)))
                {
                    board.get(i).set(j, board.get(i).get(j) * 20);
                    board.get(i).set(j + 1, 0);
                }
            }
        }

        switch(direction)
        {
            case 1:
                board = transpose(board);
                break;
            case 2:
                board.forEach(Collections::reverse);
                break;
            case 3:
                board.forEach(Collections::reverse);
                board = transpose(board);
                break;
            default:
                break;
        }

        board = board.stream().map(r -> r.stream().map(n -> n % 10 == 0 ? n / 10 : n).collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        for(int i = 0; i < board.size(); i++)
        {
            for(int j = 0; j < board.size(); j++)
            {
                if(j == board.size() - 1)
                    System.out.print(board.get(i).get(j));
                else
                    System.out.print(board.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
