package BinaryNeuralNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class WeightsGenerator
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("/home/rishabh/IdeaProjects/UMDCompPracticeProject/src/BinaryNeuralNetwork/mnist10.txt"));
        Map<Integer, List<AtomicInteger>> numPositive = new HashMap<>();
        Map<Integer, List<AtomicInteger>> numNegative = new HashMap<>();
        for(int i = 0; i < 10; i++)
        {
            numPositive.put(i, new ArrayList<>());
            numNegative.put(i, new ArrayList<>());
            for(int j = 0; j < 51; j++)
            {
                numPositive.get(i).add(new AtomicInteger());
                numNegative.get(i).add(new AtomicInteger());
            }
        }

        while(in.hasNextLine())
        {
            String[] line = in.nextLine().split(" ");
            int value = Integer.parseInt(line[51]);
            for(int i = 0; i < 51; i++)
            {
                int num = Integer.parseInt(line[i]);
                if(num == 1)
                {
                    numPositive.get(value).get(i).incrementAndGet();
                }
                else
                {
                    numNegative.get(value).get(i).incrementAndGet();
                }
            }
        }

        for(int i = 0; i < 10; i++)
        {
            for(int k = 0; k < 15; k++)
            {
                for (int j = 0; j < 51; j++)
                {
                    if (numPositive.get(i).get(j).intValue() > numNegative.get(i).get(j).intValue())
                    {
                        System.out.print("1 ");
                    }
                    else
                    {
                        System.out.print("-1 ");
                    }
                }
                System.out.println();
            }
        }
    }
}
