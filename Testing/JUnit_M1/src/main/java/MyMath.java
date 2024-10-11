public class MyMath {
    public static double divide(double num1, double num2){
        if(num2 == 0){
            throw new ArithmeticException("Number 1 can't be divided by zero!");
        }

        return num1/num2;
    }
}
