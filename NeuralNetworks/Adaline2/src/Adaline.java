import java.util.List;
import java.util.Random;

/**
 * @author Dmitry Kukharev
 */
public class Adaline {
    Random rnd = new Random();
    private double[] weights;
    private double learningRate;
    private double threshold;

    public Adaline(int inputSize) {
        this.weights = new double[inputSize + 1]; // weights[0] - bias {value: 1}
        this.learningRate = 0.01;
        threshold = 0;

        for (int i = 0; i < weights.length; i++) {
            weights[i] = rnd.nextDouble(-0.5, 0.5);
        }
    }

    public void train(List<Dataset> trainDataset, List<Dataset> testDataset, double learningRate, double errorOptimal, int maxEpoch){
        System.out.println("\nStage 4: train & test model");
        this.learningRate = learningRate;
        for(int epoch = 0; epoch < maxEpoch; ++epoch){
            double trainErrorCurrent = 0;
            double testErrorCurrent;

            for(int i = 0; i < trainDataset.size() - weights.length-1; ++i){
                trainErrorCurrent += trainStepAndReturnError(trainDataset.get(i));
            }

            testErrorCurrent = testAndReturnError(testDataset);
            if(epoch % 100 == 0){
                System.out.println("Epoch: " + epoch +
                        " | train_loss: " + trainErrorCurrent +
                        " | test_loss: " + testErrorCurrent);
                System.out.println("train_loss > optimal_loss (" + errorOptimal + ") -> continue training");
            }
            if(testErrorCurrent < errorOptimal){
                System.out.println("Epoch: " + epoch +
                        " | train_loss: " + trainErrorCurrent +
                        " | test_loss: " + testErrorCurrent);
                System.out.println("test_loss < optimal_loss (" + errorOptimal + ") -> stop training");
                testOutput(trainDataset);
                return;
            }
        }
        System.out.println("Network didn't trained! Try different optimal_loss or learning_rate");
    }

    public double trainStepAndReturnError(Dataset dataset){
        double predictedValue = predict(dataset.inputs);
        changeThreshold(predictedValue, dataset.answer);
        changeWeights(dataset, predictedValue);
        return getCurrentError(predictedValue, dataset.answer);
    }

    public double testAndReturnError(List<Dataset> testDataset){
        double totalError = 0;
        for(int i = 0; i < testDataset.size(); ++i){
            Dataset currentDataset = testDataset.get(i);
            double prediction = predict(currentDataset.inputs);
            double currentError = getCurrentError(prediction, currentDataset.answer);
            totalError += currentError;
        }
        return totalError;
    }

    public void testOutput(List<Dataset> testDataset){
        System.out.println("\nStage 5: print full model outputs for best epoch");
        for(int i = 0; i < testDataset.size(); ++i){
            Dataset currentDataset = testDataset.get(i);
            double prediction = predict(currentDataset.inputs);
            double currentError = getCurrentError(prediction, currentDataset.answer);
            DatasetArrays.printInputsForTest(currentDataset);
            System.out.print(String.format("%.5f", prediction) + "(" + String.format("%.5f", currentDataset.answer) + ") | loss: " + currentError + "\n");
        }
    }

    private double predict(double[] inputs){
        double y = weights[0] - threshold;
        for(int i = 0; i < inputs.length; ++i){
            y += weights[i + 1] * inputs[i];
        }

        return y;
    }

    public void changeWeights(Dataset dataset, double predictedValue){
        weights[0] -= learningRate * (predictedValue - dataset.answer);
        for(int i = 0; i < dataset.inputs.length; ++i){
            weights[i + 1] -= learningRate * (predictedValue - dataset.answer) * dataset.inputs[i];
        }
    }

    public void changeThreshold(double predictedAnswer, double actualAnswer){
        threshold -= learningRate*(predictedAnswer - actualAnswer);
    }

    public double getCurrentError(double predictedAnswer, double actualAnswer){
        return (0.5 * Math.pow((predictedAnswer - actualAnswer), 2));
    }
}
