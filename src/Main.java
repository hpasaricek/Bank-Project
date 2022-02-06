public class Main {

    public static void main(String[] args) {
        Bank rba = new Bank("RBA");

        BankCustomer hrvoje = new BankCustomer(123, "Hrvoje Pasaricek", 100.00);
        BankCustomer ivan = new BankCustomer(456, "Ivan Ivic", 200.00);
        BankCustomer marko = new BankCustomer(789, "Marko Maric", 10.00);

        rba.addCustomerToBank(hrvoje);
        rba.addCustomerToBank(ivan);
        rba.addCustomerToBank(marko);

        rba.displayBankCustomers();

        BankCustomer hrvoje2 = new BankCustomer(123, "Hrvoje Pasaricek", 1000.00);
        rba.addCustomerToBank(hrvoje2);

        rba.modifyBankCustomerName(ivan, "Ivan Ivich");
        rba.displayBankCustomers();

        rba.removeBankCustomer(marko);
        rba.displayBankCustomers();

        Bank pbz = new Bank("PBZ");
        pbz.addCustomerToBank(hrvoje);
        pbz.displayBankCustomers();

        hrvoje.addAmount(50.00);

	}
}
