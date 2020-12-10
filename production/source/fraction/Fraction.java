package fraction;

import java.util.Objects;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int i) {
        this(i, 1);
    }

    public Fraction(int numerator, int denominator) {
        final int signDenominator = denominator < 0 ? -1 : 1;
        final int gdc = NumberTheory.greatestCommonDenominator(numerator, denominator) * signDenominator;

        this.numerator = numerator / gdc;
        this.denominator = denominator / gdc;
    }

    public Fraction plus(Fraction fraction) {
        return new Fraction(this.numerator * fraction.denominator + fraction.numerator * this.denominator, this.denominator * fraction.denominator);
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

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            return numerator == otherFraction.numerator &&
                    denominator == otherFraction.denominator;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
