import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Prompt the user for a number
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();  // Read the input as a double
            
            // Check if the number is negative
            if (number < 0) {
                // Throw an exception if the number is negative
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
            }
            
            // Calculate and print the square root
            double result = Math.sqrt(number);
            System.out.println("Square root of " + number + " is: " + result);
        } catch (IllegalArgumentException e) {
            // Handle invalid input for negative numbers
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Handle non-numeric inputs and other unforeseen exceptions
            System.out.println("Error: Invalid input. Please enter a valid number.");
        } finally {
            // Close the scanner resource
            scanner.close();
        }
    }
}
