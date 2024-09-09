package AtmNetwork.service.ATM;

import AtmNetwork.model.ATM;

public class ATMPrintFull implements ATMPrintable{
    @Override
    public void print(ATM atm) {
        System.out.println("Full information for ATM");
        System.out.println("Total money : " + atm.getTotalMoney());
    }
}
