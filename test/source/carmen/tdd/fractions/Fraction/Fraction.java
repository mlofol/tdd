package carmen.tdd.fractions.Fraction;

public class Fraction {
    private int numerator;

    public Fraction(int i) {

        numerator = i;
    }

    public Fraction plus(Fraction fraction) {
        return new Fraction(fraction.intValue() + numerator);
    }

    public int intValue() {
        return numerator;
    }
}
