import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A1Paper
{
    static final double heightRatio = Math.pow(2, -0.75);
    static final double widthRatio = Math.pow(2, -1.25);
    static final double areaA1 = heightRatio * widthRatio * 2;


//    public static double makePaper(double height, double width, List<Integer> numPapers)
//    {
//        if(numPapers.isEmpty())
//        {
//            return -1;
//        }
//        double len = 0;
//        for(int i = 0; i < 2; i++)
//        {
//            int papers = numPapers.get(0);
//            if(papers > 0)
//            {
//                len += height;
//                numPapers.set(0, papers - 1);
//            }
//            else
//            {
//                double prevPaper = makePaper(width, height/2, numPapers.subList(1, numPapers.size()));
//                if(prevPaper == -1)
//                {
//                    return -1;
//                }
//                len += height + prevPaper;
//            }
//        }
//        return len;
//    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] numPapers = Arrays.stream(new Integer[n - 1]).map(nP -> in.nextInt()).toArray(Integer[]::new);
        Integer[] usedPapers = new Integer[n - 1];

        double paperSizeLeft = 1;
        double height = heightRatio;
        double width = widthRatio;
        double tape = 0;
        for(int i = 0; i < n - 1; i++)
        {
            double factor = 1/Math.pow(2, i + 1);
            double needed = paperSizeLeft % factor;
            if(numPapers[i] >= needed)
            {
                tape += (needed / 2) * height;
                break;
            }
            else
            {

            }
            paperSizeLeft -= n;
        }
//        double area = 0;
//        double tape = makePaper(heightRatio, widthRatio, Arrays.asList(numPapers));
//
//        if(tape == -1)
//        {
//            System.out.println("impossible");
//        }
//        else
//        {
//            System.out.println(tape/2);
//        }
    }
}
