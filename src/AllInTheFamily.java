import java.util.*;

public class AllInTheFamily
{
    public static String end(int n)
    {
        if(n % 10 == 1)
        {
            return "st ";
        }
        else if(n % 10 == 2)
        {
            return "nd ";
        }
        else if(n % 10 == 3)
        {
            return "rd ";
        }
        return "th ";
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int p = in.nextInt();
        Map<String, List<String>> familyTree = new HashMap<>();
        Map<String, List<String>> ancestors = new HashMap<>();
        Set<String> names = new HashSet<>();
        for(int i = 0; i < t; i++)
        {
            String parent = in.next();
            names.add(parent);

            familyTree.put(parent, new ArrayList<>());
            int n = in.nextInt();
            for(int j = 0; j < n; j++)
            {
                String child = in.next();
                names.add(child);

                familyTree.get(parent).add(child);
                ancestors.put(child, new ArrayList<>());
                ancestors.get(child).add(parent);
            }
        }

        List<String> roots = new ArrayList<>(names);
        roots.removeAll(ancestors.keySet());



        for(String child : ancestors.keySet())
        {
            String tracer = ancestors.get(child).get(0);;
            while(!roots.contains(tracer))
            {
                String ancestor = ancestors.get(tracer).get(0);
                ancestors.get(child).add(ancestor);
                tracer = ancestor;
            }
        }

        for(String child : ancestors.keySet())
        {
            ancestors.get(child).add(0, child);
        }

        for(String root : roots)
        {
            ancestors.put(root, Arrays.asList(root));
        }

        for(int i = 0; i < p; i++)
        {
            String a = in.next();
            String b = in.next();

            String parent = a;
            String child = b;
            List<String> commonAncestors = new ArrayList<>(ancestors.get(a));
            commonAncestors.retainAll(ancestors.get(b));
            int m = ancestors.get(a).indexOf(commonAncestors.get(0));
            int n = ancestors.get(b).indexOf(commonAncestors.get(0));
            if(m > n)
            {
                int hold = m;
                m = n;
                n = hold;

                child = a;
                parent = b;
            }

            if(m == 0 && n == 1)
            {
                System.out.println(child + " is the child of " + parent);
            }
            else if(m == 0)
            {
                System.out.print(child + " is the ");
                for(int j = 0; j < n - 2; j++)
                {
                    System.out.print("great ");
                }
                System.out.println("grandchild of " + parent);
            }
            else if(m == n && n == 1)
            {
                System.out.println(a + " and " + b + " are siblings");
            }
            else if(m == n)
            {
                System.out.println(a + " and " + b + " are " + (n - 1) + end(n - 1) + "cousins" );
            }
            else
            {
                String time = " times ";
                if(n - m == 1)
                    time = " time ";
                System.out.println(a + " and " + b + " are " + (m - 1) + end(m - 1) + "cousins, " + (n - m) + time + "removed");
            }
        }
    }
}
