import java.util.*;
import java.util.stream.Collectors;

public class PathFinder2
{
    static int[][] map;
    static Set<List<Integer>> visitedPoints;

    static ArrayList<Set<List<Integer>>> blocks;
    static List<Integer> end;

    static boolean found = false;

    static public void printResult(List<Integer> point)
    {
        if(map[point.get(0)][point.get(1)] == 1)
        {
            System.out.println("decimal");
        }
        else
        {
            System.out.println("binary");
        }
    }
    static public void pathExists(List<Integer> start)
    {
        visitedPoints.add(start);

        if(found)
        {
            return;
        }

        if(start.equals(end))
        {
            found = true;
            printResult(start);
        }
        else
        {
            int r = start.get(0);
            int c = start.get(1);
            if(r + 1 < map.length)
            {
                if(map[r + 1][c] == map[r][c] && !visitedPoints.contains(Arrays.asList(r + 1, c)))
                {
                    pathExists(Arrays.asList(r + 1, c));
                }
            }
            if(r - 1 >= 0)
            {
                if(map[r - 1][c] == map[r][c] && !visitedPoints.contains(Arrays.asList(r - 1, c)))
                {
                    pathExists(Arrays.asList(r - 1, c));
                }
            }
            if(c + 1 < map[0].length)
            {
                if(map[r][c + 1] == map[r][c] && !visitedPoints.contains(Arrays.asList(r, c + 1)))
                {
                    pathExists(Arrays.asList(r, c + 1));
                }
            }
            if(c - 1 >= 0)
            {
                if(map[r][c - 1] == map[r][c] && !visitedPoints.contains(Arrays.asList(r, c - 1)))
                {
                    pathExists(Arrays.asList(r, c - 1));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        map = new int[r][c];
        blocks = new ArrayList<>();
        visitedPoints = new HashSet<>();

        for(int i = 0; i < r; i++)
        {
            map[i] = Arrays.stream((in.next() + in.nextLine()).split("")).mapToInt(Integer::parseInt).toArray();
        }

        int n = in.nextInt();
        int[][] tests = new int[n][4];
        for(int i = 0; i < n; i++)
        {
            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt() - 1;
            int y2 = in.nextInt() - 1;

            end = Arrays.asList(x2, y2);
            found = false;
//            Set<List<Integer>> visitedPointsCopy = new HashSet<>();
//            for(List<Integer> point : visitedPoints)
//            {
//                visitedPointsCopy.add(new ArrayList<>(point));
//            }
            blocks.add(visitedPoints);
            visitedPoints = new HashSet<>();

            if(i > 4)
            {

                for (int j = 0; j < blocks.size(); j++)
                {
                    if (blocks.get(j).contains(Arrays.asList(x1, y1)) && blocks.get(j).contains(Arrays.asList(x2, y2)))
                    {
                        System.out.println("skip");
                        found = true;
                        printResult(end);
                    }
                }
            }

            if(!found)
            {
                pathExists(Arrays.asList(x1, y1));
            }

            if(!found)
            {
                System.out.println("neither");
            }
        }


    }
}

