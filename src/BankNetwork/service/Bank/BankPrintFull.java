package BankNetwork.service.Bank;

import BankNetwork.model.Bank;

public class BankPrintFull implements BankPrintable {
    @Override
    public void print(Bank bank) {
        System.out.println("Full information for Bank");
        System.out.println("Total money in the Bank : " + bank.getTotalMoneyInTheBank());
    }
}
