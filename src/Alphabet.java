import java.util.*;

public class Alphabet
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Character[] sequence = Arrays.stream(in.nextLine().split("")).map(c -> new Character(c.charAt(0))).toArray(Character[]::new);
        List<Character> sequenceSet = new ArrayList<>(Arrays.asList(sequence));
        List<Character> alphabet = new ArrayList<>();
        for(char i = 'a'; i <= 'z'; i++)
        {
            alphabet.add(i);
        }
        List<Character> leftovers = new ArrayList<>(sequenceSet);
        while(!leftovers.equals(alphabet))
        {
            System.out.println(Arrays.toString(leftovers.toArray()));
            leftovers.retainAll(alphabet);
        }

    }
}
