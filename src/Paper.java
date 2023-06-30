import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Paper
{
    static int[] numSheets;
    static final double heightRatio = Math.pow(2, -0.75);
    static final double widthRatio = Math.pow(2, -1.25);
    static final double areaA1 = heightRatio * widthRatio * 2;

    public static ArrayList<Integer> numPapers(int i, int prevNum)
    {
        int num = 0;
        if(numSheets[i] >= 2)
        {
            num += numSheets[i]/2;
            numSheets[i] -= num;
        }
        if(numSheets[i] == 1)
        {
            int smallerPaperNum = numPapers(i + 1, num).stream().mapToInt(Integer::intValue).sum();

        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args)
    {
        System.out.println(areaA1);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        numSheets = Arrays.stream(new int[n - 1]).map(p -> in.nextInt()).toArray();

        double tapeLen = 0;
        double height = heightRatio;
        double width = widthRatio;
        double area = 0;

        double prevPaperArea = areaA1;
        double currentPaperArea = 0;

        int i = 0;
        while(area < areaA1)
        {
            if(i == numSheets.length)
            {
                System.out.println(tapeLen + " impossible");
                return;
            }
            while(numSheets[i] > 0 && currentPaperArea < prevPaperArea)
            {
                System.out.println(height);
                tapeLen += height;
                currentPaperArea += height * width;
                numSheets[i] -= 1;
            }
            area += currentPaperArea;
            currentPaperArea = 0;
            prevPaperArea /= 2;
            double wHold = width;
            width = height / 2;
            height = wHold;
            i++;
        }

        System.out.println(tapeLen);

    }
}
