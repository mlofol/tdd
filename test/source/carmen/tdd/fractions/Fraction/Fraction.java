package carmen.tdd.fractions.Fraction;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int i) {

        numerator = i;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction plus(Fraction fraction) {
        return new Fraction(fraction.intValue() + numerator, denominator);
    }

    public int intValue() {
        return numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
