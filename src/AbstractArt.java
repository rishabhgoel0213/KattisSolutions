

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Scanner;

public class AbstractArt
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Polygon> intersections = new ArrayList<>();
        int paintUsed = 0;
        for(int i = 0; i < n - 1; i++)
        {
            int s = in.nextInt();
            int[] xValues = new int[s];
            int[] yValues = new int[s];
            for(int j = 0; j < s; j++)
            {
                xValues[j] = in.nextInt();
                yValues[j] = in.nextInt();
            }
            for(int j = 0; j < n; j++)
            {

            }
        }
    }
}
