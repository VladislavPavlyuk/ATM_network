package Bank;

class Bank {
    public ATM[] atms;

    public Bank(int numberOfATMs) {
        atms = new ATM[numberOfATMs];
        initializeATMs();
    }

    private void initializeATMs() {
        for (int i = 0; i < atms.length; i++) {
            atms[i] = new ATM(5, 40); // Пример значений для минимальной суммы и максимального количества банкнот
        }
    }

    public int getTotalMoneyInNetwork() {
        int total = 0;
        for (ATM atm : atms) {
            total += atm.getTotalMoney();
        }
        return total;
    }

}
