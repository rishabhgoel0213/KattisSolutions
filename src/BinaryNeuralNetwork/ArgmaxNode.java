package BinaryNeuralNetwork;

import java.util.Arrays;

public class ArgmaxNode
{
    SumNode[] nodes;
    int[] sums;

    public ArgmaxNode()
    {
        nodes = new SumNode[10];
        sums = new int[10];
        for(int i = 0; i < nodes.length; i++)
        {
            nodes[i] = new SumNode();
        }
    }

    public int forwardProp(int[] input)
    {
        int max = -1000;
        int maxIndex = -1;
        int i = 0;
        for(SumNode node : nodes)
        {
            sums[i] = node.forwardProp(input);
            if(sums[i] > max)
            {
                max = sums[i];
                maxIndex = i;
            }
            i++;
        }
        return maxIndex;
    }

    public void backwardProp(int correctOutput, int[] inputs)
    {
        int i = 0;
        for(SumNode node : nodes)
        {
            node.backwardProp(correctOutput, i, inputs);
            i++;
        }
    }

    public int loss(int correctOutput)
    {
        int loss = 0;
        for(int i = 0; i < 10; i++)
        {
            if(i == correctOutput)
            {
                loss += Math.abs(sums[i] - 15);
            }
            else
            {
                loss += Math.abs(sums[i] + 15);
            }
        }

        System.out.print(Arrays.toString(sums) + " ");
        return loss;
    }

    public void setWeights(int[][] weights)
    {
        int i = 0;
        for(SumNode node : nodes)
        {
            node.setWeights(weights, i);
            i += 15;
        }
    }

    public void printWeights()
    {
        for(SumNode node : nodes)
        {
            node.printWeights();
        }
    }

    public int[][] getWeights()
    {
        int[][] weights = new int[150][51];
//        for()
        return weights;
    }
}
