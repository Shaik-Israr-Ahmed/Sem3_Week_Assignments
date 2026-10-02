class PiggyBank {
    private int savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(int amount) {
        savings += amount;
    }

    public void withdraw(int amount) {
        if (amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class PiggyBankDemo {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings = " + pb.getSavings());
    }
}