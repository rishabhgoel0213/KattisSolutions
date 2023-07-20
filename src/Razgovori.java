import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Razgovori
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> detections = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            int waste = in.nextInt();
            detections.add(in.nextInt());
        }
        detections.sort(Integer::compareTo);
    }
}
