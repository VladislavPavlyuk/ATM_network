package AtmNetwork.model;
import java.util.HashMap;
import java.util.Map;
import AtmNetwork.service.ATM.ATMPrintable;

// Класс ATM
public class ATM implements AtmNetwork.Interfaces.IATM {
    private Map<Integer, Integer> banknotes = new HashMap<>();
    private int minWithdrawalAmount;
    private int maxBanknotesDispensed;
    int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};

    @Override
    public void setDenominations(int... a) {
        for (int i : a) {
            this.denominations = new int[]{i};
        }
    }

    public int[] getDenominations() {
        return denominations;
    }

    public ATM(int minWithdrawalAmount, int maxBanknotesDispensed) {
        try {
            if ((0 < minWithdrawalAmount) && (0 < maxBanknotesDispensed)) {
            this.minWithdrawalAmount = minWithdrawalAmount;
            this.maxBanknotesDispensed = maxBanknotesDispensed;
            initializeBanknotes();
            }
            else
                throw new IllegalArgumentException("Invalid minWithdrawalAmount or maxBanknotesDispensed");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("Finally in ATM constructor called");
        }
    }

    private void initializeBanknotes() {
        for (int denomination : denominations) {
            banknotes.put(denomination, 0);
        }
    }

    public void loadMoney(int denomination, int count) {
        if (banknotes.containsKey(denomination)) {
            banknotes.put(denomination, banknotes.get(denomination) + count);
        } else {
            throw new IllegalArgumentException("Invalid denomination");
        }
    }


    public void withdrawMoney(int amount) {
        if (amount < minWithdrawalAmount) {
            throw new IllegalArgumentException("Amount is less than the minimum withdrawal amount");
        }

        Map<Integer, Integer> dispensedBanknotes = new HashMap<>();
        for (int denomination : banknotes.keySet()) {
            int count = Math.min(amount / denomination, banknotes.get(denomination));
            if (count > 0) {
                dispensedBanknotes.put(denomination, count);
                amount -= count * denomination;
            }
        }

        if (amount > 0) {
            throw new IllegalArgumentException("Cannot dispense the exact amount with available banknotes");
        }

        for (Map.Entry<Integer, Integer> entry : dispensedBanknotes.entrySet()) {
            banknotes.put(entry.getKey(), banknotes.get(entry.getKey()) - entry.getValue());
        }
    }

    public int getTotalMoney() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }
        return total;
    }

    private ATMPrintable atmPrintable;

    public ATM(ATMPrintable atmPrintable) {
        this.atmPrintable = atmPrintable;
    }

    public void setATMPrintable(ATMPrintable atmPrintable) {
        this.atmPrintable = atmPrintable;
    }

    @Override
    public void print() {
        atmPrintable.print(this);
    }
}
