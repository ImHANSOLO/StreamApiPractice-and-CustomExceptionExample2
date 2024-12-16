class NonIntResultException extends Exception {
    public NonIntResultException(int numerator, int denominator) {
        super(numerator + " divided by " + denominator + " is not an integer");
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        int[] numerators = {10, 7, 6};
        int[] denominators = {2, 2, 4};
        for (int i = 0; i < numerators.length; i++) {
            try {
                int result = divide(numerators[i], denominators[i]);
                System.out.println("Result: " + result);
            } catch (NonIntResultException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
    }

    public static int divide(int numerator, int denominator) throws NonIntResultException {
        if (numerator % denominator != 0) {
            throw new NonIntResultException(numerator, denominator);
        }
        return numerator / denominator;
    }
}
