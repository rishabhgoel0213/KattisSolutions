package BinaryNeuralNetwork;

public class SumNode
{
    PerceptronNode[] nodes;
    int[] values;
    public SumNode()
    {
        nodes = new PerceptronNode[15];
        values = new int[15];
        for(int i = 0; i < nodes.length; i++)
        {
            nodes[i] = new PerceptronNode();
        }
    }

    public int forwardProp(int[] input)
    {
        int sum = 0;
        int i = 0;
        for(PerceptronNode node : nodes)
        {
            values[i] = node.forwardProp(input);
            sum += values[i];
            i++;
        }
        return sum;
    }

    public void backwardProp(int correctOutput, int i, int[] inputs)
    {
        int j = 0;
        for(PerceptronNode node : nodes)
        {
            node.backwardProp(correctOutput, values[j], i, inputs);
            j++;
        }
    }

    public void setWeights(int[][] weights, int start)
    {
        int i = start;
        for(PerceptronNode node : nodes)
        {
            node.setWeights(weights[i]);
            i++;
        }
    }

    public void printWeights()
    {
        for(PerceptronNode node : nodes)
        {
            node.printWeights();
            System.out.println();
        }
    }
}
