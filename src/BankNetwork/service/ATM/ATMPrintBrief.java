package BankNetwork.service.ATM;

import BankNetwork.model.ATM;

public class ATMPrintBrief implements ATMPrintable{
    @Override
    public void print(ATM atm) {
        System.out.println("Brief information for ATM");
        System.out.println("Total money : " + atm.getTotalMoney());
    }
}
