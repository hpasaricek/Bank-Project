public class BankCustomer {
    private final int customerOIB;
    private String customerName;
    private double bankAmount;

    public BankCustomer(int customerOIB, String customerName, double bankAmount) {
        this.customerOIB = customerOIB;
        this.customerName = customerName;
        this.bankAmount = bankAmount;
    }

    public int getCustomerOIB() {
        return customerOIB;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBankAmount() {
        return bankAmount;
    }

    public void deductAmount(double amount) {
        if (bankAmount < amount) {
            System.out.println("Not enough money in account to withdraw.");
        }

        bankAmount -= amount;
        System.out.println("Withdrawn " + amount + " from account.");
    }

    public void addAmount(double amount) {
        bankAmount += amount;
        System.out.println("Added " + amount + " to " + this);
    }

    @Override
    public String toString() {
        return "BankCustomer name: " + customerName + ", BankCustomer OIB: " + customerOIB + ", Bank amount: " + bankAmount;
    }

    @Override
    public int hashCode() {
        return 5 * this.customerName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        BankCustomer bankCustomer = (BankCustomer) obj;
        return this.customerOIB == bankCustomer.customerOIB && this.customerName.equalsIgnoreCase(bankCustomer.customerName);
    }
}
