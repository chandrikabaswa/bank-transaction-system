package p1;
import java.util.Scanner;
import p2.transaction;
import p3.Rupees;
import p3.Dollars;
import p4.ValidatePin;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidatePin validator = new ValidatePin();
        transaction transaction = new BankTransaction();

        boolean pinValid = false;

        System.out.print("Enter PIN: ");
        for (int i = 0; i < 3; i++) {
            int pin = sc.nextInt();
            if (validator.check(pin)) {
                pinValid = true;
                break;
            } else {
                if (i < 2) System.out.print("Invalid PIN, try again: ");
            }
        }

        if (!pinValid) {
            System.out.println("❌ Transaction blocked!");
            sc.close();
        }

        System.out.print("Enter initial total amount (₹): ");
        int total_amt = sc.nextInt();

        boolean continueTransaction;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Withdraw (₹)");
            System.out.println("2. Deposit (₹)");
            System.out.println("3. Withdraw ($)");
            System.out.println("4. Deposit ($)");
            System.out.println("5. Payment (₹)");
            System.out.println("6. Show Balance");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw (₹): ");
                    int wdRupees = sc.nextInt();
                    total_amt = transaction.withdraw(wdRupees, total_amt);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit (₹): ");
                    int depRupees = sc.nextInt();
                    total_amt = transaction.deposit(depRupees, total_amt);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw ($): ");
                    double wdDollar = sc.nextDouble();
                    int wdRupeesFromDollar = (int)Dollars.toRupees(wdDollar);
                    total_amt = transaction.withdraw(wdRupeesFromDollar, total_amt);
                    break;

                case 4:
                    System.out.print("Enter amount to deposit ($): ");
                    double depDollar = sc.nextDouble();
                    int depRupeesFromDollar = (int)Dollars.toRupees(depDollar);
                    total_amt = transaction.deposit(depRupeesFromDollar, total_amt);
                    break;

                case 5:
                    System.out.print("Enter amount to pay (₹): ");
                    float payAmt = sc.nextFloat();
                    total_amt = transaction.payment(payAmt, total_amt);
                    break;

                case 6:
                    System.out.println("Balance: ₹" + total_amt);
                    System.out.println("Balance in $: $" + Rupees.toDollars(total_amt));
                    break;

                case 7:
                    System.out.println("✅ Thank you for banking with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }

            System.out.print("Do you want another transaction? (true/false): ");
            continueTransaction = sc.nextBoolean();

        } while (continueTransaction);

        sc.close();
    }
}