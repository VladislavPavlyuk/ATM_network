package AtmNetwork.service.Bank;

import AtmNetwork.model.Bank;

public class BankPrintBrief implements BankPrintable {
    @Override
    public void print(Bank bank) {
        System.out.println("Brief information for "+ bank.getBankName() + " Bank");
        System.out.println("Total money in the Bank : " + bank.getTotalMoneyInTheBank());
    }
}
