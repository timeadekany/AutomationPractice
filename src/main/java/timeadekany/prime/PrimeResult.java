package timeadekany.prime;

public class PrimeResult {
    int calculatedFor;
    private boolean isTheNumberPrime;
    private Integer closestPrime;

    public PrimeResult(int calculatedFor, boolean isTheNumberPrime) {
        this(calculatedFor, isTheNumberPrime, null);
    }

    public PrimeResult(int calculatedFor, boolean isTheNumberPrime, Integer closestPrime) {
        this.calculatedFor = calculatedFor;
        this.closestPrime = closestPrime;
        this.isTheNumberPrime = isTheNumberPrime;
    }

    public int getCalculatedFor() {
        return calculatedFor;
    }

    public Integer getClosestPrime() {
        return closestPrime;
    }

    public boolean isTheNumberPrime() {
        return isTheNumberPrime;
    }

    @Override
    public String toString() {
        return "The result of prime calculation for " + calculatedFor + " is " + isTheNumberPrime
                + " and the closest prime is " + closestPrime;
    }
}
