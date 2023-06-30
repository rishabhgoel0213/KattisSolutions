package BinaryNeuralNetwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryNeuralNetwork
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/rishabh/IdeaProjects/UMDCompPracticeProject/src/BinaryNeuralNetwork/mnist10.txt"));
        ArgmaxNode network = new ArgmaxNode();
        int x = 0;

        int averageLoss = Integer.MAX_VALUE;
//        Scanner weightsScanner = new Scanner(System.in);
//        int[][] weights = new int[150][51];
//        for(int i = 0; i < 150; i++)
//        {
//            for(int j = 0; j < 51; j++)
//            {
//                weights[i][j] = weightsScanner.nextInt();
//            }
//        }
//
//        network.setWeights(weights);

        int accuracy = 0;
        while (averageLoss > 10000)
        {
            averageLoss = 0;
            in = new Scanner(new File("/home/rishabh/IdeaProjects/UMDCompPracticeProject/src/BinaryNeuralNetwork/mnist10.txt"));
            while (in.hasNextLine())
            {
                x++;
                String[] line = in.nextLine().split(" ");
                int[] input = new int[51];
                for (int i = 0; i < 51; i++)
                {
                    input[i] = Integer.parseInt(line[i]);
                }
                int output = Integer.parseInt(line[51]);
                int testOutput = network.forwardProp(input);
                if(output == testOutput)
                {
                    accuracy++;
                }
                int loss = network.loss(output);
//                if(loss >= 300)
//                {
//                    System.out.println(testOutput + " " + output);
//                    System.out.println(Arrays.toString(weights[output * 15 + 3]));
//                    weights[output * 15 + 3] = input.clone();
//                    System.out.println(Arrays.toString(input));
//                    System.out.println();
//                }
                averageLoss += loss;
                System.out.println(testOutput + " " + output + " " + loss + " " + x + " " + Arrays.toString(input));

            }
            averageLoss /= 60000;
        }

        System.out.println(x);
        System.out.println(accuracy * 100 / x);
//        for(int i = 0; i < 150; i++)
//        {
//            for(int j = 0; j < 51; j++)
//            {
//                System.out.print(weights[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
