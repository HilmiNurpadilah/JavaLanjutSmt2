public class CustomException {
    public static void main(String[] args) {
        try {
            validateInput(-5);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateInput(int number) throws InvalidInputException {
        if (number < 0) {
            throw new InvalidInputException("Input tidak boleh negatif.");
        }
    }
}
