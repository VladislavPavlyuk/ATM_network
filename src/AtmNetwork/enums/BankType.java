package AtmNetwork.enums;

public enum BankType {
      RetailBank("Retail Bank","Banks that offer services to individuals."),
      CommercialBank("Commercial Bank","Banks designed for commercial purposes."),
      InvestmentBank("Investment Bank","Banks that manage investment portfolios."),
      UniversalBank("Universal Bank","Banks that offer a combination of retail, commercial, and investment banking services–all in one place."),
      CreditUnion("Credit Union","Member-owned and non-profit financial institutions."),
      PrivateBank("Private Bank","Banks offering personalized banking services."),
      SavingsAndLoanBank("Savings and Loan Bank","Banks specializing in making mortgage loans."),
      IslamicBank("Islamic Bank","Banks that operate in strict adherence to Islamic law."),
      GreenBank("Green Bank","Banks that focus on funding renewable energy, energy efficiency, and other green initiatives, rather than maximizing profits."),
      ChallengerBank("Challenger Bank","New banks that challenge traditional banking models by offering innovative products and services"),
      Neobank("Neobank","Digital-only banks that operate entirely online with no physical branches");


    private final String bankType;
    private final String description;

    // Constructor
    BankType(String bankType, String description) {
        this.bankType = bankType;
        this.description = description;
    }

    // Getter methods
    public String getBankType() {
        return bankType;
    }
    public String getDescription() {
        return description;
    }
};
