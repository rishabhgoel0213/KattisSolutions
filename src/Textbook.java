import java.util.*;

public class Textbook
{
    static Map<Integer, Set<Integer>> prerequisites = new HashMap<>();
    static int[] chapterLengths;

    public static int findMin()
    {
        int min = (int)1e99;
        for(Set<Integer> chapter : prerequisites.values())
        {
            for(Set<Integer> chapter2: prerequisites.values())
            {
                if(!chapter.equals(chapter2))
                {
                    Set<Integer> merged = new HashSet<>();
                    merged.addAll(chapter);
                    merged.addAll(chapter2);
                    int sum = merged.stream().mapToInt(c -> chapterLengths[c - 1]).sum();
                    if(sum < min)
                    {
                        min = sum;
                    }
                }
            }
        }
        return min;
    }


    public static void addAll(int index)
    {
        Set<Integer> recs = prerequisites.get(index);
        for(Integer c : recs)
        {
            addAll(c);
            recs.addAll(prerequisites.get(c));
        }
    }

    public static void cumliatingConcepts()
    {
        int n = prerequisites.size();
        for(int i = 1; i <= n; i++)
        {
            int chapter = i;
            if(prerequisites.entrySet().stream().anyMatch(r -> r.getValue().contains(chapter) && r.getKey() != chapter))
            {
                prerequisites.remove(i);
            }
            else
            {
                prerequisites.get(i).add(i);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        chapterLengths = Arrays.stream((in.next() + in.nextLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 1; i <= n; i++){prerequisites.put(i, new HashSet<>());}
        for(int i = 0; i < m; i++)
        {
            int[] set = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            prerequisites.get(set[1]).add(set[0]);
            addAll(set[1]);
        }

        cumliatingConcepts();
        System.out.println(findMin());

    }
}
