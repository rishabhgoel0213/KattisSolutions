import java.util.*;

public class AdolescentArchitecture
{
    public static boolean fitsOnTop(Map<String, List<Integer>> blocks, List<String> stack, String stackType, String blockType)
    {
        if(stack.size() != 0 && stack.get(stack.size() - 1).split(" ")[0].equals(stackType))
        {
            if(blocks.get(blockType).get(0) * Math.sqrt(2) > Integer.parseInt(stack.get(stack.size() - 1).split(" ")[1]) * 2)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<String, List<Integer>> blocks = new HashMap<>();
        List<String> stack = new ArrayList<>();

        blocks.put("cube", new ArrayList<>());
        blocks.put("cylinder", new ArrayList<>());
        for(int i = 0; i < n; i++)
        {
            String[] line = in.nextLine().split(" ");
            blocks.get(line[0]).add(Integer.parseInt(line[1]));
        }

        blocks.get("cube").sort(Comparator.reverseOrder());
        blocks.get("cylinder").sort(Comparator.reverseOrder());

        while(stack.size() != n)
        {
            if(blocks.get("cylinder").isEmpty())
            {
                if(!fitsOnTop(blocks, stack, "cylinder", "cube"))
                {
                    System.out.println("impossible");
                    return;
                }
                stack.add("cube " + blocks.get("cube").remove(0));
            }
            else if(blocks.get("cube").isEmpty())
            {
                if(!fitsOnTop(blocks, stack, "cube", "cylinder"))
                {
                    System.out.println("impossible");
                    return;
                }
                stack.add("cylinder " + blocks.get("cylinder").remove(0));
            }
            else if(blocks.get("cylinder").get(0) * 2 / Math.sqrt(2) >= blocks.get("cube").get(0))
            {
                if(!fitsOnTop(blocks, stack, "cube", "cylinder"))
                {
                    System.out.println("impossible");
                    return;
                }
                stack.add("cylinder " + blocks.get("cylinder").remove(0));
            }
            else if(blocks.get("cylinder").get(0) * 2 <= blocks.get("cube").get(0))
            {
                if(!fitsOnTop(blocks, stack, "cylinder", "cube"))
                {
                    System.out.println("impossible");
                    return;
                }
                stack.add("cube " + blocks.get("cube").remove(0));
            }
            else
            {
                System.out.println("impossible");
                return;
            }

        }

        for(int i = stack.size() - 1; i >= 0; i--)
        {
            System.out.println(stack.get(i));
        }

    }
}
