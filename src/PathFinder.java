import java.util.*;

public class PathFinder
{
    static int[][] map;
    static List<Integer> end;

    static ArrayList<Set<Integer>> blocks = new ArrayList<>();

    static int zeroOrOne;

    static boolean found = false;

    static public void printResult()
    {
        if(zeroOrOne == 1)
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
        if(start.equals(end))
        {
            found = true;
            printResult();
        }
        else
        {
            int r = start.get(0);
            int c = start.get(1);

            map[r][c] = 2;

//            System.out.println("r = " + (r + 1) + " " + rDirection + ", c = " + (c + 1) + " " + cDirection);

            if(r + 1 < map.length)
            {
                if(map[r + 1][c] == zeroOrOne)
                {
//                    System.out.println(" row forward");
                    blocks.get(blocks.size() - 1).add(10000 * (r + 1) + c);
                    pathExists(Arrays.asList(r + 1, c));
                }
            }
            if(c + 1 < map[0].length)
            {
                if(map[r][c + 1] == zeroOrOne)
                {
//                    System.out.println(" col forward");
                    blocks.get(blocks.size() - 1).add(10000 * r + c + 1);
                    pathExists(Arrays.asList(r, c + 1));
                }
            }
            if(0 <= r - 1)
            {
                if(map[r - 1][c] == zeroOrOne)
                {
//                    System.out.println(" row backward");
                    blocks.get(blocks.size() - 1).add(10000 * (r - 1) + c);
                    pathExists(Arrays.asList(r - 1, c));
                }
            }
            if(0 <= c - 1)
            {
                if(map[r][c - 1] == zeroOrOne)
                {
                    blocks.get(blocks.size() - 1).add(10000 * r + c - 1);
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
        int[][] mapHold = new int[r][c];

        for(int i = 0; i < r; i++)
        {
            mapHold[i] = Arrays.stream((in.next() + in.nextLine()).split("")).mapToInt(Integer::parseInt).toArray();
        }
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt() - 1;
            int y2 = in.nextInt() - 1;

            List<Integer> start = Arrays.asList(x1, y1);
            end = Arrays.asList(x2, y2);
            found = false;
            map = Arrays.stream(mapHold)
                    .map(int[]::clone)
                    .toArray(int[][]::new);
            zeroOrOne = map[x1][y1];

            if(zeroOrOne == map[x2][y2])
            {
//                for(int j = 0; j < blocks.size(); j++)
//                {
//                    if(blocks.get(j).contains(10000 * x1 + y1) && blocks.get(j).contains(10000 * x2 + y2))
//                    {
//                        printResult();
//                        found = true;
//                    }
//                }
//                if(!found)
//                {
                    blocks.add(new HashSet<>());
                    blocks.get(blocks.size() - 1).add(10000 * x1 + y1);
                    pathExists(start);
//                }
            }

            if(!found)
            {
                System.out.println("neither");
            }
        }


    }
}
