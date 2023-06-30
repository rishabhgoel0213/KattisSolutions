import javafx.util.Pair;
import sun.awt.X11.XSystemTrayPeer;

import java.lang.reflect.Array;
import java.util.*;

public class DronePath
{
    public static int[] start1;
    public static int[] start2;
    public static int[] end1;
    public static int[] end2;
    public static int collision(int[] move1, int[] move2)
    {
        int[] current1 = {start1[0] + move1[0], start1[1] + move1[1]};
        int[] current2 = {start2[0] + move2[0], start2[1] + move2[1]};

        if(current1[0] == current2[0] && current1[1] == current2[1])
        {
            return -1;
        }

        int[] endDist1 = {end1[0] - current1[0], end1[1] - current1[1]};
        int[] endDist2 = {end2[0] - current2[0], end2[1] - current2[1]};
        ArrayList<Integer> possiblePaths = new ArrayList<>();

        if(endDist1[0] != 0)
        {
            if(endDist2[0] != 0)
            {
                int[] poss1 = Arrays.copyOf(move1, 2);
                poss1[0] += Math.signum(endDist1[0]);

                int[] poss2 = Arrays.copyOf(move2, 2);
                poss2[0] += Math.signum(endDist2[0]);

                possiblePaths.add(collision(poss1, poss2));
            }
            if(endDist2[1] != 0)
            {
                int[] poss1 = Arrays.copyOf(move1, 2);
                poss1[0] += Math.signum(endDist1[0]);

                int[] poss2 = Arrays.copyOf(move2, 2);
                poss2[1] += Math.signum(endDist2[1]);

                possiblePaths.add(collision(poss1, poss2));
            }
        }
        if(endDist1[1] != 0)
        {
            if(endDist2[0] != 0)
            {
                int[] poss1 = Arrays.copyOf(move1, 2);
                poss1[1] += Math.signum(endDist1[1]);

                int[] poss2 = Arrays.copyOf(move2, 2);
                poss2[0] += Math.signum(endDist2[0]);

                possiblePaths.add(collision(poss1, poss2));
            }
            if(endDist2[1] != 0)
            {
                int[] poss1 = Arrays.copyOf(move1, 2);
                poss1[1] += Math.signum(endDist1[1]);

                int[] poss2 = Arrays.copyOf(move2, 2);
                poss2[1] += Math.signum(endDist2[1]);

                possiblePaths.add(collision(poss1, poss2));
            }
        }

        long failNum = possiblePaths.stream().filter(n -> n == -1).count();
        long okayNum = possiblePaths.stream().filter(n -> n == 0).count();
        long passNum = possiblePaths.stream().filter(n -> n == 1).count();
        if(possiblePaths.isEmpty() || passNum == possiblePaths.size())
        {
            return 1;
        }
        else if(failNum == possiblePaths.size())
        {
            return -1;
        }
        else if(failNum + okayNum > 0)
        {
            return 0;
        }
        else
        {
            return 0;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] dims;
        String[] drone1;
        String[] drone2;
        for(int i = 0; i < n; i++)
        {
            dims = in.nextLine().split(" ");
            drone1 = in.nextLine().split(" ");
            drone2 = in.nextLine().split(" ");

            start1 = new int[2];
            for(int j = 0; j < 2; j++)
            {
                start1[j] = Integer.parseInt(drone1[j]);
            }
            end1 = new int[2];
            for(int j = 0; j < 2; j++)
            {
                end1[j] = Integer.parseInt(drone1[j + 2]);
            }
            start2 = new int[2];
            for(int j = 0; j < 2; j++)
            {
                start2[j] = Integer.parseInt(drone2[j]);
            }
            end2 = new int[2];
            for(int j = 0; j < 2; j++)
            {
                end2[j] = Integer.parseInt(drone2[j + 2]);
            }

            ArrayList<Set<Integer>> x1 = new ArrayList<>();
            ArrayList<Set<Integer>> y1 = new ArrayList<>();
            for(int j = 0; j < Math.abs(start1[0] - end1[0]) + Math.abs(start1[1] - end1[1]); j++)
            {
                x1.add(new HashSet<Integer>());
                y1.add(new HashSet<Integer>());
            }

            for(int j = 0; j < Math.abs(start1[0] - end1[0]); j++)
            {
                int x = j * (int) Math.signum(end1[0] - start1[0]) + start1[0];
                x1.get(j).add(x);
                for(int k = 0; k < Math.abs(start1[1] - end1[1]); k++)
                {
                    int y = k * (int) Math.signum(end1[1] - start1[1]) + start1[1];
                    y1.get(j + k).add(y);
                }
            }

            ArrayList<Set<Integer>> x2 = new ArrayList<>();
            ArrayList<Set<Integer>> y2 = new ArrayList<>();
            for(int j = 0; j < Math.abs(start2[0] - end2[0]) + Math.abs(start2[1] - end2[1]); j++)
            {
                x2.add(new HashSet<Integer>());
                y2.add(new HashSet<Integer>());

            }

            for(int j = 0; j < Math.abs(start2[0] - end2[0]); j++)
            {
                System.out.println("hi");
                int x = j * (int) Math.signum(end2[0] - start2[0]) + start2[0];
                x2.get(j).add(x);
                for(int k = 0; k < Math.abs(start2[1] - end2[1]); k++)
                {
                    int y = k * (int) Math.signum(end2[1] - start2[1]) + start2[1];
                    y2.get(j + k).add(y);

                }
            }

            for(int j = 0; j < x1.size() && j < x2.size(); j++)
            {
                x1.get(j).retainAll(x2);
                y1.get(j).retainAll(y2);

                if(x1.equals(x2) && y1.equals(y2))
                {
                    System.out.println("IMMINENT DISASTER");
                    System.out.println(x1);
                    System.out.println(x2);
                    break;
                }
                else if(x1.stream().filter(s -> s.equals(new HashSet<>())).count() == x1.size())
                {
                    System.out.println("MAYHEM POSSIBLE");
                    System.out.println(x1);
                    System.out.println(x2);
                    break;
                }
                else
                {
                    System.out.println("CRISIS AVERTED");
                    break;
                }

            }



        }
    }
}
