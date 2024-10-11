import java.util.Arrays;

public class DatasetArrays {
    public static double[] getInputsInRange(double[] inputs, int bottomNumber, int elementsAmount){
        return Arrays.copyOfRange(inputs, bottomNumber, bottomNumber + elementsAmount);
    }

    public static void printSplittedData(double[] trainData, double[] testData){
        System.out.println("\nStage 2: split data on train/test data");
        int numberCorrecter = 1;
        System.out.println("train_data:");
        for(int i = 0; i < trainData.length; ++i){
            System.out.println("x_" + (i+numberCorrecter) + " = " + i +
                    " ; y_" + (i+numberCorrecter) + " = " + trainData[i]);
        }

        numberCorrecter += trainData.length;
        System.out.println("\ntest_data:");
        for(int i = 0; i < testData.length; ++i){
            System.out.println("x_" + (i+numberCorrecter) + " = " + (i+numberCorrecter-1) +
                    " ; y_" + (i+numberCorrecter) + " = " + testData[i]);
        }
    }

    public static void printInputsForTest(Dataset currentDataset) {
        int inputSize = currentDataset.inputs.length;
        double[] inputs = currentDataset.inputs;
        int width = 8; //formatting width to make column straight, ignoring negative sign shift
        System.out.print("(");
        for (int i = 0; i < inputSize; ++i) {
            String formattedValue = String.format("%" + width + ".5f", inputs[i]);
            if (i == inputSize - 1) {
                System.out.print(formattedValue + ") -> ");
                break;
            }
            System.out.print(formattedValue + ", ");
        }
    }
}
