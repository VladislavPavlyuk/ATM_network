package AtmNetwork.service.ATM;

import AtmNetwork.model.ATM;

public class ATMPrintBrief implements ATMPrintable{
    @Override
    public void print(ATM atm) {
        System.out.println("Brief information for ATM");
        System.out.println("Total money : " + atm.getTotalMoney());
    }
}
