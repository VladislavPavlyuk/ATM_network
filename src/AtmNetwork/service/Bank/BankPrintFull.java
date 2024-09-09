package AtmNetwork.service.Bank;

import AtmNetwork.model.Bank;

public class BankPrintFull implements BankPrintable {
    @Override
    public void print(Bank bank) {
        System.out.println("Full information for "+ bank.getBankName() + " Bank");
        System.out.println(bank.getBankDescription());
        System.out.println("Total money in the Bank : " + bank.getTotalMoneyInTheBank());
    }
}
