import org.junit.Test;

public class MyMathTest {
    @Test(expected = ArithmeticException.class)
    public void checkByZeroDivision(){
        MyMath.divide(1, 0);
    }
}
