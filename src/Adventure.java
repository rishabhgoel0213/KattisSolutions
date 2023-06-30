import java.util.*;

public class Adventure
{
    static ArrayList<ArrayList<Integer>> possibleBoards = new ArrayList<>();
    static HashMap<Long, Long> unique = new HashMap<>();

    public static long calcModExp(long a, long b)
    {
        long bInv = 1;
        long mod = (long)(1e9) + 7;
        long exp = mod - 2;
        while(exp > 0)
        {
            if(exp % 2 == 1)
            {
                bInv = (bInv * b) % mod;
            }
            exp = Math.floorDiv(exp, 2);
            b = (b * b) % mod;
        }
        return (a * bInv) % mod;
    }

    public static int findGCD(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        else
        {
            return findGCD(b, a % b);
        }
    }
    public static long calcExpected()
    {
        int a = 0;
        int b = possibleBoards.size();

        for(Long val: unique.keySet())
        {
            a += val * unique.get(val);
        }

        int gcd = findGCD(a, b);
        return calcModExp(a / gcd, b / gcd);
    }

    public static void computeCombinations(ArrayList<Integer> u, ArrayList<Integer> v, ArrayList<Integer> board)
    {
        int size = v.size();
        for(int k = 0; k < size; k++)
        {
            ArrayList<ArrayList<Integer>> newPossibleBoards = new ArrayList<>();
            int uVal = u.get(k);
            int vVal = v.get(k);
            unique = new HashMap<>();
            for (int i = uVal - 1; i < vVal; i++)
            {
                int numPossibleBoards = possibleBoards.size();
                for(int j = 0; j < numPossibleBoards; j++)
                {
                    ArrayList<Integer> newBoard = (ArrayList<Integer>) possibleBoards.get(j).clone();
                    newBoard.set(i, newBoard.get(i) + 1);
                    long sum = newBoard.stream().map(n -> (int)Math.pow(n, 2)).mapToLong(Long::new).sum();

                    if(unique.containsKey(sum))
                    {
                        unique.replace(sum, unique.get(sum) + 1);
                    }
                    else
                    {
                        unique.put(sum, 1L);
                    }

                    newPossibleBoards.add(newBoard);
                }
            }
            possibleBoards = (ArrayList<ArrayList<Integer>>) newPossibleBoards.clone();
            System.out.println(possibleBoards);
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        ArrayList<Integer> u = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<Integer>(Collections.nCopies(n, 0));
        possibleBoards.add(board);
        for(int i = 0; i < q; i++)
        {
            int qType = in.nextInt();
            if(qType == 1)
            {
                u.add(in.nextInt());
                v.add(in.nextInt());
            }
            else
            {
                computeCombinations(u, v, board);
                System.out.println(calcExpected());
                u.clear();
                v.clear();
            }
        }
    }
}
