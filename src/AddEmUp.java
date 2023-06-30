import java.util.*;

public class AddEmUp
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        List<String> cards = new ArrayList<>(Arrays.asList((in.next() + in.nextLine()).split(" ")));

        Map<Character, Character> flippableNumbers = new HashMap<>();
        flippableNumbers.put('1', '1');
        flippableNumbers.put('2', '2');
        flippableNumbers.put('5', '5');
        flippableNumbers.put('6', '9');
        flippableNumbers.put('8', '8');
        flippableNumbers.put('9', '6');
        flippableNumbers.put('0', '0');

        Map<String, String> flip = new HashMap<>();

        int size = cards.size();
        for(int i = 0; i < size; i++)
        {
            String card = cards.get(i);
            boolean flippable = true;
            StringBuilder flipped = new StringBuilder();
            for (char num : card.toCharArray())
            {
                flipped.insert(0, num);
                if (!flippableNumbers.containsKey(num))
                {
                    flippable = false;
                    break;
                }
            }
            if(flippable)
            {
                flip.put(card, flipped.toString());
                flip.put(flipped.toString(), card);
                cards.add(flipped.toString());
            }
        }

        for(String card : cards)
        {
            String requiredCard = String.valueOf(sum - Integer.parseInt(card));
            if(cards.contains(requiredCard) && (!flip.getOrDefault(card, card).equals(requiredCard) || (cards.stream().filter(s -> s.equals(card)).count() > 1 && card.length() != 1 || !flip.get(card).equals(requiredCard) || (cards.stream().filter(s -> s.equals(card)).count() > 2))))
            {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}
