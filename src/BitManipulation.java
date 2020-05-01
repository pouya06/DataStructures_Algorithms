import sun.tools.tree.BinaryBitExpression;
import sun.tools.tree.BinaryExpression;

import java.util.function.BinaryOperator;

public class BitManipulation {

    public static int arithmeticRightShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1;
        }

        return x;
    }

    public static int logicalRightShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1;
        }

        return x;
    }

    public static int convertToBinary(int x) {
        return Integer.valueOf(Integer.toBinaryString(x));
    }
}
