package p1;

import p2.transaction;

public class BankTransaction implements transaction {

    @Override
    public int withdraw(int wd_amt, int total_amt) {
        if (wd_amt > 0 && wd_amt % 100 == 0) {
            if (wd_amt <= total_amt) {
                total_amt -= wd_amt;
                System.out.println("Withdrawn amount: ₹" + wd_amt);
                System.out.println("Balance amount: ₹" + total_amt);
                System.out.println("Transaction completed successfully");
            } else {
                System.out.println("❌ Insufficient balance");
            }
        } else {
            System.out.println("❌ Invalid input");
        }
        return total_amt;
    }

    @Override
    public int payment(float p_amt, int total_amt) {
        if (p_amt > 0 && p_amt <= total_amt) {
            total_amt -= (int)p_amt;
            System.out.println("Payment successful. Balance: ₹" + total_amt);
        } else {
            System.out.println("❌ Insufficient balance");
        }
        return total_amt;
    }

    @Override
    public int deposit(int d_amt, int total_amt) {
        if (d_amt > 0 && d_amt % 100 == 0) {
            total_amt += d_amt;
            System.out.println("Deposited amount: ₹" + d_amt);
            System.out.println("Balance amount: ₹" + total_amt);
            System.out.println("Transaction completed successfully");
        } else {
            System.out.println("❌ Invalid input");
        }
        return total_amt;
    }
}