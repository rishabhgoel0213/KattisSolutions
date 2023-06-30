import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddWords
{
    static Map<String, Integer> definitions = new HashMap<>();
    static Map<Integer, String> answers = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            String line = in.nextLine();
            String[] lineSplit = line.split(" ");
            if(lineSplit[0].equals("def"))
            {
                answers.remove(definitions.remove(lineSplit[1]));

                definitions.put(lineSplit[1], Integer.parseInt(lineSplit[2]));
                answers.put(Integer.parseInt(lineSplit[2]), lineSplit[1]);

                System.out.println(answers);
            }
            else if(lineSplit[0].equals("calc"))
            {
                line = line.substring(5);

                int val = 0;
                for(int i = 0; i < lineSplit.length - 1; i += 2)
                {
                    if(definitions.containsKey(lineSplit[i + 1]))
                    {
                        if (lineSplit[i].equals("-"))
                        {
                            val -= definitions.get(lineSplit[i + 1]);
                        }
                        else
                        {
                            val += definitions.get(lineSplit[i + 1]);
                        }
                    }
                    else
                    {
                        val = Integer.MAX_VALUE;
                        break;
                    }
                }
                String answer = answers.getOrDefault(val, "unknown");
                System.out.println(line + " " + answer);
            }
            else if(lineSplit[0].equals("clear"))
            {
                definitions.clear();
                answers.clear();
            }
        }
    }

}
