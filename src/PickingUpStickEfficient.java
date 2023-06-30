import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickingUpStickEfficient
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> sticks = IntStream.range(1, n).boxed().collect(Collectors.toSet());

    }
}
