package BankNetwork.model;

import BankNetwork.Interfaces.IBank;
import BankNetwork.service.Bank.BankPrintable;

public class Bank implements IBank {
    public int[] atms;
    public String bankName;
    public String bankDescription;

    //Set methods
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void setBankDescription(String bankDescription) {
        this.bankDescription = bankDescription;
    }

    //Get methods
    public String getBankName() {
        return bankName;
    }
    public String getBankDescription() {
        return bankDescription;
    }
    public int getAtms() {
        return atms.length - 1;
    }

    public Bank(int numberOfATMs, String bankName, String bankDescription) {
        atms = new ATM[numberOfATMs];
        initializeATMs();
        this.bankName = bankName;
        this.bankDescription = bankDescription;
    }

    private void initializeATMs() {
        for (int i = 0; i < atms.length; i++) {
            atms[i] = new ATM(5, 40); // Пример значений для минимальной суммы и максимального количества банкнот
        }
    }

    public int getTotalMoneyInTheBank() {
        int total = 0;
        for (ATM atm : atms) {
            total += atm.getTotalMoney();
        }
        return total;
    }

    private BankPrintable bankPrintable;

    public Bank(BankPrintable bankPrintable) {
        this.bankPrintable = bankPrintable;
    }

    public void setBankPrintable(BankPrintable bankPrintable) {
        this.bankPrintable = bankPrintable;
    }

    @Override
    public void print() {
        bankPrintable.print(this);
    }

}
