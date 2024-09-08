package BankNetwork.service.Bank;

import BankNetwork.model.Bank;

public class BankPrintBrief implements BankPrintable {
    @Override
    public void print(Bank bank) {
        System.out.println("Brief information for Bank");
        System.out.println("Total money in the Bank : " + bank.getTotalMoneyInTheBank());
    }
}
