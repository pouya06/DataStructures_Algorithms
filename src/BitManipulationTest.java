import org.junit.Test;

public class BitManipulationTest {
    @Test
    public void arithmeticRightShift() {
        int result = BitManipulation.arithmeticRightShift(-93242, 40);

        System.out.println("arithmetic: " + result);
        System.out.println("number: " + BitManipulation.convertToBinary(-93242));
    }

    @Test
    public void logicalRightShift() {
        int result = BitManipulation.logicalRightShift(-93242, 40);

        System.out.println("logical: " + result);
    }

    @Test
    public void extraBitTests() {
        System.out.println(Integer.parseInt("1101" , 2));
    }
}