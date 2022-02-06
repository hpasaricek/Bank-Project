import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String bankName;
    private Map<Integer, BankCustomer> bankCustomers = new HashMap<>();

    public Bank(String bankName) {
        this.bankName = bankName;
        System.out.println("Created new Bank: " + this.bankName);
    }

    public void addCustomerToBank(BankCustomer bankCustomer) {
        if (bankCustomerExists(bankCustomer)) {
            System.out.println(bankCustomer + " already exists in Bank: " + bankName);
            return;
        }

        this.bankCustomers.put(bankCustomer.getCustomerOIB(), bankCustomer);
        System.out.println(bankCustomer + " added to Bank: " + bankName);
    }

    public void displayBankCustomers() {
        System.out.println("Customers in Bank: " + bankName);
        for (Map.Entry<Integer, BankCustomer> entry : bankCustomers.entrySet()) {
            System.out.println("BankCustomer OIB: " + entry.getKey() + ", BankCustomer name: " + entry.getValue().getCustomerName());
        }
    }

    public void removeBankCustomer(BankCustomer bankCustomer) {
        if (!bankCustomerExists(bankCustomer)) {
            System.out.println(bankCustomer + " doesn't exist in Bank: " + bankName);
            return;
        }

        bankCustomers.remove(bankCustomer.getCustomerOIB());
        System.out.println("Removed " + bankCustomer + " from Bank: " + bankName);
    }

    public void modifyBankCustomerName(BankCustomer bankCustomer, String newName) {
        if (!bankCustomerExists(bankCustomer)) {
            System.out.println(bankCustomer + " doesn't exist in Bank: " + bankName);
            return;
        }

        bankCustomers.get(bankCustomer.getCustomerOIB()).setCustomerName(newName);
        System.out.println("Changed " + bankCustomer + ". Old name: " + bankCustomer.getCustomerName() + ", new name: " + bankCustomers.get(bankCustomer.getCustomerOIB()).getCustomerName());
    }

    public void depositMoney(BankCustomer customer, double amount) {
        if (bankCustomerExists(customer)) {
             customer.addAmount(amount);
        }
    }

    public void withdrawMoney(BankCustomer customer, double amount) {
        if (bankCustomerExists(customer)) {
            customer.deductAmount(amount);
        }
    }


    private boolean bankCustomerExists(BankCustomer bankCustomer) {
        return bankCustomers.containsValue(bankCustomer);
    }
}
