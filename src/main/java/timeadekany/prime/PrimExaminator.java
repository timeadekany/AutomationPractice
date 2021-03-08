package timeadekany.prime;

public class PrimExaminator {

    public PrimeResult calculateClosestPrime(int number) {
        int remainder = number % 6;

        if (isTheNumberNotPrim(number)) {
            return new PrimeResult(number, false, 2);
        } else if (isTheNumberOneOfTheFirstPrimes(number)) {
            return new PrimeResult(number, true);
        } else if (remainder == 1 || remainder == 5) {
            return new PrimeResult(number, getNumberOfDivisors(number) == 0);
        } else {
            return new PrimeResult(number, getNumberOfDivisors(number) == 0);
        }
    }

    private boolean isTheNumberNotPrim(int number) {
        return (number < 0 || number == 0 || number == 1);

    }

    private boolean isTheNumberOneOfTheFirstPrimes(int number) {
        return  (number == 2 || number == 3);
    }

    private int getNumberOfDivisors(int number) {
        int numberOfDivisors = 0;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                ++numberOfDivisors;
            }
        }

        return numberOfDivisors;
    }
}
