import java.util.*;

public class AlphabetAnimals
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String lastWord = in.nextLine();
        char lastLetter = lastWord.charAt(lastWord.length() - 1);
        Map<Character, Map<Character, List<String>>> startingEnding = new HashMap<>();
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0; i < n; i++)
        {
            String line = in.nextLine();
            startingEnding.putIfAbsent(line.charAt(0), new HashMap<>());
            startingEnding.get(line.charAt(0)).putIfAbsent(line.charAt(line.length() - 1), new ArrayList<>());
            startingEnding.get(line.charAt(0)).get(line.charAt(line.length() - 1)).add(line);
        }

        if(!startingEnding.containsKey(lastLetter))
        {
            System.out.println("?");
        }
        else
        {
            String last = "";
            for(Character option : startingEnding.get(lastLetter).keySet())
            {
                last = startingEnding.get(lastLetter).get(option).get(0);
                if(!startingEnding.containsKey(option) || lastLetter == option)
                {
                    if(lastLetter == option)
                    {
                        startingEnding.get(lastLetter).get(option).remove(last);
                        if(startingEnding.get(lastLetter).get(option).isEmpty())
                        {
                            System.out.println(last + "!");
                            return;
                        }
                        startingEnding.get(lastLetter).get(option).add(last);
                    }
                    else
                    {
                        System.out.println(last + "!");
                        return;
                    }
                }
            }
            System.out.println(last);
        }
    }
}
