package BinaryNeuralNetwork;

public class PerceptronNode
{
    int[] weights;
    public PerceptronNode()
    {
        weights = new int[51];
        for(int i = 0; i < 51; i++)
        {
            if(Math.random() < 0.5)
            {
                weights[i] = 1;
            }
            else
            {
                weights[i] = -1;
            }
        }
    }
    public int forwardProp(int[] inputs)
    {
        int value = 0;
        for(int i = 0; i < 51; i++)
        {
            value += weights[i] * inputs[i];
        }
        return (int) Math.signum(value);
    }

    public void backwardProp(int correctOutput, int value, int i, int[] inputs)
    {
        if(correctOutput == i)
        {
            if(value != 1)
            {
                for(int j = 0; j < 51; j++)
                {
                    if(weights[j] * inputs[j] != 1)
                    {
                        weights[j] = -weights[j];
                    }
                }
            }
        }
        else
        {
            if(value != -1)
            {
                for(int j = 0; j < 51; j++)
                {
                    if(weights[j] * inputs[j] != -1)
                    {
                        weights[j] = -weights[j];
                    }
                }
            }
        }
    }

    public void setWeights(int[] weights)
    {
        for(int i = 0; i < 51; i++)
        {
            this.weights[i] = weights[i];
        }
    }

    public void printWeights()
    {
        for(int weight : weights)
        {
            System.out.print(weight + " ");
        }
    }
}
