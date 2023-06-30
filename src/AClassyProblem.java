import java.util.*;

public class AClassyProblem
{
    public static int compareClasses(String class1, String class2)
    {
        if(class1.equals("upper") && class2.equals("middle") || class1.equals("upper") && class2.equals("lower") || class1.equals("middle") && class2.equals("lower"))
        {
            return 1;
        }
        else if(class2.equals("upper") && class1.equals("middle") || class2.equals("upper") && class1.equals("lower") || class2.equals("middle") && class1.equals("lower"))
        {
            return -1;
        }
        return 0;
    }

    public static int comparePeople(String[] class1, String[] class2)
    {
        if(class1.length > class2.length)
        {
            int diff = class1.length - class2.length;
            for(int i = 0; i < class1.length; i++)
            {
                int compare;
                if(i - diff < 0)
                {
                    compare = compareClasses(class1[i], "middle");
                }
                else
                {
                    compare = compareClasses(class1[i], class2[i - diff]);
                }
                switch(compare)
                {
                    case 1:
                        System.out.println(class1[i] + class2[i - diff]);
                        return 1;
                    case -1:
                        System.out.println(class1[i] + class2[i - diff] + " less");
                        return -1;
                }
            }
        }
        else
        {
            int diff = class2.length - class1.length;
            for(int i = 0; i < class2.length; i++)
            {
                int compare;
                if(i - diff < 0)
                {
                    compare = compareClasses("middle", class2[i]);
                }
                else
                {
                    compare = compareClasses(class1[i - diff], class2[i]);
                }
                switch(compare)
                {
                    case 1:
                        System.out.println(class1[i - diff] + class2[i]);
                        return 1;
                    case -1:
                        System.out.println(class1[i - diff] + class2[i] + " less");
                        return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int c = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());

        for(int i = 0; i < c; i++)
        {
            Map<String[], String> classes = new TreeMap<>(AClassyProblem::comparePeople);
            for(int j = 0; j < n; j++)
            {
                String line = in.nextLine();
                int separator = line.indexOf(':');
                int separator2 = line.indexOf(" class");
                String[] classLevel = line.substring(separator + 2, separator2).split("-");
                String name = line.substring(0, separator);
                classes.put(classLevel, name);
            }
            for(String[] person: classes.keySet())
            {
                System.out.println(classes.get(person));
            }
        }
    }
}
