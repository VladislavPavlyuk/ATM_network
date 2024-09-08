package BankNetwork.utils;

import BankNetwork.model.ATM;
import BankNetwork.model.Bank;
import BankNetwork.service.ATM.ATMPrintBrief;
import BankNetwork.service.ATM.ATMPrintFull;
import BankNetwork.service.Bank.BankPrintFull;

import java.util.Random;

public class BankFactory (){
    private final int minATMsInBankNetwork;
    private final int maxATMsInBankNetwork;

    //int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};
String[] bankNames = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth", "Eleventh","Twelfth"};

    public BankFactory(int minATMsInBankNetwork,int maxATMsInBankNetwork) {
        this.minATMsInBankNetwork = minATMsInBankNetwork;
        this.maxATMsInBankNetwork = maxATMsInBankNetwork;
    }

    public static Bank createBank() {
        Bank bank = new Bank(new BankPrintFull());
        bank.atms = 0;
        return bank;
    }
    public static ATM createATM() {
        ATM atm = new ATM(new ATMPrintBrief());
        atm.setDenominations(1, 2, 5, 10, 20, 50, 100, 200, 500);
        return atm;
    }


    public static BankFactory createRandomBankNetwork() {
        Bank bank = createBank();
        createATM();
        Random rand = new Random();

        int choice = rand.nextInt(200);
        ATM result = null;

        switch (choice) {
            case 0:
                result = createATM();
                break;
            case 1:
                result
                break;
        }
        return result;
    }
}
/*
Bank myFirstBank = new Bank(5); // Создаем банк с 5 банкоматами

System.out.println("Общая сумма денег в сети банкоматов: " + myFirstBank.getTotalMoneyInTheBank());

myFirstBank.atms[0].loadMoney(5, 10); // Загружаем деньги в первый банкомат
myFirstBank.atms[0].withdrawMoney(20); // Снимаем деньги из первого банкомата

        System.out.println("Общая сумма денег в сети банкоматов: " + myFirstBank.getTotalMoneyInTheBank());

myFirstBank.atms[1].loadMoney(10, 10); // Загружаем деньги в первый банкомат
myFirstBank.atms[1].withdrawMoney(100); // Снимаем деньги из первого банкомата

        System.out.println("Общая сумма денег в сети банкоматов: " + myFirstBank.getTotalMoneyInTheBank());

myFirstBank.atms[2].loadMoney(20, 10); // Загружаем деньги в первый банкомат
myFirstBank.atms[2].withdrawMoney(200); // Снимаем деньги из первого банкомата

System.out.println("Общая сумма денег в сети банкоматов: " + myFirstBank.getTotalMoneyInTheBank());

myFirstBank.atms[3].loadMoney(50, 10); // Загружаем деньги в первый банкомат
myFirstBank.atms[3].withdrawMoney(200); // Снимаем деньги из первого банкомата

System.out.println("Общая сумма денег в сети банкоматов: " + myFirstBank.getTotalMoneyInTheBank());

myFirstBank.atms[4].loadMoney(100, 10); // Загружаем деньги в первый банкомат
myFirstBank.atms[4].withdrawMoney(200); // Снимаем деньги из первого банкомата

System.out.println("Общая сумма денег в сети банкоматов: " + myFirstBank.getTotalMoneyInTheBank());
*/
