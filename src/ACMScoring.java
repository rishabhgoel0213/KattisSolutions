import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Scanner;

public class ACMScoring
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Map<String, OptionalInt> penalities = new HashMap<>();
        Map<String, Integer> solvedProblems = new HashMap<>();
        String[] line = in.nextLine().split(" ");
        while(!line[0].equals("-1"))
        {
            if(line[2].equals("right"))
            {
                solvedProblems.put(line[1], Integer.parseInt(line[0]));
            }
            else if(line[2].equals("wrong"))
            {
                if(!penalities.containsKey(line[1])){penalities.put(line[1], OptionalInt.empty());}
                penalities.put(line[1], OptionalInt.of(penalities.get(line[1]).orElse(0) + 1));
            }
            line = in.nextLine().split(" ");
        }

        System.out.print(solvedProblems.size() + " ");
        int score = 0;
        for(String problem : solvedProblems.keySet())
        {
            score += solvedProblems.get(problem);
            score += 20 * penalities.getOrDefault(problem, OptionalInt.empty()).orElse(0);
        }
        System.out.println(score);
    }
}
