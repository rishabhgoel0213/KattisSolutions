import java.util.*;
import java.util.stream.Collectors;

public class AltoSinging
{
    public static long compareTo(Set<Long> range, List<Long> transposition)
    {
        for(int i = 0; i < transposition.size(); i++)
        {
            if(!range.contains(transposition.get(i)))
            {
                return transposition.get(i).compareTo(range.stream().max(Long::compareTo).get());
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Map<String, Integer> notes = new HashMap<>();
        notes.put("C", 0);
        notes.put("C#", 1);
        notes.put("D", 2);
        notes.put("D#", 3);
        notes.put("E", 4);
        notes.put("F", 5);
        notes.put("F#", 6);
        notes.put("G", 7);
        notes.put("G#", 8);
        notes.put("A", 9);
        notes.put("A#", 10);
        notes.put("B", 11);


        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine());

        Set<Long> range = new HashSet<>();
        long[] intRange = Arrays.stream(in.nextLine().split(" ")).mapToLong(
                i -> notes.get(i.substring(0, Math.max(i.indexOf('#') + 1, 1)))
                        + 12
                        * (Long.parseLong(i.substring(Math.max(i.indexOf("#") + 1, 1))))).toArray();
        for(long i = intRange[0]; i <= intRange[1]; i++)
        {
            range.add(i);
        }

        List<List<Long>> transpositions = new ArrayList<>();
        transpositions.add(Arrays.stream(in.nextLine().split(" ")).map(
                i -> notes.get(i.substring(0, Math.max(i.indexOf("#") + 1, 1)))
                        + 12
                        * (Long.parseLong(i.substring(Math.max(i.indexOf("#") + 1, 1))))).collect(Collectors.toList()));

        boolean above = false;
        boolean below = false;
        if(compareTo(range, transpositions.get(0)) == 1)
        {
            transpositions.get(0).replaceAll(i -> i - transpositions.get(0).stream().min(Long::compareTo).get() + range.stream().max(Long::compareTo).get());
            above = true;
        }

        if(compareTo(range, transpositions.get(0)) == -1)
        {
            transpositions.get(0).replaceAll(i -> i
                    + range.stream()
                        .min(Long::compareTo)
                        .get()
                    - transpositions.get(0)
                        .stream()
                        .min(Long::compareTo)
                        .get());
            below = true;
        }

        if(above)
        {
            int i = 0;
            while(compareTo(range, transpositions.get(i).stream().map(j -> j - 1).collect(Collectors.toList())) == 0)
            {
                transpositions.add(transpositions.get(i).stream().map(j -> j - 1).collect(Collectors.toList()));
                i++;
            }
        }
        else if(below)
        {
            int i = 0;
            while(compareTo(range, transpositions.get(i).stream().map(j -> j + 1).collect(Collectors.toList())) == 0)
            {
                transpositions.add(transpositions.get(i).stream().map(j -> j + 1).collect(Collectors.toList()));
                i++;
            }
        }
        else
        {
            int i = 0;
            while(compareTo(range, transpositions.get(i).stream().map(j -> j + 1).collect(Collectors.toList())) == 0)
            {
                transpositions.add(transpositions.get(i).stream().map(j -> j + 1).collect(Collectors.toList()));
                i++;
            }

            i = 0;
            while(compareTo(range, transpositions.get(i).stream().map(j -> j - 1).collect(Collectors.toList())) == 0)
            {
                transpositions.add(i + 1, transpositions.get(i).stream().map(j -> j - 1).collect(Collectors.toList()));
                i++;
            }
        }


        long min = Integer.MAX_VALUE;
        long count = 0;
        for(List<Long> tranposed : transpositions)
        {
            int sharpCount = 0;
            for(Long note : tranposed)
            {
                if(note % 12  == 1 || note % 12  == 3 || note % 12  == 6 || note % 12  == 8 || note % 12  == 10)
                {
                    sharpCount++;
                }
            }
            if(sharpCount < min)
            {
                min = sharpCount;
                count = 1;
            }
            else if(sharpCount == min)
            {
                count++;
            }
        }

//        System.out.println(transpositions);
//        System.out.println(range.stream().min(Long::compareTo).get());
//        System.out.println(range.stream().max(Long::compareTo).get());
        System.out.println(min + " " + count);
    }
}
