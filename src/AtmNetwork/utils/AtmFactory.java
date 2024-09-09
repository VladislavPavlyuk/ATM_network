package AtmNetwork.utils;

import AtmNetwork.enums.BankType;
import AtmNetwork.model.ATM;
import AtmNetwork.model.Bank;
import AtmNetwork.service.ATM.ATMPrintBrief;
import AtmNetwork.service.ATM.ATMPrintFull;
import AtmNetwork.service.Bank.BankPrintBrief;
import AtmNetwork.service.Bank.BankPrintFull;

import java.util.ArrayList;
import java.util.Random;

public class AtmFactory{

    private static final Random RANDOM = new Random();
    static int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};

    public AtmFactory() {}

    public static Bank createBank() {
        Bank bank = new Bank(
                RANDOM.nextInt(10),
                BankType.values()[RANDOM.nextInt(BankType.values().length)].toString(),
                BankType.values()[RANDOM.nextInt(BankType.values().length)].getDescription()
        );
        //bank.bankName = BankType.values()[RANDOM.nextInt(BankType.values().length)].toString();
        //bank.bankDescription= BankType.values()[RANDOM.nextInt(BankType.values().length)].getDescription();
        bank.atms = new ArrayList<ATM>().toArray(new ATM[0]);
        return bank;
    }
    public static ATM createATM() {
        ATM atm = new ATM(new ATMPrintBrief());
        atm.setDenominations(denominations);
        return atm;
    }

    public static AtmFactory createRandomAtmNetwork() {
        Bank bank = createBank();
        bank.setBankPrintable( new BankPrintBrief());
        bank.setBankPrintable(new BankPrintFull());
        bank.atms = new ArrayList<ATM>().toArray(new ATM[bank.getAtms()]);
        bank.atms[bank.getAtms()] = createATM();


        int choice = RANDOM.nextInt(2);

        switch (choice) {
            case 0:
                bank.atms[bank.getAtms()].loadMoney(denominations[RANDOM.nextInt(denominations.length)], RANDOM.nextInt(100)); // Загружаем деньги в банкомат
                bank.atms[bank.getAtms()].setATMPrintable(atm1 -> {});
                bank.atms[bank.getAtms()].print();
                break;
            case 1:
                bank.atms[bank.getAtms()].withdrawMoney(RANDOM.nextInt(1000)); // Снимаем деньги из банкомата
                bank.atms[bank.getAtms()].setATMPrintable(atm1 -> {});
                bank.atms[bank.getAtms()].print();
                break;
        }

        return null;
    }
}
