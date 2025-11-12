package p2;

public interface transaction {
	int withdraw(int wd_amt, int total_amt);
    int payment(float p_amt, int total_amt);
    int deposit(int d_amt, int total_amt);
}
