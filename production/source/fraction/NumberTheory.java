package fraction;

public class NumberTheory {
    public static int greatestCommonDenominator(int denominator1, int denominator2) {
        while (denominator2 != 0) {
            int tryWith = denominator2;
            denominator2 = denominator1 % tryWith;
            denominator1 = tryWith;
        }
        return Math.abs(denominator1);
    }
}