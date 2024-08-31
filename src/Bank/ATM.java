package Bank;
import java.util.HashMap;
import java.util.Map;

// Класс ATM
class ATM {
    private Map<Integer, Integer> banknotes = new HashMap<>();
    private int minWithdrawalAmount;
    private int maxBanknotesDispensed;

    public ATM(int minWithdrawalAmount, int maxBanknotesDispensed) {
        this.minWithdrawalAmount = minWithdrawalAmount;
        this.maxBanknotesDispensed = maxBanknotesDispensed;
        initializeBanknotes();
    }

    private void initializeBanknotes() {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};
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

    public void depositMoney(int denomination, int count) {
        loadMoney(denomination, count);
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

}
