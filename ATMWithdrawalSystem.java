import java.util.Scanner;

public class ATMWithdrawalSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 1000.0;
    
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();
            
            if (pin != CORRECT_PIN) {
                throw new SecurityException("Invalid PIN!");
            }
            
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance!");
            }
            
            balance -= amount;
            System.out.println("Withdrawal successful! You withdrew: $" + amount);
        } catch (SecurityException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            System.out.println("Remaining balance: $" + balance);
            scanner.close();
        }
    }
}
