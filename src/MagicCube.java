import java.util.*;

public class MagicCube
{
    static int min = 1000;
    public static int getCost(Character col)
    {
        switch(col)
        {
            case 'W':
                return 1;
            case 'Y':
                return 2;
            case 'O':
                return 3;
            case 'B':
                return 4;
            case 'G':
                return 5;
            case 'R':
                return 6;
        }
        return -1;
    }

    public static int[] getStartingPos(int i, int size)
    {
        switch(i)
        {
            case 0:
                return new int[]{1, size + 1};
            case 1:
                return new int[]{size + 1, 1};
            case 2:
                return new int[]{size + 1, size + 1};
            case 3:
                return new int[]{size + 1, size * 2 + 1};
            case 4:
                return new int[]{size + 1, size * 3 + 1};
            case 5:
                return new int[]{size * 2 + 1, size + 1};
        }
        return new int[2];
    }

    public static int lowestCost(List<Integer> current, List<Integer> end, Map<List<Integer>, Character> cube, int cost, Set<List<Integer>> visited)
    {
        visited.add(current);
        System.out.println((current.get(0)) + " " + (current.get(1)));
        if(cost > min)
        {
            return 1000;
        }
        if(current.equals(end))
        {
            System.out.println("Path: " + visited);
            System.out.println("Cost: " + cost);
            if(cost < min)
            {
                min = cost;
            }
            return cost;
        }
        else
        {
            int min = 1000;

            List<Integer> upPoint = Arrays.asList(current.get(0) - 1, current.get(1));
            List<Integer> leftPoint = Arrays.asList(current.get(0), current.get(1) - 1);
            List<Integer> downPoint = Arrays.asList(current.get(0) + 1, current.get(1));
            List<Integer> rightPoint = Arrays.asList(current.get(0), current.get(1) + 1);

            char up = cube.getOrDefault(upPoint, ' ');
            char left = cube.getOrDefault(leftPoint, ' ');
            char down = cube.getOrDefault(downPoint, ' ');
            char right = cube.getOrDefault(rightPoint, ' ');

            if (up != ' ' && !visited.contains(upPoint))
            {
                int cTest = lowestCost(upPoint, end, cube, cost + getCost(up), visited);
                min = Math.min(min, cTest);
//                visited.remove(upPoint);
                System.out.println();
            }

            if (left != ' ')
            {
                int cTest = lowestCost(leftPoint, end, cube, cost + getCost(left), visited);
                min = Math.min(min, cTest);
//                visited.remove(Arrays.asList(current.get(0), current.get(1) - 1));
                System.out.println();
            }


            if (down != ' ')
            {
                int cTest = lowestCost(downPoint, end, cube, cost + getCost(down), visited);
                min = Math.min(min, cTest);
//                visited.remove(Arrays.asList(current.get(0) + 1, current.get(1)));
                System.out.println();
            }

            if (right != ' ')
            {
                int cTest = lowestCost(rightPoint, end, cube, cost + getCost(right), visited);
                min = Math.min(min, cTest);
//                visited.remove(Arrays.asList(current.get(0), current.get(1) + 1));
                System.out.println();
            }


            System.out.println(visited);
            return min;
        }

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        Map<List<Integer>, Character> cube = new HashMap<>();
        for(int i = 0; i < 6; i++)
        {
            String side = in.nextLine();

            int[] sP = getStartingPos(i, size);

            int counter = 0;
            for(int j = sP[0]; j < size + sP[0]; j++)
            {
                for(int k = sP[1]; k < size + sP[1]; k++)
                {
                    cube.put(Arrays.asList(j, k), side.charAt(counter));
                    counter++;
                }
            }
        }

        Integer[] start = Arrays.stream(in.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] end =  Arrays.stream(in.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        int[] sP = getStartingPos(start[0] - 1, size);
        int[] eP = getStartingPos(end[0] - 1, size);

        int counter = 1;
        for(int j = sP[0]; j < size + sP[0]; j++)
        {
            for(int k = sP[1]; k < size + sP[1]; k++)
            {
                if(counter == start[1])
                {
                    start = new Integer[]{j, k};
                    break;
                }
                counter++;
            }
        }

        counter = 1;
        for(int j = eP[0]; j < size + eP[0]; j++)
        {
            for(int k = eP[1]; k < size + eP[1]; k++)
            {
                if(counter == end[1])
                {
                    end = new Integer[]{j, k};
                    break;
                }
                counter++;
            }
        }

        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));
        System.out.println(cube);

        System.out.println(lowestCost(Arrays.asList(start), Arrays.asList(end), cube, 0, new HashSet<>()));

    }
}
