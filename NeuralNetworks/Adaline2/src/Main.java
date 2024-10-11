import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitry Kukharev
 */
public class Main {
    public static void main(String[] args) {
        final int datasetSize = 60;
        final int dataTrainTestDivider = 40;
        final int inputsAmount = 4;
        handleNeuralNetwork(datasetSize, dataTrainTestDivider, inputsAmount);
    }

    public static void handleNeuralNetwork(int datasetSize, int dataTrainTestDivider, int inputsAmount){
        final double[] data = createData(datasetSize);
        final double[] trainingData = DatasetArrays.getInputsInRange(data, 0, dataTrainTestDivider);
        List<Dataset> trainingDataSet = fillDataset(trainingData, inputsAmount);

        final double[] testData = DatasetArrays.getInputsInRange(data, dataTrainTestDivider - inputsAmount, datasetSize - dataTrainTestDivider);
        List<Dataset> testDataSet = fillDataset(testData, inputsAmount);

        DatasetArrays.printSplittedData(trainingData, testData);
        printPrepairedData(trainingDataSet, testDataSet);

        Adaline network = new Adaline(inputsAmount);
        double learningRate = 0.04;
        double optimalError = 1E-4;
        int maxEpoch = 10000;
        network.train(trainingDataSet, testDataSet, learningRate, optimalError, maxEpoch);
    }

    public static double[] createData(int datasetSize) {
        System.out.println("Stage 1: data preparing");
        double[] outputData = new double[datasetSize];
        double divider = (double) datasetSize / (4 * Math.PI);
        for (int i = 0; i < datasetSize; ++i) {
            outputData[i] = sinFunction(((double)i)/(divider), 4, 7, 0.2);
            System.out.println("x_" + (i+1) + " = " + i +
                    " ; y_" + (i+1) + " = " + outputData[i]);
        }
        return outputData;
    }

    public static List<Dataset> fillDataset(double[] data, int inputsAmount){
        tryFillDataset(inputsAmount, data.length);

        List<Dataset> dataset = new ArrayList<>();
        for(int i = 0; i < data.length - inputsAmount; ++i){
            Dataset nextDataset = nextDataset(data, i, inputsAmount);
            dataset.add(nextDataset);
        }

        return dataset;
    }

    public static void tryFillDataset(int iSize, int dSize){
        try {
            if(iSize > 2*dSize){
                throw new Exception("More data is required");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static Dataset nextDataset(double[] data, int currentPos, int inputsSize){
        Dataset newDataset = new Dataset();
        newDataset.answer = data[currentPos+inputsSize];
        double[] inputs = new double[inputsSize];
        System.arraycopy(data, currentPos, inputs, 0, currentPos + inputsSize - currentPos);

        newDataset.inputs = inputs;
        return newDataset;
    }

    public static double sinFunction(double x, double a, double b, double d){
        return (a * Math.sin(b*x) + d);
    }

    public static void printPrepairedData(List<Dataset> trainDataset, List<Dataset> testDataset){
        System.out.println("\nStage 3: prepare train/test data for NN");
        printDatasetPart(trainDataset, "train_data:");
        System.out.println();
        printDatasetPart(testDataset, "test_data:");
    }

    public static void printDatasetPart(List<Dataset> dataset, String message){
        System.out.println(message);
        for(int i = 0; i < dataset.size(); ++i){
            DatasetArrays.printInputsForTest(dataset.get(i));
            System.out.print(dataset.get(i).answer + "\n");
        }
    }
}