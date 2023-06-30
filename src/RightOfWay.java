import java.util.Scanner;

public class RightOfWay
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] directions = in.nextLine().split(" ");
        boolean isRight = (directions[0].equals("South") && directions[2].equals("East")) || (directions[0].equals("North") && directions[2].equals("West")) || (directions[0].equals("East") && directions[2].equals("North")) || (directions[0].equals("West") && directions[2].equals("South"));
        boolean isOpposite = (directions[0].equals("South") && directions[2].equals("North")) || (directions[0].equals("West") && directions[2].equals("East")) || (directions[0].equals("East") && directions[2].equals("West")) || (directions[0].equals("North") && directions[2].equals("South"));
        boolean passStraight = (directions[0].equals("South") && directions[1].equals("North")) || (directions[0].equals("West") && directions[1].equals("East")) || (directions[0].equals("East") && directions[1].equals("West")) || (directions[0].equals("North") && directions[1].equals("South"));
        boolean turnLeft = (directions[0].equals("South") && directions[1].equals("West")) || (directions[0].equals("North") && directions[1].equals("East")) || (directions[0].equals("East") && directions[1].equals("South")) || (directions[0].equals("West") && directions[1].equals("North"));

        if((passStraight && isRight) || (turnLeft && (isOpposite || isRight)))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

    }
}
