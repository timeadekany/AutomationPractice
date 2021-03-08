package timeadekany.fibonacci;

public class Fibonacci {

    public int calculate(int number) {
        if (number <= 0) {
            return 0;
        } else if (number == 1 || number == 2) {
            return 1;
        } else {
            return calculateNonTrivialCases(number);
        }
    }

    private int calculateNonTrivialCases(int number) {
        int firstNumber = 1;
        int secondNumber = 1;
        int sum = 0;

        try {
            for (int i = 0; i < number - 2; i++) {
                sum = Math.addExact(firstNumber, secondNumber);
                secondNumber = firstNumber;
                firstNumber = sum;
            }
        } catch (ArithmeticException e) {
            System.out.println("Overflow happened");
            return 0;
        }

        return sum;
    }
}
