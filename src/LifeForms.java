import java.util.ArrayList;
import java.util.Scanner;

public class LifeForms
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = 1;
        while(true)
        {
            boolean permFound = false;
            ArrayList<String> foundPerms = new ArrayList<>();
            foundPerms.add("***");
            n = in.nextInt();
            if(n == 0)
            {
                break;
            }
            String[] sequences = new String[n];
            for(int i = 0; i < n; i++)
            {
                sequences[i] = in.next() + in.nextLine();
            }

            for(int j = 0; j < n; j++)
            {
                String permutation = sequences[j];
                int permutationBeginIndex = 0;
                int permLen = 0;
                while (permutationBeginIndex < sequences[j].length() - 1 && permutation.length() >= permLen)
                {
//                    System.out.println(permutation);
                    int numContains = 1;
                    for (int i = 0; i < n; i++)
                    {
                        if(i != j)
                        {
                            if (sequences[i].contains(permutation))
                            {
                                numContains++;
                            }
                        }
                    }
                    if (numContains > 0.5 * n)
                    {
//                        if(!foundPerms.contains(permutation))
//                        {
                        if(!foundPerms.contains(permutation))
                        {
                            System.out.println(permutation);
                        }
                        foundPerms.add(permutation);

                        permFound = true;
                        permLen = permutation.length();
//                        }

                    }

                    if (permutationBeginIndex + permutation.length() == sequences[j].length())
                    {
                        permutationBeginIndex = 0;
                        permutation = sequences[j].substring(0, permutation.length() - 1);
                    }
                    else
                    {
                        permutationBeginIndex++;
                        permutation = sequences[j].substring(permutationBeginIndex, permutation.length() + 1);
                    }


                }
            }
            if(!permFound)
            {
                System.out.println("?");
            }
            System.out.println();
        }

    }
}
