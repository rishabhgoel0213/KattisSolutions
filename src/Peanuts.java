import java.util.Scanner;

public class Peanuts
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int numBoxes = in.nextInt();
        while(numBoxes != 0)
        {
            String[][] boxes = new String[numBoxes][5];
            for (int i = 0; i < numBoxes; i++)
            {
                boxes[i] = (in.next() + in.nextLine()).split(" ");
            }
            int numPeanuts = in.nextInt();
            String[][] peanuts = new String[numPeanuts][3];
            for (int i = 0; i < numPeanuts; i++)
            {
                peanuts[i] = (in.next() + in.nextLine()).split(" ");
                boolean foundBox = false;
                for(int j = 0; j < numBoxes; j++)
                {
                    double[] rangeX = {Double.parseDouble(boxes[j][0]), Double.parseDouble(boxes[j][2])};
                    double[] rangeY = {Double.parseDouble(boxes[j][1]), Double.parseDouble(boxes[j][3])};
                    double peanutX = Double.parseDouble(peanuts[i][0]);
                    double peanutY = Double.parseDouble(peanuts[i][1]);

                    if(rangeX[0] <= peanutX && peanutX <= rangeX[1] && rangeY[0] <= peanutY && peanutY <= rangeY[1])
                    {
                        if(boxes[j][4].equals(peanuts[i][2]))
                        {
                            System.out.println(peanuts[i][2] + " correct");
                            foundBox = true;
                            break;
                        }
                        else
                        {
                            System.out.println(peanuts[i][2] + " " + boxes[j][4]);
                            foundBox = true;
                            break;
                        }
                    }
                }
                if(!foundBox)
                {
                    System.out.println(peanuts[i][2] + " floor");
                }
            }
            System.out.println();
            numBoxes = in.nextInt();

        }


    }
}
