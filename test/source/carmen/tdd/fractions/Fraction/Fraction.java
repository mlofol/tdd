package carmen.tdd.fractions.Fraction;

import java.util.Objects;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int i) {
        this(i, 1);
    }

    public Fraction(int numerator, int denominator) {
        final int gdc = NumberTheory.greatestCommonDenominator(numerator, denominator);
        this.numerator = numerator / gdc;
        this.denominator = denominator / gdc;
    }

    public Fraction plus(Fraction fraction) {
        if (this.denominator != fraction.denominator) {
            return new Fraction(this.numerator * fraction.denominator + fraction.numerator * this.denominator, this.denominator * fraction.denominator);
        }
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
